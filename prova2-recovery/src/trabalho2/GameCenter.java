package trabalho2;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class GameCenter {
	public JPanel getGameCenter(Goal goal, Player player) {
		StartButton startButton = new StartButton(goal, player);
		EndButton endButton = new EndButton(goal, player);
		NextButton nextButton =  new NextButton(goal);
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(Color.GRAY);
		startButton.setText("Play");
		buttonPanel.add(startButton);
		endButton.setText("End match");
		buttonPanel.add(endButton);
		nextButton.setText("Next turn");
		buttonPanel.add(nextButton);
		buttonPanel.setVisible(true);
		
		return buttonPanel;
	}
	
	public NextButton getNextButton(Goal goal) {
		return new NextButton(goal);
	}
}
