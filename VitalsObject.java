package application;

public class VitalsObject {
	private String hRate, bWeight, temp, respRate, pressure;
	private Patient pat;
	
	public VitalsObject(String text, String text2, String text3, String text4, String text5, Patient patient) {
		this.hRate = text;
		this.bWeight = text2;
		this.temp = text3;
		this.respRate = text4;
		this.pressure = text5;
		this.pat = patient;
	}
	
	public VitalsObject(String text, String text2, String text3, String text4, String text5) {
		this.hRate = text;
		this.bWeight = text2;
		this.temp = text3;
		this.respRate = text4;
		this.pressure = text5;
	}

	public void setHeartRate(String r) {
		hRate = r;
	}
	public void setWeight(String w) {
		bWeight = w;
	}
	public void setTemp(String t) {
		temp = t;
	}
	public void setPressure(String p) {
		pressure = p;
	}
	
	public String getHeartRate() {
		return hRate;
	}
	public String getWeight() {
		return bWeight;
	}
	public String getTemp() {
		return temp;
	}
	public String getPressure() {
		return pressure;
	}
}