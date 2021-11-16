package application;

public class Message {
	
	private String message_receiver;
	private String subject_line;
	private String text;
	private Patient sender;
	
	// constructor
	public Message(String m, String s, String t, Patient p)
	{
		this.message_receiver = m;
		this.subject_line = s;
		this.text = t;
		this.sender = p;
	}
	
	// setters 
	public void set_receiver(String name)
	{
		this.message_receiver = name;
	}
	
	public void set_subject_line(String subject_line)
	{
		this.subject_line = subject_line;
	}
	
	public void set_text(String text)
	{
		this.text = text;
	}
	
	public void set_sender(Patient sender)
	{
		this.sender = sender;
	}
	
	public Patient get_sender()
	{
		return this.sender;
	}
	public String get_text()
	{
		return text;
	}
	public String get_reciever()
	{
		return message_receiver;
	}
	public String get_subject()
	{
		return subject_line;
	}

}
