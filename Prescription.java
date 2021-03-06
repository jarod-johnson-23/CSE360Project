package application;

public class Prescription {

	private Patient patient;
	private String pharmacy_name;
	private String medication;
	private String dosage;
	private String dosage_per_day;
	private String notes;

	// Default Constructor
	public Prescription()
	{
		patient = null;
		pharmacy_name = "";
		medication = "";
		dosage = "";
		dosage_per_day = "";
		notes = "";
	}

	// Constructor
	public Prescription(Patient p, String p_name, String m, String d, String d_per_day, String n)
	{
		patient = p;
		pharmacy_name = p_name;
		medication = m;
		dosage = d;
		dosage_per_day = d_per_day;
		notes = n;
	}

	// Compares pharmacies
	public boolean send_prescription(String pharmacy_n)
	{
		if(pharmacy_name == pharmacy_n) {
			return true;
		}
		else {
			return false;
		}
	}

	//---------------------------------------------------------------------------------------------------
	// GETTER METHODS

	// Gets the patient that receives prescription
	public Patient getPatient() {
		return patient;
	}

	// Gets the pharmacy patient gets prescription
	public String getPharmacy_name() {
		return pharmacy_name;
	}

	// Gets patients medication
	public String getMedication() {
		return medication;
	}

	// Gets patients dosage
	public String getDosage() {
		return dosage;
	}

	// Gets patients the dosage patient receives per day
	public String getDosage_per_day() {
		return dosage_per_day;
	}

	// Gets prescription notes
	public String getNotes() {
		return notes;
	}

	public void printPrescription() {
		System.out.println("Patient: " + patient.getFName() + " Pharmacy Name: " + pharmacy_name +
				" Medication: " + medication + " Dosage: " + dosage + " Dosage Per Day: " +
				dosage_per_day + " Note: " + notes);
	}
}