package com.example.Interviewwebservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import dao.Comment;
import dao.Question;
import dao.QuestionDao;

@Repository("db")
public class InterviewProblemService implements QuestionDao {

	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public InterviewProblemService(JdbcTemplate jdbctemp)
	{
		this.jdbctemplate=jdbctemp;
	}
		
	@Override
	public List<Question> getListofPrograms(String key) 
	{
		System.out.println("Trying to get a problem"+key);

		return jdbctemplate.query("select * from "+key+"", new ResultSetExtractor<List<Question>>(){
			@Override
			public List<Question> extractData(ResultSet rs) throws SQLException,DataAccessException
			{		
				List<Question> li=new ArrayList<Question>();
				 while (rs.next())
				 {
					 Question q=new Question(rs.getInt("id"), rs.getString("question"), rs.getString("explanation"), rs.getString("answer"),rs.getString("output"));
					 li.add(q);
				 }
				 return li;
			}
		});		
	}
	@Override
	public int addProgram(Question obj,String modulename) {
		System.out.println("Trying to update a problem");
		String query="insert into "+modulename+" values ("+"'"+obj.getExplanation()+"'"+","+"'"+obj.getAnswer()+"'"+","+obj.getId()+","+"'"+obj.getQuestion()+"'"+","+"'"+obj.getOutput()+"'"+")";
		System.out.println(query);
		return jdbctemplate.update(query);
	}
	
	@Override
	public int deleteProblem(int id,String module)
	{
		System.out.println("Trying to delete a problem");

		String query="Delete from "+module+" where id="+id+"";
		return jdbctemplate.update(query);
	}

	@Override
	public List<Comment> getListofComments() 
	{
		System.out.println("Trying to get all comments");

		return jdbctemplate.query("select * from comment", new ResultSetExtractor<List<Comment>>(){
			@Override
			public List<Comment> extractData(ResultSet rs) throws SQLException,DataAccessException
			{		
				List<Comment> li=new ArrayList<Comment>();
				 while (rs.next())
				 {
					 Comment q=new Comment(rs.getString("emailid"), rs.getString("name"), rs.getString("comment"), rs.getString("dateandtime"));
					 li.add(q);
				 }
				 return li;
			}
		});		
	}

	@Override
	public int addComment(Comment obj) 
	{
		String date=new Date().toString();
		String query="insert into comment values ("+"'"+obj.getEmailid()+"'"+","+"'"+obj.getName()+"'"+","+"'"+obj.getComment()+"'"+","+"'"+date+"'"+")";
		System.out.println(query);
		return jdbctemplate.update(query);	
	}
	

}
