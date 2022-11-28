package trabalho2;

import java.text.DecimalFormat;

public class Player {
	private String name;
	private String score;
	private int numGoals = 0;
	private int numShots = 0;
	
	public String getScore() {
		score = new DecimalFormat("0.00").format((double) getNumGoals()/(getNumGoals() + getNumShots()));
		
		return score;
	}

	public int getNumShots() {
		return numShots;
	}

	public void setNumShots() {
		this.numShots++;
	}

	public int getNumGoals() {
		return numGoals;
	}

	public void setNumGoals() {
		this.numGoals++;
	}
	
	public void resetNumGoals() {
		this.numGoals = 0;
	}
	
	public void resetNumShots() {
		this.numShots = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
