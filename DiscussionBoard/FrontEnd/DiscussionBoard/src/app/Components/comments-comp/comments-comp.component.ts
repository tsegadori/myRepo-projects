import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { AuthenticationService } from 'src/app/Service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-comments-comp',
  templateUrl: './comments-comp.component.html',
  styleUrls: ['./comments-comp.component.css']
})
export class CommentsCompComponent implements OnInit, OnChanges {

  constructor(private router: Router, private authenticationService: AuthenticationService) { }
  
  public icomments: Comment;

  @Input() public comments: Comment;
  @Input() public issueId: number;

  ngOnChanges() {
      
   }

  ngOnInit() {
    this.icomments = this.comments
  }
  
  private showForm: boolean = false;

  addComment(){
      this.router.navigate(['/comment-form'])
  }

  showCommentForm(){
      this.showForm = true;
  }
}
