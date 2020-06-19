package com.example.Interviewwebservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.Comment;
import dao.Question;
import dao.QuestionDao;

@CrossOrigin( origins = "*" )
@RestController
public class InterviewResource {
	
	
	@Autowired
	private QuestionDao interviewproblem ;	
	
	@GetMapping(path="/problem/{modulename}")
	public ResponseEntity<List<Question>> getListOfProblems(@PathVariable String modulename)
	{
		List<Question> list=interviewproblem.getListofPrograms(modulename);
		if (list == null)
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(list,HttpStatus.OK);
	}
	
	@PostMapping(path="/problem/{modulename}")
	public ResponseEntity<List<Question>> AddnewProblem(@PathVariable String modulename,@RequestBody Question question)
	{
		System.out.println(question.getId());
		System.out.println("module"+modulename);
		int i=interviewproblem.addProgram(question,modulename);
		System.out.println("i value"+i);
		List<Question> list=interviewproblem.getListofPrograms(modulename);
		
		if (i==0)
		{
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity(list,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/problem/{modulename}/{id}")
	public ResponseEntity<List<Question>> DeleteaProblem(@PathVariable String modulename,@PathVariable int id)
	{
		System.out.println("Delete mapping");
		int i=interviewproblem.deleteProblem(id, modulename);
		List<Question> list=interviewproblem.getListofPrograms(modulename);
		if (i==0)
		{
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		else
			 return new ResponseEntity(list,HttpStatus.OK);
	}
	
	@GetMapping(path="/comment")
	public ResponseEntity<List<Comment>> getListOfComment()
	{
		List<Comment> list=interviewproblem.getListofComments();
		Collections.reverse(list);
		if (list == null)
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(list,HttpStatus.OK);
	}
	
	@PostMapping(path="/comment")
	public ResponseEntity<List<Question>> AddnewComment(@RequestBody Comment cmd)
	{
		System.out.println("comment +"+cmd.getComment());
		int i=interviewproblem.addComment(cmd);
		System.out.println("i value"+i);
		List<Comment> list=interviewproblem.getListofComments();
		Collections.reverse(list);
		if (i==0)
		{
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity(list,HttpStatus.OK);
	}
	
	@GetMapping(path="/allproblems")
	public ResponseEntity<List<Question>> getAllProblems()
	{
		List<Question> list=new ArrayList<Question>();
		list.addAll(interviewproblem.getListofPrograms("arraysandstring"));
		list.addAll(interviewproblem.getListofPrograms("treesandgraph"));
		list.addAll(interviewproblem.getListofPrograms("linkedlist"));
		list.addAll(interviewproblem.getListofPrograms("sortingandsearching"));
		list.addAll(interviewproblem.getListofPrograms("recursion"));
		list.addAll(interviewproblem.getListofPrograms("design"));
		list.addAll(interviewproblem.getListofPrograms("dynamicproblem"));
		
		if (list == null)
		{
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(list,HttpStatus.OK);
	}
	
	
}
