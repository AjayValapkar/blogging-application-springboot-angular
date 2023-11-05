import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from 'src/app/models/category';
import { Post } from 'src/app/models/post';
import { User } from 'src/app/models/user';
import { AuthserviceService } from '../auth/authservice.service';

@Injectable({
  providedIn: 'root'
})
export class BlogserviceService {


  private categoryUrl = 'http://localhost:8080/users/blogs/category';
  private users = 'http://localhost:8080/blogs/user';


  user: User | null;

  constructor(private authService: AuthserviceService, private Http: HttpClient) {
    this.user = this.authService.getUser();
  }

  getUserByEmail(userdata: string): Observable<User> {
    const url = `${this.users}/email/${userdata}`;
    return this.Http.get<User>(url);
  }

  getAllBlog(): Observable<Post[]> {
    return this.Http.get<Post[]>('http://localhost:8080/blogs/');
  }

  getUserPost(blogId: number, categoryid: number): Observable<Post> {
    return this.Http.get<Post>('http://localhost:8080/blogs/' + blogId + '/category/' + categoryid);
  }
  getCategory(): Observable<Category[]> {
    return this.Http.get<Category[]>(this.categoryUrl)
  }
  getUserPosts(userid: number): Observable<Post[]> {
    return this.Http.get<Post[]>(this.users + '/' + userid);
  }
  deletePost(blogid: number) {
    return this.Http.delete('http://localhost:8080/blogs/' + blogid);
  }

  getPostByCategory(categoryId: number): Observable<Post[]>{
    console.log(categoryId)
    return this.Http.get<Post[]>('http://localhost:8080/blogs/'+categoryId);
  }




}
