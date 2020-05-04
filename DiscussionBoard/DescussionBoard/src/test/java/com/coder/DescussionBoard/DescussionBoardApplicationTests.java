package com.coder.DescussionBoard;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.coder.DescussionBoard.Dao.ServiceDao;
import com.coder.DescussionBoard.Entity.Issues;

@SpringBootTest
class DescussionBoardApplicationTests {
 
	@Autowired
	private ServiceDao d;
	
	@Test
	@Transactional
	//@Rollback(false)
	void contextLoads() {
		//System.out.println("---->"+d.getAllIssues().get(0).getDescription());
		Issues issue = new Issues();
		//issue.setId(3);
		/*issue.setTitle("Spring Data");
		issue.setDescription("I have set up a couple of unit tests, and am using the @Transactional "
				+ "annotation on the test class. The tests run, but the data they write "
				+ "is always rolled back.");
		issue.setDate(new Date());
		issue.setActive(true); */
		issue = this.d.getIssue(2);
		this.d.deleteIssue(issue);
	}

}
