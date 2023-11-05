import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { LoginComponent } from '../../auth/login/login.component';
import { AuthserviceService } from 'src/app/core/auth/authservice.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  
  ngOnInit() {
    // Access this.currentUser.firstName to display the first name in your template
  }
}
