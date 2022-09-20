package pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class User implements Serializable {
	private String name;
	private String course;
	private String email;
	private int age;

/*	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCource(String cource){
		this.cource = cource;
	}

	public String getCource(){
		return cource;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}*/

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"name = '" + name + '\'' + 
			",cource = '" + course + '\'' +
			",email = '" + email + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}