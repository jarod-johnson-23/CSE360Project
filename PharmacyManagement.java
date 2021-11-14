package application;

import java.util.List;

public class PharmacyManagement {

	private String[] pharamacy_list;
	
	// constructor
	public PharmacyManagement(String[] pharamacy_name)
	{
		pharamacy_list = pharamacy_name;

	}

	public void store_prescription(Prescription p, Patient patient)
	{
		// add prescription to patient object
		patient.addPrescription(p);
	}

	public boolean send_prescription(Prescription p, Patient patient, String pharmacy_name)
	{
		// check if inputed pharmacy matches pharmacy in patient object
		if (patient.getPharmacy() == pharmacy_name)
		{
			return true;
		}
		
		return false;
	}

	public List<Prescription> get_prescription(Patient patient)
	{
		// get prescriptions list
		return patient.getPrescriptions();
	}

	public String get_pharmacy(Patient patient)
	{
		// return pharmacy
		return patient.getPharmacy();
	}


}
