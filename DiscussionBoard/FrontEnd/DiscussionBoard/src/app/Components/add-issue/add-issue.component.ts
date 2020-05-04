import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/Service/data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-issue',
  templateUrl: './add-issue.component.html',
  styleUrls: ['./add-issue.component.css']
})
export class AddIssueComponent implements OnInit {

  constructor(private dataService: DataService, private route: Router) { }

  public date: string;
  public today = new Date();
  public dd = String(this.today.getDate()).padStart(2, '0');
  public mm = String(this.today.getMonth() + 1).padStart(2, '0'); //January is 0!
  public yyyy = this.today.getFullYear();
  public active: boolean = true;

  ngOnInit() {
    this.date = this.yyyy + '-' + this.mm + '-' + this.dd;
  }

  submitIssue(newissueForm){
    console.log(newissueForm);
    this.dataService.setIssue(newissueForm).subscribe();
    this.route.navigate(['/'])
  }
}
