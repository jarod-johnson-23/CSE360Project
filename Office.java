package application;

import java.util.ArrayList;
import java.util.List;

public class Office {

	private List<Patient> patient_list;
	private List<Doctor> doctor_list;
	private List<Nurse> nurse_list;
	private List<Patient> patient_waiting;
	private List<Patient> patient_viewing;
	private List<Appointment> appointment_list;

	// constructor
	public Office(){
		patient_list = new ArrayList<Patient>();
		doctor_list = new ArrayList<Doctor>();
		nurse_list = new ArrayList<Nurse>();
		patient_waiting = new ArrayList<Patient>();
		patient_viewing = new ArrayList<Patient>();
		appointment_list = new ArrayList<Appointment>();
	}
	
	// constructor
	public Office(List<Patient> p_list, List<Doctor> d_list, List<Nurse> n_list, List<Patient> p_waiting, List<Patient> p_viewing, List<Appointment> appt_list)
	{
		this.patient_list = p_list;
		this.doctor_list = d_list;
		this.nurse_list = n_list;
		this.patient_waiting = p_waiting;
		this.patient_viewing = p_viewing;
		this.appointment_list = appt_list;
	}

	public List<Patient> view_patients()
	{
		return this.patient_list;
	}

	public List<Doctor> view_doctors()
	{
		return this.doctor_list;
	}

	public List<Nurse> view_nurses()
	{
		return this.nurse_list;
	}

	public boolean move_patients_to_waiting(Patient patient)
	{
		for (int i = 0; i < this.patient_waiting.size(); i++)
		{
			// if patient is already in waiting, return false
			if (patient_waiting.get(i) == patient)
			{
				return false; 
			}
		}
		
		// move patient to waiting room
		this.patient_waiting.add(patient);
		
		// patient has been added to waiting room 
		return true;
	}

	public boolean move_patients_to_viewing(Patient patient)
	{
		for (int i = 0; i < this.patient_viewing.size(); i++)
		{
			// if patient is already in viewing, return false
			if (patient_viewing.get(i) == patient)
			{
				return false; 
			}
		}
		
		// move patient to viewing room
		this.patient_viewing.add(patient);
		
		// patient has been added to viewing room 
		return true;
	}
	
	public boolean patient_login(String f_name, String l_name, String birthday)
	{
		for (int i = 0; i < patient_list.size(); i++)
		{
			// if there is a patient with the inputed first & last name and birthday, return true
			if (patient_list.get(i).getFName() == f_name && patient_list.get(i).getLName() == l_name && patient_list.get(i).getBday() == birthday)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean doctor_login(String username, String password)
	{
		for (int i = 0; i < doctor_list.size(); i++)
		{
			// if there is a doctor with the inputed user name and password, return true
			if (doctor_list.get(i).getUsername() == username && doctor_list.get(i).getPassword() == password)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean nurse_login(String username, String password)
	{
		for (int i = 0; i < nurse_list.size(); i++)
		{
			// if there is a nurse with the inputed user name and password, return true
			if (nurse_list.get(i).getUsername() == username && nurse_list.get(i).getPassword() == password)
			{
				return true;
			}
		}
		
		return false;
	}

}
