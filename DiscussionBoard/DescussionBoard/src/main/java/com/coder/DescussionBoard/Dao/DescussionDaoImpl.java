package com.coder.DescussionBoard.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coder.DescussionBoard.Entity.Comment;
import com.coder.DescussionBoard.Entity.Comments;
import com.coder.DescussionBoard.Entity.Issues;

@Repository
public class DescussionDaoImpl implements DiscussionDao {

	@Autowired
	private EntityManager em;
	List<Issues> issues = new ArrayList<Issues>();
	List<Comments> comments = new ArrayList<Comments>();

	@Override
	public List<Issues> getAllIssues() {
		this.issues = (List<Issues>) em.createQuery("SELECT i FROM Issues i", Issues.class).getResultList();
		return this.issues;
	}

	@Override
	public List<Comments> getAllComments() {
		this.comments = (List<Comments>) em.createQuery("SELECT c FROM Comments c", Comments.class).getResultList();
		return this.comments;
	}

	@Override
	@Transactional
	public void addIssue(Issues issue) {
		this.em.persist(issue);
	}

	@Override
	@Transactional
	public void addComment(Comment comment) {
//		Comments c = new Comments();
//		Issues i = new Issues();
//		int id = comment.getIssues().getId();
//		i = this.em.find(Issues.class, id);
//	 	comment.setIssues(i);
		this.em.persist(comment);
//		System.out.println(comment.getId());
		System.out.println(comment.getDescription());
//		System.out.println(comment.isActive());
		System.out.println(comment.getIssues().getId());

	}

	@Override
	public Issues getIssue(int id) {
		return this.em.find(Issues.class, id);
	}
	
	@Override
	public Comments getComment(int id) {
		return this.em.find(Comments.class, id);
	}
	
	@Override
	@Transactional
	public void updateIssue(Issues issue) {
		this.em.merge(issue);
	}

	@Override
	@Transactional
	public void updateComment(Comment comment) {
		this.em.merge(comment);
	}

	@Override
	@Transactional
	public void deleteIssue(Issues issue) {
		this.em.remove(issue);
	}

	@Override
	@Transactional
	public void deleteComment(Comments comment) {
		this.em.remove(comment);
	}

	@Override
	public List<Comments> getCommentsByIssuesId(int id) {
		Issues i = this.getIssue(id);
 		 Query query = this.em.createQuery("Select c From Comments c Where c.issues = :issue");
 	      query.setParameter("issue", i);
 	      List<Comments> resultList = query.getResultList();
 		 return resultList;
	}

	@Override
	public List<Comments> getCommentsView() {
		 Query query = this.em.createQuery("Select c From CommentsView c");
	      List<Comments> resultList = query.getResultList();
		 return resultList;
	}

}
