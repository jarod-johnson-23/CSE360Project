package application;

public class Prescription {

	private Patient patient;
	private String pharmacy_name;
	private String medication;
	private double dosage;
	private double dosage_per_day;
	private String notes;

	// constructor
	public Prescription(Patient p, String p_name, String m, double d, double d_per_day, String n)
	{
		patient = p;
		pharmacy_name = p_name;
		medication = m;
		dosage = d;
		dosage_per_day = d_per_day;
		notes = n;
	}

	public boolean send_prescription(String pharmacy_n)
	{
		if(pharmacy_n == pharmacy_name)
		{
			return true;
		} 
		else
		{
			return false;
		}

	}
}

