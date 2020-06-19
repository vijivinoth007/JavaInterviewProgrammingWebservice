package dao;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Comment {
	
	String emailid;
	String name;
	String comment;
	String dateandtime;

	
	public Comment(String emailid, String name, String comment, String dateandtime) {
		this.emailid = emailid;
		this.name = name;
		this.comment = comment;
		this.dateandtime = dateandtime;
	}

	public Comment()
	{
		
	}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDateandtime() {
		return dateandtime;
	}
	public void setDateandtime(String dateandtime) {
		this.dateandtime = dateandtime;
	}

	@Override
	public String toString() {
		return "Comment [emailid=" + emailid + ", name=" + name + ", comment=" + comment + ", dateandtime="
				+ dateandtime + "]";
	}

}
