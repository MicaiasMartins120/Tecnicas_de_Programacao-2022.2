package trabalho2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class StartButton extends Button implements ActionListener{
	private Goal goal;
	private Player player;
	
	public StartButton(Goal goal, Player player) {
		this.goal = goal;
		this.player = player;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.player.setName(JOptionPane.showInputDialog("Enter with your name"));
		for(MapUnit unit : this.goal.getListMapUnits()) {
			unit.setPlayingStatus(true);
			unit.getButton().setIcon(null);
			unit.setButtonConfig();
			while(unit.getCont() != 0) {
				unit.descreaseCont();
			}
		}
		this.player.resetNumGoals();
		this.player.resetNumShots();
	}
}
