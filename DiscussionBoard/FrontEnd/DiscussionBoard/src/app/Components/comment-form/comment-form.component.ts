import { Component, OnInit, Input } from '@angular/core';
import { Comment } from 'src/app/Comment';
import { DataService } from 'src/app/Service/data.service';
import { Router } from '@angular/router';
import { Issue } from 'src/app/Issue';
 
@Component({
  selector: 'app-comment-form',
  templateUrl: './comment-form.component.html',
  styleUrls: ['./comment-form.component.css']
})
export class CommentFormComponent implements OnInit {

  constructor(private dataService: DataService, private route: Router) { }

  @Input() public issueid: number;
  public id: number;
  public comment: NewComment = new NewComment();
  public active: Boolean = true
  public date: Date// = new Date()
  public newIssue: CustIssue = new CustIssue();

  ngOnInit() {
    this.id = this.issueid;
    this.newIssue.id = 3;
    this.comment.issues.id = this.issueid
  }

  submitComment(newUserForm){
 
    let temp: string = this.id.toString()
   this.comment = newUserForm
    this.dataService.setComment(this.comment).subscribe()
    var x = document.getElementById(temp);
    x.style.display = "none";
    console.log(this.comment)
    this.route.navigate([''])
  }

}

 export class NewComment{
     id: number;
     description: string;
     date: Date;
     active: boolean;
     issues: CustIssue = new CustIssue();
 }

 export class CustIssue{
   id: number;
 }

