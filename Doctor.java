package application;

import java.util.List;

public class Doctor {
	private String name;
	private String username;
	private String password;
	private Patient[] patients;
	private int loginIndex;
	private List<Message> messages;
	
	// Constructor
	public Doctor(String name2, String username2, String password2, int size, int loginIndex2, Doctor drObject, List<Message> messages) {
		this.name = name2;
		this.username = username2;
		this.password = password2;
		this.patients = new Patient[size];
		this.loginIndex = loginIndex2;
		this.messages = messages;
		
		// Sets the array of Patients to null and doctor of patients
		for(int i = 0; i < patients.length; i++)
		{
			patients[i] = new Patient(null, null, null, 0, null, null, null, null, null, null, null, null, drObject, null, null);
		}
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
	
	//---------------------------------------------------------------------------------------------------
	// NEW CODE

	// Allows a doctor to enter a issue of patient
	public void enterPhysical(String patientFirstName, String issue)
	{
		for (int i = 0; i < patients.length; i++)
		{
			if (patients[i].getFName().equals(patientFirstName))
			{
				patients[i].addIssue(issue);
			}
		}
	}

	// Allows a doctor to enter a prescription for a patient
	public void enterPrescription(String patientFirstName, Prescription p)
	{
		for (int i = 0; i < patients.length; i++)
		{
			if (patients[i].getFName().equals(patientFirstName))
			{
				patients[i].addPrescription(p);
			}
		}
	}
}

