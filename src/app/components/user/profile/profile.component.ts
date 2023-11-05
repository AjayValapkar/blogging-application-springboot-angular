import { Component } from '@angular/core';
import { AuthserviceService } from 'src/app/core/auth/authservice.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  user: User | null;

  constructor(private authService: AuthserviceService) {
    this.user = this.authService.getUser();
    console.log(this.user?.firstname);
  }
  
}
