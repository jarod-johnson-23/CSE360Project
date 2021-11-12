package application;

public class PatientRoom {

	private Doctor doctor_in_room;
	private Nurse nurse_in_room;
	private Patient current_patient;
	
	// constructor
	public PatientRoom(Doctor d, Nurse n, Patient p)
	{
		doctor_in_room = d;
		nurse_in_room = n;
		current_patient = p;

	}

}