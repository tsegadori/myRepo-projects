package com.coder.DescussionBoard.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coder.DescussionBoard.Dao.ServiceDao;
import com.coder.DescussionBoard.Entity.Comment;
import com.coder.DescussionBoard.Entity.Comments;
import com.coder.DescussionBoard.Entity.Issues;

@RestController
@CrossOrigin(origins="*", maxAge = 3600)
public class ApiController {

	@Autowired
	ServiceDao serviceDao;
	
	@GetMapping("/discussion-board/issues")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Issues> getAllIssues() {
		return this.serviceDao.getAllIssues();
	}
	
	@GetMapping("/discussion-board/comments")
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Comments> getAllComments() {
		return this.serviceDao.getAllComments();
	}
	
	@GetMapping("/discussion-board/issues/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Issues getIssue(@PathVariable int id){
		return this.serviceDao.getIssue(id);
	}
	
	@GetMapping("/discussion-board/comments-by-issues/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Comments> getCommentsByIssue(@PathVariable int id){
		return this.serviceDao.getCommentsByIssuesId(id);
	}
	
	@GetMapping("/discussion-board/comments/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Comments getComment(@PathVariable int id){
		return this.serviceDao.getComment(id);
	}
	
	@GetMapping("/discussion-board/comments-view")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Comments> getCommentsView(){
		return this.serviceDao.getCommentsView();
	}
	
	@PostMapping("/discussion-board/issues")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void addIssue(@RequestBody Issues issue){
		 this.serviceDao.addIssue(issue);
	}
	
	@RequestMapping(value = "/discussion-board/comments", method=RequestMethod.POST)
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void addComment(@RequestBody Comment comment){
		 this.serviceDao.addComment(comment);
	}
	
	@PutMapping("/discussion-board/issues")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void updateIssue(@RequestBody Issues issue){
		 this.serviceDao.updateIssue(issue);
	}
	
	@PutMapping("/discussion-board/comments")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void updateComment(@RequestBody Comment comment){
		 this.serviceDao.updateComment(comment);
	}
	
	@DeleteMapping("/discussion-board/issues/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void deleteIssue(@PathVariable int id){
		Issues i = this.serviceDao.getIssue(id);
		 this.serviceDao.deleteIssue(i);
	}
	
	@DeleteMapping("/discussion-board/comments/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public void deleteComment(@PathVariable int id){
		Comments c = this.getComment(id);
		this.serviceDao.deleteComment(c);
	}
	
	}
