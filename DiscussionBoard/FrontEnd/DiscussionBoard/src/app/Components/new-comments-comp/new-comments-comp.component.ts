import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/Service/authentication.service';
import { DataService } from 'src/app/Service/data.service';
import { Issue } from 'src/app/Issue';
import { Comment } from 'src/app/Comment';


@Component({
  selector: 'app-new-comments-comp',
  templateUrl: './new-comments-comp.component.html',
  styleUrls: ['./new-comments-comp.component.css']
})
export class NewCommentsCompComponent implements OnInit {

  constructor(private router: Router, private authenticationService: AuthenticationService,
    private dataService: DataService) {
      this.router.routeReuseStrategy.shouldReuseRoute = () => false;
     }

  public comment: CommentView;

  @Input() public comments: Comment;
  @Input() public issueId: number;
  private commentsOfIssues: CommentView[];
  private showForm: boolean = false;
  private id: any;
  
  ngOnInit() {

     this.id = this.issueId
     console.log("--->> "+this.id)
     this.dataService.getCommentsView().subscribe(data => 
       {this.commentsOfIssues = data, this.setFilteredComments(this.commentsOfIssues,this.id),
        console.log(this.commentsOfIssues)})
  }
//this.setFilteredComments(this.commentsOfIssues, this.id), 
  setFilteredComments(comments: CommentView[], id: number){
    this.commentsOfIssues = comments.filter(com => (com.issueId===1))//.filter(c => (c.issueId===id))
  }


  addComment(){
      this.router.navigate(['/comment-form'])
  }

  showCommentForm(){
      this.showForm = true;
  }
}

export class CommentView{
   id: number;
   description: string;
   date:Date;
   active: boolean;
   issueId: number;
}