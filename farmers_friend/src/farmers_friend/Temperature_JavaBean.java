package farmers_friend;

public class Temperature_JavaBean {
	
	private String cropName,temperature,description;
	
	public String getCropName(){
		return cropName;
	}
	
	public void setCropName(String cropName){
		this.cropName=cropName;
	}
	
	public String getTemperature(){
		return temperature;
	}
	
	public void setTemperature(String temperature){
		this.temperature=temperature;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
}
