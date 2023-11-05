import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarComponent } from './components/common/navbar/navbar.component';
import { LoginComponent } from './components/auth/login/login.component';
import { HomeComponent } from './components/common/home/home.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { DashboardComponent } from './components/user/dashboard/dashboard.component';
import { ProfileComponent } from './components/user/profile/profile.component';
import { BlogslistComponent } from './components/blogs/blogslist/blogslist.component';
import { NewblogComponent } from './components/blogs/newblog/newblog.component';
import { EditblogComponent } from './components/blogs/editblog/editblog.component';
import { BlogprofileComponent } from './components/blogs/blogprofile/blogprofile.component';
import { BlogsComponent } from './components/common/blogs/blogs.component';
import { UserblogComponent } from './components/user/userblog/userblog.component';
import { CommentComponent } from './components/common/comment/comment.component';

const routes: Routes = [
  { path: 'navbar', component: NavbarComponent },
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'blogs', component: BlogsComponent, children: [
      { path: 'commnet', component: CommentComponent }
    ]
  },
  {
    path: 'dashboard', component: DashboardComponent, children: [
      { path: 'userblog', component: UserblogComponent },
      { path: 'blogprofile', component: BlogprofileComponent },
      { path: 'editblog', component: EditblogComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'bloglist', component: BlogslistComponent },
      { path: 'newblog', component: NewblogComponent }
    ]
  },
  { path: '**', redirectTo: 'HomeComponent' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
