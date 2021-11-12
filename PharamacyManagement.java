package application;

public class PharamacyManagement {

	private string[] pharamacy_list;

	private Patient patient;

	private Prescription prescription;

	public PharamacyManagement(string[] pharamacy_name, Patient _patient, Prescription p){
		pharamacy_list = pharamacy_name;
		patient = _patient;
		prescription = p;
	}

	public bool store_prescription(Prescription p, Patient _patient){
		if(p == prescription && _patient == patient){
			return true;
		}else{
			return false;
		}
	}

	public bool send_prescription(Prescription p, Patient _patient, string pharamacy_name){
		if(p == prescription && _patient == patient && pharamacy_name == pharamacy_list){
			return true;
		}else{
			return false;
		}
	}

	public Prescription get_prescription(Patient patient){
		return prescription;
	}

	public String get_pharmacy(Patient patient){
		return pharamacy_list[patient];
	}

	public bool update_patient_profile(Patient _patient, Prescription p){
		if(_patient == patient && p == prescription){
			return true;
		}else{
			return false;
		}
	}

}
