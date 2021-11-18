package application;

public class PhysicalExaminationObject {

	private Patient patient;
	private String date;
	private String findings;
	private String signature;
	
	// constructor
	public PhysicalExaminationObject(Patient p, String d, String f, String s)
	{
		this.patient = p;
		this.date = d;
		this.findings = f;
		this.signature = s;
	}
	public Patient getPatient() {
		return patient;
	}
	public String getDate() {
		return date;
	}
	public String getFindings() {
		return findings;
	}
	public String getSignature() {
		return signature;
	}

}
