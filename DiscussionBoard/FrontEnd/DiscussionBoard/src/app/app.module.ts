import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Components/header/header.component';
import { BodyComponent } from './Components/body/body.component';
import { MenuComponent } from './Components/menu/menu.component';
import { BoardComponent } from './Components/board/board.component';
import { AdvertComponent } from './Components/advert/advert.component';
import { FooterComponent } from './Components/footer/footer.component';
import { DataService } from './Service/data.service';
import { CommentsCompComponent } from './Components/comments-comp/comments-comp.component';
import { UserFormComponent } from './Components/user-form/user-form.component';
import { LoginPageComponent } from './Components/login-page/login-page.component';
import { FormsModule }    from '@angular/forms';
import { SignupPageComponent } from './Components/signup-page/signup-page.component';
import { CommentFormComponent } from './Components/comment-form/comment-form.component';
import { TestComponent } from './Components/test/test.component';
import { NewCommentsCompComponent } from './Components/new-comments-comp/new-comments-comp.component';
import { AddIssueComponent } from './Components/add-issue/add-issue.component';
import { JwtModule } from '@auth0/angular-jwt';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BodyComponent,
    MenuComponent,
    BoardComponent,
    AdvertComponent,
    FooterComponent,
    CommentsCompComponent,
    UserFormComponent,
    LoginPageComponent,
    SignupPageComponent,
    CommentFormComponent,
    TestComponent,
    NewCommentsCompComponent,
    AddIssueComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: function  tokenGetter() {
             return localStorage.getItem('access_token');
        },
        whitelistedDomains: ['localhost:8080']
        //,blacklistedRoutes: ['http://localhost:8080/api/auth/signin', 'http://localhost:8080/discussion-board/issues']
      }
    }) 
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
