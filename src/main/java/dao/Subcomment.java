package dao;

public class Subcomment 
{
	public String getPagetimestamp() {
		return pagetimestamp;
	}
	public void setPagetimestamp(String pagetimestamp) {
		this.pagetimestamp = pagetimestamp;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public Subcomment() {
	}
	@Override
	public String toString() {
		return "Subcomment [pagetimestamp=" + pagetimestamp + ", sno=" + sno + ", name=" + name + ", email=" + email
				+ ", comments=" + comments + ", timestamp=" + timestamp + "]";
	}
	
	public Subcomment(String pagetimestamp, int sno, String name, String email, String comments, String timestamp) {
 		this.pagetimestamp = pagetimestamp;
		this.sno = sno;
		this.name = name;
		this.email = email;
		this.comments = comments;
		this.timestamp = timestamp;
	}

	String pagetimestamp;
	int sno;
	String name;
	String email;
	String comments;
	String timestamp;
}
