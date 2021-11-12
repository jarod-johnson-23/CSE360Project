package application;

public class Office {

	private Patient[] patient_list;
	private Doctor[] doctor_list;
	private Nurse[] nurse_list;
	private Patient[] patient_waiting;
	private PatientRoom[] patient_viewing;
	private Appointment[] appointment_list;


	public Office(Patient[] p_l, Doctor[] d_l, Nurse[] n_l, Patient[] p_w, PatientRoom[] p_v, Appointment[] a_l){
		patient_list = p_l;
		doctor_list = d_l;
		nurse_list = n_l;
		patient_waiting = p_w;
		patient_viewing = p_v;
		appointment_list = a_l;
	}

	public Patients[] view_patients(){
	}

	public Doctors[] view_doctors(){
	}

	public Nurses[] view_nurses(){
	}

	public bool move_patients_to_waiting(Patient[] patient){
		if(patient_waiting == patient){
			return true;
		} else{
			return false;
		}
	}

	public bool move_patients_to_viewing(PatientRoom[] patient){
		if(patient_viewing == patient){
			return true;
		} else{
			return false;
		}
	}

}
