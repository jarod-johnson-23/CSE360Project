package application;

import java.util.List;

public class Doctor {
	private String name;
	private String username;
	private String password;
	private Patient[] patients;
	private int loginIndex;
	private List<Message> messages;
	
	// constructor
	public Doctor(String name2, String username2, String password2, Patient[] patients2, int loginIndex2, List<Message> messages) {
		this.name = name2;
		this.username = username2;
		this.password = password2;
		this.patients = patients2;
		this.loginIndex = loginIndex2;
		this.messages = messages;
	}

	public void addPatient(Patient newPatient) 
	{
		int i = 0;
		while(patients[i].getFName() != null) 
		{
			i++;
		}
		patients[i] = newPatient;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public Patient getPatient(int index) 
	{
		return patients[index];
	}
	
	public int getIndex() 
	{
		return loginIndex;
	}
	
	public void addMessage(Message message)
	{
		messages.add(message);
	}
}

