package application;


public class Doctor {
	private String name;
	private String username;
	private String password;
	private Patient[] patients;
	private int loginIndex;
		
	public Doctor(String name2, String username2, String password2, Patient[] patients2, int loginIndex2) {
		name = name2;
		username = username2;
		password = password2;
		patients = patients2;
		loginIndex = loginIndex2;
	}

	public void addPatient(Patient newPatient) {
		int i = 0;
		while(patients[i].getFName() != null) {
			i++;
		}
		patients[i] = newPatient;
	}
	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Patient getPatient(int index) {
		return patients[index];
	}
	public int getIndex() {
		return loginIndex;
	}
	
}
