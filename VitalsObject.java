package application;

public class VitalsObject {
	private String hRate, bWeight, temp, pressure;
	private Patient pat;
	
	
	public VitalsObject(String text, String text2, String text3, String text4, Patient patient) {
		this.hRate = text;
		this.bWeight = text2;
		this.temp = text3;
		this.pressure = text4;
		this.pat = patient;
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
