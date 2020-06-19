package dao;

import java.util.List;

public interface QuestionDao {

	 List<Question> getListofPrograms(String key);

	int addProgram(Question obj,String modulename);

	int deleteProblem(int id, String module);
	
	 List<Comment> getListofComments();
		
	 int addComment(Comment obj);


}