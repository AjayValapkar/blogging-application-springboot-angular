import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthserviceService } from 'src/app/core/auth/authservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user:User={
    firstname: '', lastnanme: '', email: '', password: '',
    userId: 0
  };

  constructor(private loginService: AuthserviceService, private router: Router) { }

  login() {
    this.loginService.loginUser(this.user.email, this.user.password)
      .subscribe(
        (resultData: any) => {
          if (typeof resultData === 'string' && resultData.startsWith('User successfully login')) {
            this.loginService.setUser(this.user);
            console.log("Login successful:", resultData);
            this.router.navigate(['/dashboard/bloglist']);
          } else {
            console.error("Login failed:", resultData);
          }
        }
      );
  }



}
