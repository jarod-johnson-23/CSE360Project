package application;

public class PatientVisit {
	private String date, time, reason, patientName;
	
	public PatientVisit(String date, String time, String reason, String patientName) {
		this.date = date;
		this.time = time;
		this.reason = reason;
		this.patientName = patientName;
	}
	
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public String getReason() {
		return reason;
	}
	public String getPatName() {
		return patientName;
	}
}
