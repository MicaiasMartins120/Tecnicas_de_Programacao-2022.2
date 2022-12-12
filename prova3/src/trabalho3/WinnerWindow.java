package trabalho3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WinnerWindow extends JFrame implements ActionListener{
	private JLabel label = new JLabel();
	private UserDAO user;
	private QuartersTeamsDAO quartersTeams;
	private SemiTeamsDAO semiTeams;
	private FinalTeamsDAO finalTeams;
	
	public WinnerWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		
		this.label.setPreferredSize(new Dimension(800, 490));
		this.label.setHorizontalTextPosition(JLabel.CENTER);
		this.label.setHorizontalAlignment(JLabel.CENTER);
		this.label.setVerticalTextPosition(JLabel.TOP);
		this.label.setIconTextGap(10);
		this.label.setText("Campeão !!!");
		this.add(this.label);
		
		Button returnButton = new Button();
		returnButton.newButton(window);
		returnButton.addActionListener(this);
		returnButton.setText("Voltar");
		this.add(returnButton);
		
		this.pack();
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}

	public QuartersTeamsDAO getQuartersTeams() {
		return quartersTeams;
	}

	public void setQuartersTeams(QuartersTeamsDAO quartersTeams) {
		this.quartersTeams = quartersTeams;
	}

	public SemiTeamsDAO getSemiTeams() {
		return semiTeams;
	}

	public void setSemiTeams(SemiTeamsDAO semiTeams) {
		this.semiTeams = semiTeams;
	}

	public FinalTeamsDAO getFinalTeams() {
		return finalTeams;
	}

	public void setFinalTeams(FinalTeamsDAO finalTeams) {
		this.finalTeams = finalTeams;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
}
