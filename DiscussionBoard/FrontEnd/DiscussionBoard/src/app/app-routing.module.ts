import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BoardComponent } from './Components/board/board.component';
import { LoginPageComponent } from './Components/login-page/login-page.component';
import { SignupPageComponent } from './Components/signup-page/signup-page.component';
import { CommentFormComponent } from './Components/comment-form/comment-form.component';
import { AddIssueComponent } from './Components/add-issue/add-issue.component';

const routes: Routes = [
  {path: "", component: BoardComponent},
  {path: "board/:search", component: BoardComponent},
  {path: "signup", component: SignupPageComponent},
  {path: "login", component: LoginPageComponent},
  {path: "comment-form", component: CommentFormComponent},
  {path: "issue-form", component: AddIssueComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
