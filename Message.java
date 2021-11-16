package application;

public class Message {

	private String message_receiver;    // Receiver of message
	private String subject_line;        // Subject line of message
	private String text;                // Text of message
	private Patient sender;             // Sender of message

	public Message()
	{
		this.message_receiver = null;
		this.subject_line = null;
		this.text = null;
		this.sender = null;
	}

	// Constructor
	public Message(String m, String s, String t, Patient p)
	{
		this.message_receiver = m;
		this.subject_line = s;
		this.text = t;
		this.sender = p;
	}

	//---------------------------------------------------------------------------------------------------
	// SETTER METHODS

	// Sets the receiver of the message
	public void set_receiver(String name)
	{
		this.message_receiver = name;
	}

	// Sets the subject line of the message
	public void set_subject_line(String subject_line)
	{
		this.subject_line = subject_line;
	}

	// Sets the text of the message
	public void set_text(String text)
	{
		this.text = text;
	}

	// Sets the sender of the message
	public void set_sender(Patient sender)
	{
		this.sender = sender;
	}

	//---------------------------------------------------------------------------------------------------
	// GETTER METHODS

	// Gets the receiver of the message
	public String getMessage_receiver() {
		return this.message_receiver;
	}

	// Gets the subject of the message
	public String getSubject_line() {
		return this.subject_line;
	}
	
	// Get the sender of the message
	public Patient get_sender() {
		return this.sender;
	}

	// Gets the text of the message
	public String getText() {
		return this.text;
	}

    	public void printMessage () {
        	System.out.println("Message Receiver: " + message_receiver +
                	", Subject Line: " + subject_line + ", Text: " + text +
                	", Sender: " + sender.getFName());
    	}
}