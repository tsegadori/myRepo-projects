package com.coder.DescussionBoard.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coder.DescussionBoard.Entity.Comment;
import com.coder.DescussionBoard.Entity.Comments;
import com.coder.DescussionBoard.Entity.Issues;

@Service
public class ServiceDaoImpl implements ServiceDao {

	@Autowired
	DiscussionDao sd;
	
	@Override
	public List<Issues> getAllIssues() {
		return this.sd.getAllIssues();
	}

	@Override
	public List<Comments> getAllComments() {
 		return this.sd.getAllComments();
	}

	@Override
	public void addIssue(Issues issue) {
		this.sd.addIssue(issue);
	}

	@Override
	public void addComment(Comment comment) {
		this.sd.addComment(comment);
	}

	@Override
	@Transactional
	public void updateIssue(Issues issue) {
		this.sd.updateIssue(issue);		
	}

	@Override
	@Transactional
	public void updateComment(Comment comment) {
		this.sd.updateComment(comment);
	}

	@Override
	@Transactional
	public void deleteIssue(Issues issue) {
		this.sd.deleteIssue(issue);
	}

	@Override
	@Transactional
	public void deleteComment(Comments comment) {
		this.sd.deleteComment(comment);
	}

	@Override
	@Transactional
	public Issues getIssue(int id) {
		return this.sd.getIssue(id);
	}

	@Override
	@Transactional
	public Comments getComment(int id) {
		return this.sd.getComment(id);
	}

	@Override
	public List<Comments> getCommentsByIssuesId(int id) {
 		return this.sd.getCommentsByIssuesId(id);
	}

	@Override
	public List<Comments> getCommentsView() {
		return this.sd.getCommentsView();
	}

}
