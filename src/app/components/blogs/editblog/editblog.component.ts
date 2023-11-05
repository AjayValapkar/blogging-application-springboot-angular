import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthserviceService } from 'src/app/core/auth/authservice.service';
import { BlogserviceService } from 'src/app/core/blog/blogservice.service';
import { Category } from 'src/app/models/category';
import { Post } from 'src/app/models/post';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-editblog',
  templateUrl: './editblog.component.html',
  styleUrls: ['./editblog.component.css']
})
export class EditblogComponent implements OnInit {
  user: User | null | undefined;
  category: Category[] = [];
  blog: Post = {
    blogId: 0,
    categoryid: 0,
    title: '',
    content: '',
    category: new Category
   
  }
  post: Post | null | undefined
  blogid: number = 0;
  caregoryId: number = 0
  constructor(private authService: AuthserviceService, private router: Router, private route: ActivatedRoute,
    private Http: HttpClient, private postService: BlogserviceService) {


  }

  ngOnInit(): void {
    this.postService.getCategory().subscribe(data => {
      this.category = data
    })
    this.route.queryParams.subscribe(params => {
      this.blogid = params['blogid'];
      this.caregoryId = params['cateId'];
    });
    console.log(this.blogid);
    console.log(this.caregoryId);
    this.user = this.authService.getUser();
    if (this.user && this.user.email) {
      this.postService.getUserByEmail(this.user.email).subscribe({
        next: user => {
          this.user = user;
          console.log(user);

          this.postService.getUserPost(this.blogid,this.caregoryId).subscribe({
            next: (posts: Post) => {
              this.blog = posts;
            },
            error: error => {
              console.error('Error fetching user posts:', error);
            }
          });
        },
        error: error => {
          console.error('Error fetching user by email:', error);
        }
      });
    }
  }
  updateBlog() {
    this.user = this.authService.getUser();
    if (this.user && this.user.email) {
      this.postService.getUserByEmail(this.user.email).subscribe({
        next: user => {
          this.user = user
          let blogDat = {
            "title": this.blog.title,
            "content": this.blog.content
          }
          const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
          const userId = user.userId
          const categoryId = this.blog.category.categoryid;
          this.Http.put('http://localhost:8080/blogs/user/'+userId+'/category/'+categoryId+'/update/'+this.blogid, blogDat, { headers: headers }).pipe(
            catchError(error => {
              console.log(blogDat);
              console.error("Post Upload Failed:", error);
              return throwError(() => new Error('Registration failed'));
            })
          )
            .subscribe(
              (resultData: any) => {
                console.log(resultData);
                this.router.navigate(['/dashboard/blogslist'])
              }
            );
        }
      })
    }
  }

}
