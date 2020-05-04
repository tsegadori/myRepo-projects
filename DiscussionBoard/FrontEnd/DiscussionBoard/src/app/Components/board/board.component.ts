import { Component, OnInit, OnChanges, NgZone } from '@angular/core';
import { DataService } from 'src/app/Service/data.service';
import { Router, ActivatedRoute } from '@angular/router';
import {Issue} from 'src/app/Issue';
import { AuthenticationService } from 'src/app/Service/authentication.service';
 declare var $: any;


@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent implements OnInit {

  constructor(private  activatedRoute: ActivatedRoute, private dataService: DataService
    , private router: Router, private _ngZone: NgZone, private authenticationService: AuthenticationService) {
    //To trick the Router into reloading the component on each routerLink click, you can use the following code in your Component
  //  this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    this.newSearch = '';
   }

  public issues: Issue[] = new Array();
  public hide: boolean = false;
  public commentId: number = 0;
  public newSearch: string;
  public issue: Issue;
  public temp: Issue[] = new Array();
  public filteredIssues: Issue[];

  ngOnInit() {
    this.newSearch = this.activatedRoute.snapshot.params['search'];
    if(this.newSearch===undefined){
      this.dataService.getAllIssues().subscribe(data => {this.filteredIssues = data})
    }
     if(!(this.newSearch===undefined)){
      
       this.newSearch = this.newSearch.toString()
       let s1 = this.newSearch.substr(0,1).toUpperCase()
       let s2 = this.newSearch.substr(1, this.newSearch.length)
       let search = s1.concat(s2)
       this.dataService.getAllIssues().subscribe(data => {this.filteredIssues = data; 
       this.setFilteredIssues(this.filteredIssues, search)});
    }
   // this.newSearch ='';

  }

  searchIssue(issues: Issue[], search: string){
    
    this.filteredIssues = issues.filter(
      (issue) => issue.title.startsWith(search)) 
  }
  
  setSearch(search){
    this.filteredIssues = search
  }

  setFilteredIssues(issues: Issue[], search: string){
    this.filteredIssues = issues.filter(issue => (issue.title.startsWith(search)))
    if(this.setFilteredIssues.length===0){
    //  search = search.toLowerCase();
      this.filteredIssues = issues.filter(issue => (issue.title.includes(search)))
    }
  }

  addIssue(){
    this.router.navigate(["/issue-form"])
  }

 commentVisiblity(id) {
      var x = document.getElementById(id);
      if(x===null){
        return;
      }
          if (x.style.display === "none") {
            x.style.display = "block";
          } else {
            x.style.display = "none";
      }

  }
}
