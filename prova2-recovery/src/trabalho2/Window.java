package trabalho2;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Window extends JFrame{
	public Window() {
		this.setSize(1000,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		setGameLayout();
	}
	
	public void setGameLayout() {
		this.setLayout(new BorderLayout());
		Goal goal = new Goal();
		Goalkeeper firstGoalkeeper = new Goalkeeper(goal);
		Player player = new Player();
		GameControl firstGameControl = new GameControl(goal, player);
		GameCenter gameCenter = new GameCenter();
		Goalkeeper goalkeeper = gameCenter.getNextButton(goal).getNewGoalkeeper();
		this.add(goal.getGoalPanel(), BorderLayout.CENTER);
		this.add(gameCenter.getGameCenter(goal, player), BorderLayout.EAST);
	}
}
