package pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
@Builder
public class Score implements Serializable {
	private String name;
	private int score;

/*
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setScore(int score){
		this.score = score;
	}

	public int getScore(){
		return score;
	}
*/

	@Override
 	public String toString(){
		return 
			"Score{" + 
			"name = '" + name + '\'' + 
			",score = '" + score + '\'' + 
			"}";
		}
}