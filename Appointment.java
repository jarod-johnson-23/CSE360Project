package application;

public class Appointment {
	
	private int time;
	private int date;
	private Patient patient;
	private String reason;
	
	public Appointment(int time, int date, Patient p, String reason)
	{
		this.time = time;
		this.date = date;
		this.patient = patient;
		this.reason = reason;
	}
}
