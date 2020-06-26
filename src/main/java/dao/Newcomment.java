package dao;

public class Newcomment 
{	
	public String getPagename() {
		return pagename;
	}
	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Newcomment() {
	}
	public Newcomment(String pagename, int sno, String email, String name, String comments, String timestamp) {
		this.pagename = pagename;
		this.sno = sno;
		this.email = email;
		this.name = name;
		this.comments = comments;
		this.timestamp = timestamp;
	}
	
	String pagename;
	int sno;
	String email;
	String name;
	String comments;
	String timestamp;
	
	
	@Override
	public String toString() {
		return "Newcomment [pagename=" + pagename + ", sno=" + sno + ", email=" + email + ", name=" + name
				+ ", comments=" + comments + ", timestamp=" + timestamp + "]";
	}

}
