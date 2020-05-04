import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/Service/data.service';
import { Issue } from 'src/app/Issue';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  constructor(private dataService: DataService) { }

  public storage: Issue[];
  public count: number;

  ngOnInit() {
    const test = this.dataService.getAllIssues().pipe(map(response => {this.storage = response}))
    // this.dataService.getAllIssues().subscribe(response => 
    //   {this.storage = response,
    // this.setCount(this.storage)});
      
      console.log("-------test-------> "+test)
   //   console.log("-------Out callback-------> "+this.count)

    }

  setCount(y: Issue[]){
    this.storage = y.filter(issue => (issue.title.includes("x")))
    console.log("------callback filtered-------> Expected: 1, Actual: "+this.storage.length)
  }
}
