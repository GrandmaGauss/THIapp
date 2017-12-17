package user;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class messageBean {
	private String username;
	private String inhalt;
	private String user;
	private Timestamp date;
	
	public void setusername(String username) {
		this.username = username;
	}
	public String getusername() {
		return username;
	}
	
	public void setinhalt(String inhalt) {
		this.inhalt = inhalt;
	}
	public String getinhalt() {
		return inhalt;
	}
	
	public void setuser(String user) {
		this.user = user;
	}
	public String getuser() {
		return user;
	}
	
	public void setDate(Timestamp date) {
		this.date= date;
	}
	
	public Timestamp getDate() {
		return date;
	}
	
}
