import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { AuthserviceService } from 'src/app/core/auth/authservice.service';
import { BlogserviceService } from 'src/app/core/blog/blogservice.service';
import { Category } from 'src/app/models/category';
import { throwError } from 'rxjs';
import { Post } from 'src/app/models/post';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';
import { EditblogComponent } from '../editblog/editblog.component';

@Component({
  selector: 'app-blogslist',
  templateUrl: './blogslist.component.html',
  styleUrls: ['./blogslist.component.css']
})
export class BlogslistComponent implements OnInit {
  posts: Post[] = [];
  post: Post | null | undefined
  user: User | null | undefined;
  blog: Post = {
    title: '',
    content: '',
    category: new Category,
    blogId: 0,
    categoryid: 0
  }

  constructor(private authService: AuthserviceService, private router: Router, private editblog: EditblogComponent,
    private Http: HttpClient, private postService: BlogserviceService) {


  }

  ngOnInit() {
    this.getPosts();
  }
  getPosts(){
    this.user = this.authService.getUser();
    if (this.user && this.user.email) {
      this.postService.getUserByEmail(this.user.email).subscribe({
        next: user => {
          this.user = user;
          console.log(user)
          this.postService.getUserPosts(this.user.userId).subscribe({
            next: (posts: Post[]) => {
              this.posts = posts;
              console.log(posts)
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
  
  delete(blogId: number) {
   const msg="success"
    const blogid = blogId;
    console.log(blogid);
    this.postService.deletePost(blogid).subscribe({
      next: msg=>{
        msg=msg;
        console.log(msg)
      }
    });
  }

}
