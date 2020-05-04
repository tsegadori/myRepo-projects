import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Issue } from '../Issue';
import { Comment } from '../Comment';
import { BehaviorSubject, Observable } from 'rxjs';
import { CommentView } from '../Components/new-comments-comp/new-comments-comp.component';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  public issues: Issue[] = new Array();

  setIssue(issue: Issue){
    return this.http.post('http://localhost:8080/discussion-board/issues', issue)
  }

  setComment(comment: Comment){
    return this.http.post<any>('http://localhost:8080/discussion-board/comments', comment)
   }

  updateIssue(issue: Issue){
    this.http.put('http://localhost:8080/discussion-board/issues', issue)
  }

  updateComment(comment: Comment){
    this.http.put('http://localhost:8080/discussion-board/comments', comment)
  }

  getAllIssues(){
    return  this.http.get<Issue[]>('http://localhost:8080/discussion-board/issues')
  }

  getCommentsView(){
    return  this.http.get<CommentView[]>('http://localhost:8080/discussion-board/comments-view')
  }

  getCommentsByIssue(id){// Observable<any> {
    //let params = new HttpParams().set('id', id);

    return  this.http.get<Comment[]>('http://localhost:8080/discussion-board/comments-by-issues',
     id)
    }

  // getCommentsByIssue(id): Observable<any> {
  //   let params = new HttpParams().set('id', id);

  //   return  this.http.get<Comment[]>('http://localhost:8080/discussion-board/comments-by-issues', { params: params })
  // }
}
