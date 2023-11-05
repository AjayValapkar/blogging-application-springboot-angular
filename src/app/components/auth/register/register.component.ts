import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user: User = {
    firstname: '', lastnanme: '', email: '', password: '',
    userId: 0
  };

  constructor(private http: HttpClient, private router: Router) { }

  register() {
    let registerData = {
      "firstname": this.user.firstname,
      "lastname": this.user.lastnanme,
      "email": this.user.email,
      "password": this.user.password
    };

    this.http.post("http://localhost:8080/users/register", registerData)
      .pipe(
        catchError(error => {
          this.router.navigate(['/login'])
          console.error("Registration failed:", error);
          return throwError(() => new Error('Registration failed')); // Use a factory function
        })
      )
      .subscribe(
        (resultData: any) => {
          console.log(resultData);
        }
      );
  }
}
