package trabalho2;

import java.util.Random;

public class Goalkeeper {
	private int[] leftHand;
	private int[] rightHand;
	private int[] foot;
	private Goal goalPanel;
	
	public Goalkeeper(Goal goalPanel) {
		this.goalPanel = goalPanel;
		Random rand = new Random();
		getHands(rand);
		getFoot(rand);
		getDefenseArea();
	}
	
	public void getHands(Random rand) {
		int[] hand1 = {rand.nextInt(0, 3), rand.nextInt(0, 13)};
		int[] hand2 = {rand.nextInt(0, 8), rand.nextInt(hand1[1] + 3, 16)};
		
		this.rightHand = hand1;
		this.leftHand = hand2;
	}
	
	public void getFoot(Random rand) {
		int[] foot = {8, rand.nextInt(rightHand[1], leftHand[1])};
		this.foot = foot;
	}
	
	public void getDefenseArea() {
		int[] maior = new int[2];
		
		if(rightHand[0] < leftHand[0]) {
			maior = rightHand;
		}
		else {
			maior = leftHand;
		}
		
		for(MapUnit unit : this.goalPanel.getListMapUnits()) {
			if(unit.getPositionX() == foot[0] && unit.getPositionY() == foot[1] 
					||unit.getPositionX() == rightHand[0] && unit.getPositionY() == rightHand[1]
							||unit.getPositionX() == leftHand[0] && unit.getPositionY() == leftHand[1]) {
				unit.setDefenseAreaUnit(true);
			}
			if(unit.getPositionX() > maior[0] && unit.getPositionX() < foot[0]) {
				if(unit.getPositionY() >= rightHand[1] && unit.getPositionY() < leftHand[1]) {
					unit.setDefenseAreaUnit(true);
				}
			}
		}
	}
}
