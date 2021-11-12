package application;

public class PrescriptionClass {

	private Patient patient;
	private String pharmacy_name;
	private String medication;
	private double dosage;
	private double dosage_per_day;
	private String notes;

	public PrescriptionClass(Patient p, string p_name, string m, double d, double d_per_day, string n){
		patient = p;
		p_name = pharmacy_name;
		medication = m;
		dosage = d;
		dosage_per_day = d_per_day;
		notes = n;
	}

	public bool send_prescription(string pharmacy_n){
		if(pharmacy_n == pharmacy_name){
			return true;
		} else{
			return false;
		}

	}
}
