package trabalho2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextButton extends Button implements ActionListener{
	private Goal goal;
	private Goalkeeper goalkeeper;
	
	public NextButton(Goal goal) {
		this.goal = goal;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(MapUnit unit : this.goal.getListMapUnits()) {
			if(unit.getPlayingStatus() == true) {
				unit.getButton().setIcon(null);
				unit.setDefenseAreaUnit(false);
				
				while(unit.getCont() != 0) {
					unit.descreaseCont();
				}
				unit.setButtonConfig();
			}
		}
		Goalkeeper goalkeeper = new Goalkeeper(getGoal());
		this.goalkeeper = goalkeeper;
	}
	
	public Goalkeeper getNewGoalkeeper() {
		return goalkeeper;
	}
	
	public Goal getGoal() {
		return this.goal;
	}
}
