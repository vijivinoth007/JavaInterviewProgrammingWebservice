package com.example.Interviewwebservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.Question;
import dao.QuestionDao;

public class InterviewProblem {
	
	private final QuestionDao QuestionDao;
	
	@Autowired
	public InterviewProblem(@Qualifier("db") QuestionDao questionDao )
	{
		this.QuestionDao=questionDao;
	}

}
