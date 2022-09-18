package pojo;

import java.io.Serializable;

public class Course implements Serializable {
	private int price;
	private String name;

/*
	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
*/

	@Override
 	public String toString(){
		return 
			"CourseDTO{" + 
			"price = '" + price + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}