import { Component, OnInit, OnChanges } from '@angular/core';
import { AuthenticationService } from 'src/app/Service/authentication.service';
import { Router } from '@angular/router';
import { DataService } from 'src/app/Service/data.service';
import { Issue } from 'src/app/Issue';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private dataService: DataService, private authenticationService: AuthenticationService, private router: Router) { }
 
  public search: string = '';
  public filteredIssues: Issue[];
  public issues: Issue[];
  public issue: Issue = null;

  ngOnInit() {
    this.dataService.getAllIssues().subscribe(data =>
      {this.issues = data, this.setFilteredIssues(this.issues)});
      // this.filteredIssues = this.filteredIssues.filter((issue) => {
      // issue.title.includes(this.search)})
      // this.issue=this.filteredIssues[0]
      // this.filteredIssues = null
      // this.filteredIssues.push(this.issue)

  }

  setFilteredIssues(issues: Issue[]){
    this.filteredIssues = issues
  }

  onSearchChange(searchIssue: Issue[]): void {
    // this.issues =  searchIssue
    // this.dataService.changeSearch(this.issues)
    // console.log(this.search);
  }

  // onSearchChange(searchValue: string): void {
  //   this.search =  searchValue
  //   this.dataService.changeSearch(this.search)
  //   console.log(this.search);
  // }

  logoutService(){
    this.authenticationService.logoutService()
    this.router.navigate(['/'])
  }

  clickSearch(){
    this.router.navigate(['/board', this.search])

  }
}
