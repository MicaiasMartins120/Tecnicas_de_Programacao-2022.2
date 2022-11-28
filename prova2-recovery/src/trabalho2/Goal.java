package trabalho2;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Goal extends JPanel{
	private ArrayList<MapUnit> listMapUnits;
	
	public Goal() {
		listMapUnits = new ArrayList<MapUnit>();
		buildGoal();
	}
	
	public void getGoalMap(int i) {
		for(int j = 0; j < 17; j++) {
			if(i == 0 || j == 0 || j == 16) {
				Button button = new Button();
				button.newButton(null);
				MapUnit outGoal = new MapUnit(i, j, button, GoalMapping.OUTGOAL, false, false);
				this.listMapUnits.add(outGoal);
			}
			else if(i == 1 || j == 1 || j == 15) {
				Button button = new Button();
				button.newButton(null);
				MapUnit onGoalpost = new MapUnit(i, j, button, GoalMapping.ONGOALPOST, false, false);
				this.listMapUnits.add(onGoalpost);
			}
			else {
				Button button = new Button();
				button.newButton(null);
				MapUnit onGoal = new MapUnit(i, j, button, GoalMapping.ONGOAL, false, false);
				this.listMapUnits.add(onGoal);
			}
		}
	}
	
	public void buildGoal() {
		for(int i = 0; i < 9; i++) {
			getGoalMap(i);
		}
	}
	
	public JPanel getGoalPanel() {
		JPanel goalPanel = new JPanel();
		goalPanel.setLayout(new GridLayout(9, 17));
		for(MapUnit unit: this.listMapUnits) {
			goalPanel.add(unit.getButton());
		}
		
		return goalPanel;
	}

	public ArrayList<MapUnit> getListMapUnits() {
		return listMapUnits;
	}

	public void setListMapUnits(ArrayList<MapUnit> listMapUnits) {
		this.listMapUnits = listMapUnits;
	}
}
