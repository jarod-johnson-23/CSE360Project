package application;

import java.util.List;

public class Doctor {
	private String name;
	private String username;
	private String password;
	private Patient[] patients;
	private int loginIndex;	// DIFFERENT
	private List<Message> messages;	// DIFFERENT
	private int patientArraySize;

	// Constructor
	public Doctor(String name2, String username2, String password2, int numPatients, int loginIndex2, List<Message> messages) {
		this.name = name2;
		this.username = username2;
		this.password = password2;
		this.patients = new Patient[numPatients];
		this.loginIndex = loginIndex2;
		this.messages = messages;
		this.patientArraySize = numPatients;

		for(int i = 0; i < patientArraySize; i++) {
			patients[i] = new Patient();
		}
	}

	// Assigns a patient to doctor
	public void addPatient(Patient newPatient)
	{
		int i = 0;
		while(patients[i].getFName() != null)
		{
			i++;
		}
		this.patients[i] = newPatient;
		newPatient.setDoctor(this.name);
	}

	// GETTERS
	// Gets the name of doctor
	public String getName()
	{
		return name;
	}

	// Gets the username of doctor
	public String getUsername()
	{
		return username;
	}

	// Gets the password of doctor
	public String getPassword()
	{
		return password;
	}

	// Gets the patient that is assigned to doctor
	public Patient getPatient(int index)
	{
		return patients[index];
	}

	// Gets the doctor's login index
	public int getIndex()
	{
		return loginIndex;
	}

	// Gets the doctors list of patients
	public int getPatientArraySize() {
		return patientArraySize;
	}

	// Allows the doctor to add a message
	public void addMessage(Message message)
	{
		messages.add(message);
	}

	//---------------------------------------------------------------------------------------------------
	// NEW CODE

	// Allows a doctor to enter a issue of patient
	public void enterPhysical(Patient patient, String issue)
	{
		patient.addIssue(issue);
	}

	// Allows a doctor to enter a prescription for a patient
	public void enterPrescription(Patient patient, Prescription prescription)
	{
		patient.addPrescription(prescription);
	}

	// Allows a doctor to make a note about patient
	public void enterDocNote(Patient patient, String subject, String date, String doctorNote, String signature)
	{
		patient.setPatientDocNote(subject, date, doctorNote, signature);
		for (int i = 0; i < patientArraySize; i++)
		{
			if (patients[i].getFName() == patient.getFName())
			{
				patients[i].setPatientDocNote(subject, date, doctorNote, signature);
			}
		}
	}

	// Gets doctors note of specific patient
	public String getDocNoteSub(Patient patient,String date) {
		for (int i = 0; i < patientArraySize; i++) {
			if (patients[i].getPatDocNote(date) == patient.getPatDocNote(date)) {
				return patients[i].getPatDocNoteSub(date);
			}
		}
		return "";
	}

	public String getDocNote(Patient patient,String date) {
		for (int i = 0; i < patientArraySize; i++) {
			if (patients[i].getPatDocNote(date) == patient.getPatDocNote(date)) {
				return patients[i].getPatDocNote(date);
			}
		}
		return "";
	}

	public String getDocNoteDate(Patient patient,String date) {
		for (int i = 0; i < patientArraySize; i++) {
			if (patients[i].getPatDocNote(date) == patient.getPatDocNote(date)) {
				return patients[i].getPatDocNoteDate(date);
			}
		}
		return "";
	}

	public String getDocNoteSig(Patient patient,String date) {
		for (int i = 0; i < patientArraySize; i++) {
			if (patients[i].getPatDocNote(date) == patient.getPatDocNote(date)) {
				return patients[i].getPatDocNoteSig(date);
			}
		}
		return "";
	}
}
