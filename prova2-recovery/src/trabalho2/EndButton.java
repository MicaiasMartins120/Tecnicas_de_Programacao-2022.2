package trabalho2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EndButton extends Button implements ActionListener{
	private Goal goal;
	private Player player;
	
	public EndButton(Goal goal, Player player) {
		this.goal = goal;
		this.player = player;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(MapUnit unit : this.goal.getListMapUnits()) {
			unit.setPlayingStatus(false);
			unit.setButtonConfig();
			ImageIcon icon2 = new ImageIcon("assets/No-Goal.png");
			ImageIcon icon1 = new ImageIcon("assets/Ball.png");
			icon1.setImage(icon1.getImage().getScaledInstance(unit.getButton().getWidth() - 10, unit.getButton().getHeight() - 10, 1));
			icon2.setImage(icon2.getImage().getScaledInstance(unit.getButton().getWidth() - 10, unit.getButton().getHeight() - 10, 1));
			
			if(unit.getLastOcurrencyIsGol() == null) {
				
			}
			else if(unit.getLastOcurrencyIsGol() == false && unit.getGoalMapping() == GoalMapping.ONGOAL) {
				unit.getButton().setIcon(icon2);
			}
			else if(unit.getLastOcurrencyIsGol() == true && unit.getGoalMapping() == GoalMapping.ONGOAL) {
				unit.getButton().setIcon(icon1);
			}
			else if(unit.getLastOcurrencyIsGol() == false && unit.getGoalMapping() != GoalMapping.ONGOAL) {
				
			}
			
			unit.setLastOcurrencyIsGol(null);
		}
		JFrame resultsFrame = new JFrame();
		JLabel results1 = new JLabel();
		JLabel results2 = new JLabel();
		JLabel results3 = new JLabel();
		JLabel results4 = new JLabel();
		
		results1.setBounds(0, 0, 100, 100);
		results2.setBounds(0, 0, 100, 100);
		results3.setBounds(0, 0, 100, 100);
		results4.setBounds(0, 0, 100, 100);
		
		results1.setText(player.getName() + " results:");
		results2.setText("Goals: " + player.getNumGoals());
		results3.setText("Machine's score: " + player.getNumShots());
		results4.setText("Goal's rate: " + player.getScore());
		
		resultsFrame.add(results1);
		resultsFrame.add(results2);
		resultsFrame.add(results3);
		
		resultsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		resultsFrame.setSize(0, 400);
		resultsFrame.setLayout(new FlowLayout());
		resultsFrame.setVisible(true);
		
		this.player.resetNumGoals();
		this.player.resetNumShots();
	}
}
