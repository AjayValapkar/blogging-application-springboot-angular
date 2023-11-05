import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { NewblogComponent } from './components/blogs/newblog/newblog.component';
import { BlogslistComponent } from './components/blogs/blogslist/blogslist.component';
import { NavbarComponent } from './components/common/navbar/navbar.component';
import { DashboardComponent } from './components/user/dashboard/dashboard.component';
import { ProfileComponent } from './components/user/profile/profile.component';
import { CategoryComponent } from './components/common/category/category.component';
import { HomeComponent } from './components/common/home/home.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { UserblogComponent } from './components/user/userblog/userblog.component';
import { AllblogsComponent } from './components/common/allblogs/allblogs.component';
import { FooterComponent } from './components/common/footer/footer.component';
import { SuccessfullComponent } from './components/common/successfull/successfull.component'
import {  MdbModalService } from 'mdb-angular-ui-kit/modal';
import { EditblogComponent } from './components/blogs/editblog/editblog.component';
import { BlogprofileComponent } from './components/blogs/blogprofile/blogprofile.component';
import { BlogsComponent } from './components/common/blogs/blogs.component';
import { CommentComponent } from './components/common/comment/comment.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    NewblogComponent,
    BlogslistComponent,
    NavbarComponent,
    DashboardComponent,
    ProfileComponent,
    CategoryComponent,
    HomeComponent,
    UserblogComponent,
    AllblogsComponent,
    FooterComponent,
    SuccessfullComponent,
    EditblogComponent,
    BlogprofileComponent,
    BlogsComponent,
    CommentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatIconModule,
  ],
  providers: [
    LoginComponent,
    MdbModalService,
    NewblogComponent,
    SuccessfullComponent,
    EditblogComponent,
    BlogslistComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
