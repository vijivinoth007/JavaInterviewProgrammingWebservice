package dao;

public class Question {
	

	private int id;	
	private String question;
	private String explanation;
	private String answer;
	private String output;
	
	
	public Question(int id, String question, String explanation, String answer,String output) {
		this.id = id;
		this.question = question;
		this.explanation = explanation;
		this.answer = answer;
		this.output=output;
	}
	
	public Question()
	{
		
	}
	
	/* (non-Javadoc)
	 * @see dao.ProblemDao#getId()
	 */
	public int getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see dao.ProblemDao#setId(int)
	 */
	public void setId(int id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see dao.ProblemDao#getQuestion()
	 */
	public String getQuestion() {
		return question;
	}
	/* (non-Javadoc)
	 * @see dao.ProblemDao#setQuestion(java.lang.String)
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/* (non-Javadoc)
	 * @see dao.ProblemDao#getExplanation()
	 */
	public String getExplanation() {
		return explanation;
	}
	/* (non-Javadoc)
	 * @see dao.ProblemDao#setExplanation(java.lang.String)
	 */
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	/* (non-Javadoc)
	 * @see dao.ProblemDao#getAnswer()
	 */
	public String getAnswer() {
		return answer;
	}
	/* (non-Javadoc)
	 * @see dao.ProblemDao#setAnswer(java.lang.String)
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	/* (non-Javadoc)
	 * @see dao.ProblemDao#toString()
	 */
	
	/* (non-Javadoc)
	 * @see dao.ProblemDao#hashCode()
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((explanation == null) ? 0 : explanation.hashCode());
		result = prime * result + id;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see dao.ProblemDao#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (explanation == null) {
			if (other.explanation != null)
				return false;
		} else if (!explanation.equals(other.explanation))
			return false;
		if (id != other.id)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

}
