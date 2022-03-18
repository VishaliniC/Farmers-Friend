package farmers_friend;

public class Soil_JavaBean {
	
	private String cropName,soilType,description;
	
	public String getCropName(){
		return cropName;
	}
	
	public void setCropName(String cropName){
		this.cropName=cropName;
	}
	
	public String getSoilType(){
		return soilType;
	}
	
	public void setSoilType(String soilType){
		this.soilType=soilType;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	
}
