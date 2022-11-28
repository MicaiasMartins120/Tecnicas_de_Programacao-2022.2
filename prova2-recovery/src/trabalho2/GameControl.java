package trabalho2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControl {
	private Goal goal;
	
	public GameControl(Goal goal, Player player) {
		this.goal = goal;
		for (MapUnit unit : goal.getListMapUnits()) {
			unit.getButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (MapUnit unit : goal.getListMapUnits()) {
						if(unit.getPlayingStatus() == true) {
							if(unit.getDefenseAreaUnit() == true) {
								unit.getButton().setBackground(Color.RED);
							}
						}
						unit.increaseCont();
					}
					if(unit.getCont() <= 1) {
						if(unit.getDefenseAreaUnit() == true || unit.getGoalMapping() != GoalMapping.ONGOAL) {
							player.setNumShots();
						}
						else {
							player.setNumGoals();
						}
					}
				}
			});
		}
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}
}
