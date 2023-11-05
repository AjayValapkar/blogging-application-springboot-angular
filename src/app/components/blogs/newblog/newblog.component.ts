import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { BlogserviceService } from 'src/app/core/blog/blogservice.service';
import { Category } from 'src/app/models/category';
import { Post } from 'src/app/models/post';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { AuthserviceService } from 'src/app/core/auth/authservice.service';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-newblog',
  templateUrl: './newblog.component.html',
  styleUrls: ['./newblog.component.css']
})
export class NewblogComponent implements OnInit {

  user: User | null | undefined;
  category: Category[] = [];
  blog: Post = {
    title: '',
    content: '',
    category: new Category,
    blogId: 0,
    categoryid: 0
  }

  constructor(private blogservice: BlogserviceService, private router:Router, 
    private http: HttpClient, private authservice: AuthserviceService) {

  }
  ngOnInit(): void {
    this.blogservice.getCategory().subscribe(data => {
      this.category = data
    })
  }
  postBlog() {
    this.user = this.authservice.getUser();
    if (this.user && this.user.email) {
      this.blogservice.getUserByEmail(this.user.email).subscribe({
        next: user => {
          this.user = user

          let postData = {
            "title": this.blog.title,
            "content": this.blog.content
          }
          const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
          const userId = user.userId
          const categoryId = this.blog.category.categoryid;

          this.http.post('http://localhost:8080/blogs/user/' + userId + '/category/' + categoryId + '/posts', postData, { headers: headers }).pipe(
            catchError(error => {
              console.log(postData);
              console.error("Post Upload Failed:", error);
              return throwError(() => new Error('Registration failed'));
            })
          )
            .subscribe(
              (resultData: any) => {
                this.router.navigate(['/dashboard/blogslist'])
                console.log(resultData);
              }
            );
        }
      })
    }
  }


}
