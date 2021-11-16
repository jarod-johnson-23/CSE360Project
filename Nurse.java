package application;

import java.util.List;

public class Nurse {
	private String fName;
	private String lName;
	private String username;
	private String password;
	private String email;
	private List<Message> messages;
	
	// constructor
	public Nurse(String fName, String lName, String username, String password, String email, List<Message> messages) 
	{
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.messages = messages;
	}
	
	public void addMessage(Message message)
	{
		messages.add(message);
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setFName(String f) {
		fName = f;
	}
	
	public void setLName(String l) {
		lName = l;
	}
	
	public void setUsername(String u) {
		username = u;
	}
	
	public void setPassword(String p) {
		password = p;
	}
	
	public void setEmail(String e) {
		email = e;
	}
}
