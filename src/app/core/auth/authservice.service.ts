import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { User } from 'src/app/models/user';
import { Users } from 'src/app/models/users';
@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {
  private users='http://localhost:8080/blogs/user';
  constructor(private http: HttpClient) { }

  setUser(user: User) {
    localStorage.setItem('currentUser', JSON.stringify(user));
  }

  getUser(): Users | null {
    const user = localStorage.getItem('currentUser');
    return user ? JSON.parse(user) : null;
  }


  loginUser(email: string, password: string) {
    let loginInput = {
      "email": email,
      "password": password
    };

    return this.http.post("http://localhost:8080/users/login", loginInput, { responseType: 'text' })
      .pipe(
        catchError(error => {
          console.error("Login failed:", error);
          return throwError(() => new Error('Login failed'));
        })
      );
  }
}
