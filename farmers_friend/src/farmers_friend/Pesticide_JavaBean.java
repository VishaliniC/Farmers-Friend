package farmers_friend;

public class Pesticide_JavaBean {

	private String cropName,disease,pesticide;
	
	public String getCropName(){
		return cropName;
	}
	
	public void setCropName(String cropName){
		this.cropName=cropName;
	}
	
	public String getDisease(){
		return disease;
	}
	
	public void setDisease(String disease){
		this.disease=disease;
	}
	
	public String getPesticide(){
		return pesticide;
	}
	
	public void setPesticide(String pesticide){
		this.pesticide=pesticide;
	}
}
