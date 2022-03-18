package farmers_friend;

public class Register_JavaBean {
	
	private String name,email,mobile,password,confirm_password,city;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getMobile(){
		return mobile;
	}
	
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getConfirmPassword(){
		return confirm_password;
	}
	
	public void setConfirmPassword(String confirm_password){
		this.confirm_password=confirm_password;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String city){
		this.city=city;
	}
}
