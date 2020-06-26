package dao;

import java.util.List;

public interface QuestionDao {

	 List<Question> getListofPrograms(String key);

	int addProgram(Question obj,String modulename);

	int deleteProblem(int id, String module);
	
	 List<Comment> getListofComments();
		
	 int addComment(Comment obj);
	 
	int addCommentforNewTable(Newcomment obj);

	List<Newcomment> getListofCommentsWithTime(String name, String time);

	int addSubCommentforNewTable(Newcomment cmd);

	List<Newcomment> getListofNewComments(String pagename);



}