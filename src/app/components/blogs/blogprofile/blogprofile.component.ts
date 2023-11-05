import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/models/category';
import { Post } from 'src/app/models/post';
import { User } from 'src/app/models/user';
import { BlogslistComponent } from '../blogslist/blogslist.component';
import { AuthserviceService } from 'src/app/core/auth/authservice.service';
import { Router } from '@angular/router';
import { BlogserviceService } from 'src/app/core/blog/blogservice.service';
import { HttpClient } from '@angular/common/http';
import { EditblogComponent } from '../editblog/editblog.component';

@Component({
  selector: 'app-blogprofile',
  templateUrl: './blogprofile.component.html',
  styleUrls: ['./blogprofile.component.css']
})
export class BlogprofileComponent  implements OnInit{

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
  ngOnInit(){
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
}
