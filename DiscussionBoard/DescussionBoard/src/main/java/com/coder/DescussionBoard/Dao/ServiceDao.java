package com.coder.DescussionBoard.Dao;

import java.util.List;

import com.coder.DescussionBoard.Entity.Comment;
import com.coder.DescussionBoard.Entity.Comments;
import com.coder.DescussionBoard.Entity.Issues;

 public interface ServiceDao {

    List<Issues> getAllIssues();
	List<Comments> getAllComments();
	void addIssue(Issues issue);
	void addComment(Comment comment);
	void updateIssue(Issues issue);
	void updateComment(Comment comment);
	void deleteIssue(Issues issue);
	void deleteComment(Comments comment);
	Issues getIssue(int id);
	Comments getComment(int id);
	List<Comments> getCommentsByIssuesId(int id);
	List<Comments> getCommentsView();
}
