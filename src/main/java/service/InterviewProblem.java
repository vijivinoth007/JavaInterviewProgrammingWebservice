package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import dao.Question;

@Service
public class InterviewProblem {
	
	public static List<Question> list=new ArrayList<Question>();
	public static Map<String,List<Question>>  hashmap=new HashMap();
	
	static
	{
		hashmap.put("vinoth", list);
	}
	
	
	public List<Question> getListofPrograms(String key)
	{
		return hashmap.get(key);	
	}

}
