package application;

import java.util.ArrayList;
import java.util.List;

public class Messages {

	private List<Message> messages_list;
	
	// constructor
	public Messages()
	{
		messages_list = new ArrayList<Message>();
	}
	
	public Message get_message(Patient patient)
	{		
		for (int i = 0; i < messages_list.size(); i++)
		{
			// if message sender matches patient name, return message
			if (messages_list.get(i).get_sender().concatenateNames() == patient.concatenateNames())
			{
				return messages_list.get(i);
			}
		
		}
		
		// return empty message if no matches
		return new Message("", "", "", null);
		
	}
	
	public void send_message_doctor(Message message, Doctor doctor)
	{
		// send message
		doctor.addMessage(message);
		
		// store message in messages_list 
		messages_list.add(message);
	}
	
	public void send_message_nurse(Message message, Nurse nurse)
	{
		// send message
		nurse.addMessage(message);
		
		// store message in messages_list
		messages_list.add(message);	
	}
}
