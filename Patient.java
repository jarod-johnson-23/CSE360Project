package application;

import java.util.List;

public class Patient {
	private String fName;
	private String mName;
	private String lName;
	private int age;
	private String birthday;
	private String gender;
	private String address;
	private String phoneNumber;
	private String email;
	private String pharmacy;
	private List<Prescription> prescriptions;
	private int prescrListSize;
	private String medications[] = new String[10];
	private String vaccines[] = new String[10];
	private String allergies[] = new String[10];
	private String healthConcerns[] = new String[10];
	private Doctor doctor;
	private String username;
	private String password;
	private DoctorNote[] doctorNoteArray = new DoctorNote[5];    // Array of doctor notes for patient

	// Default Constructor
	public Patient() {
		this.fName = null;
		this.mName = null;
		this.lName = null;
		this.age = 0;
		this.birthday = null;
		this.gender = null;
		this.address = null;
		this.phoneNumber = null;
		this.email = null;
		this.pharmacy = null;
		this.prescriptions = null;
		this.prescrListSize = 0;
		this.doctor = null;
		this.username = null;
		this.password = null;

		for (int i = 0; i < doctorNoteArray.length; i++) {
			doctorNoteArray[i] = new DoctorNote();
		}
	}

	// New Constructor?
	public Patient(String fName, String mName, String lName, int age, String birthday, String gender,
				   String address, String phoneNumber, String email, String pharmacy, List<Prescription> p_list,
				   Doctor doctor, String username, String password) {
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.age = age;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.pharmacy = pharmacy;
		this.prescriptions = p_list;
		this.doctor = doctor;
		this.username = username;
		this.password = password;

		for (int i = 0; i < doctorNoteArray.length; i++) {
			doctorNoteArray[i] = new DoctorNote();
		}
	}

	//Getter methods
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFName() {
		return fName;
	}

	public String getMName() {
		return mName;
	}

	public String getLName() {
		return lName;
	}

	public int getAge() {
		return age;
	}

	public String getBday() {
		return birthday;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getPharmacy() {
		return pharmacy;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public String getIssue(int index) {
		return healthConcerns[index];
	}

	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public Prescription getSpecificPresc(int index) {
		return prescriptions.get(index);
	}

	public int getPrescrListSize() {
		return prescriptions.size();
	}

	//Setter methods
	public void setUsername(String u) {
		username = u;
	}

	public void setPassword(String p) {
		password = p;
	}

	public void setFName(String n) {
		fName = n;
	}

	public void setMName(String n) {
		mName = n;
	}

	public void setLName(String n) {
		lName = n;
	}

	public void setAge(int a) {
		age = a;
	}

	public void setBday(String d) {
		birthday = d;
	}

	public void setGender(String g) {
		gender = g;
	}

	public void setAddr(String a) {
		address = a;
	}

	public void setPhone(String p) {
		phoneNumber = p;
	}

	public void setEmail(String e) {
		email = e;
	}

	public void setPharmacy(String p) {
		pharmacy = p;
	}

	public void setPrescrListSize(int size) {
		prescrListSize = size;
	}

	public void addIssue(String iss) {
		int i = 0;
		while (healthConcerns[i] != null) {
			i++;
		}
		healthConcerns[i] = iss;
	}

	public void setDoctor(Doctor aDoctor) {
		doctor = aDoctor;
	}

	public String concatenateNames() {
		String firstHalf = fName.concat(" ");

		String secondHalf = firstHalf.concat(lName);

		return secondHalf;
	}

	// other methods
	public void addPrescription(Prescription p) {
		prescriptions.add(p);
		prescrListSize++;
	}

	public void setPatientDocNote(String subject, String date, String docNote, String signature) {
		int i = 0;
		while (i <  doctorNoteArray.length) {
			if (doctorNoteArray[i].getDate() == null) {
				break;
			}
			i++;
		}
		doctorNoteArray[i].setDocNote(subject, date, docNote, signature);
	}

	public String getPatDocNoteSub(String date) {
		for (int i = 0; i < doctorNoteArray.length; i++) {
			if (doctorNoteArray[i].getDate() == date) {
				return this.doctorNoteArray[i].getSubject();
			}
		}
		return "";
	}


	public String getPatDocNote(String date) {;
		for (int i = 0; i < doctorNoteArray.length; i++) {
			if (doctorNoteArray[i].getDate() == date) {
				return this.doctorNoteArray[i].getNote();
			}
		}
		return "";
	}

	public String getPatDocNoteDate(String date) {
		for (int i = 0; i < doctorNoteArray.length; i++) {
			if (doctorNoteArray[i].getDate() == date) {
				return this.doctorNoteArray[i].getDate();
			}
		}
		return "";
	}

	public String getPatDocNoteSig(String date) {
		for (int i = 0; i < doctorNoteArray.length; i++) {
			if (doctorNoteArray[i].getDate() == date) {
				return this.doctorNoteArray[i].getSignature();
			}
		}
		return "";
	}
}
