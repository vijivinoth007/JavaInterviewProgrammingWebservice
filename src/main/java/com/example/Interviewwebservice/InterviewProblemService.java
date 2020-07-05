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
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import dao.Comment;
import dao.Newcomment;
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

	
	@Override
	public int addCommentforNewTable(Newcomment obj) 
	{
		String date=new Date().toString();
		String query="insert into commentnew values ("+"'"+obj.getPagename()+"'"+","+"'"+obj.getSno()+"'"+","+"'"+obj.getEmail()+"'"+","+"'"+obj.getName()+"'"+","+"'"+obj.getComments()+"'"+","+"'"+date+"'"+")";
		System.out.println(query);
		return jdbctemplate.update(query);	
	}
	

	@Override
	public List<Newcomment> getListofNewComments(String pagename) 
	{
		System.out.println("Trying to get all new comments");

		return jdbctemplate.query("select * from commentnew where pagename="+"'"+pagename+"'"+" ", new ResultSetExtractor<List<Newcomment>>(){
			@Override
			public List<Newcomment> extractData(ResultSet rs) throws SQLException,DataAccessException
			{		
				List<Newcomment> li=new ArrayList<Newcomment>();
				 while (rs.next()) 
				 {
					 Newcomment q=new Newcomment(rs.getString("pagename"),rs.getInt("sno"),rs.getString("email"),rs.getString("name"),rs.getString("comments"),rs.getString("timestamp"));
					 li.add(q);
				 }
				 return li;
			}
		});		
	}
	
	

	@Override
	public List<Newcomment> getListofCommentsWithTime(String name,String time) {
		System.out.println("Trying to get all sub comments+"+name+"+"+time);
//where pagetimestamp="+"'"+time+"'"+" and name="+"'"+name+"'"+" 
		return jdbctemplate.query("select * from subcomment" , new ResultSetExtractor<List<Newcomment>>(){
			@Override
			public List<Newcomment> extractData(ResultSet rs) throws SQLException,DataAccessException
			{		
				List<Newcomment> li=new ArrayList<Newcomment>();
				 while (rs.next())
				 {
					 Newcomment q=new Newcomment(rs.getString("pagetimestamp"),rs.getInt("sno"),rs.getString("name"),rs.getString("email"),rs.getString("comments"),rs.getString("timestamp"));
					 li.add(q);
				 }
				 return li;
			}
		});				
	}

	@Override
	public int addSubCommentforNewTable(Newcomment obj) {
		String date=new Date().toString();
		String query="insert into subcomment values ("+"'"+obj.getPagename()+"'"+","+"'"+obj.getSno()+"'"+","+"'"+obj.getName()+"'"+","+"'"+obj.getEmail()+"'"+","+"'"+obj.getComments()+"'"+","+"'"+date+"'"+")";
		System.out.println(query);
		return jdbctemplate.update(query);			
	}
	
	
	@Override
	public List<Question> getListOfProblemsWithID(String key,int id) 
	{
		System.out.println("Trying to get a problem"+key);

		return jdbctemplate.query("select * from "+key+" where id="+id+" ", new ResultSetExtractor<List<Question>>(){
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
	public List<Newcomment> getListofNewCommentsWithPageNameandID(String pagename, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
