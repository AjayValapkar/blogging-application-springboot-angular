import { Component, OnInit } from '@angular/core';
import { BlogserviceService } from 'src/app/core/blog/blogservice.service';
import { Post } from 'src/app/models/post';

@Component({
  selector: 'app-blogs',
  templateUrl: './blogs.component.html',
  styleUrls: ['./blogs.component.css']
})
export class BlogsComponent implements OnInit {
  posts: Post[] = [];
  numBlog = 3;
  displayedPosts: Post[] = [];
  selectedCategoryId: number =0;

  constructor(private blogsservice: BlogserviceService) { }

  ngOnInit(): void {
    this.blogsservice.getAllBlog().subscribe(data => {
      this.posts = data;
      this.displayedPosts = this.posts.slice(0, this.numBlog);

    });
  }

  loadBlogs() {
    console.log("button working")
    this.numBlog += 1;
    console.log(this.numBlog)
    this.displayedPosts = this.posts.slice(0, this.numBlog);
  }
  loadBlogsCategory(categoryId: number) {
    console.log(categoryId)
    this.blogsservice.getPostByCategory(categoryId).subscribe(data => {
      console.log(categoryId)
      console.log("This working categiry ")
      this.posts = data;
      console.log(this.posts)
      this.displayedPosts = this.posts;

    });
  }
  onCategorySelect(categoryId: number) {
    this.loadBlogsCategory(categoryId);
  }


}
