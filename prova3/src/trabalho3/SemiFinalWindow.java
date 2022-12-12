package trabalho3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SemiFinalWindow extends JFrame implements ActionListener{
	private FinalWindow finalWindow;
	private UserDAO user;
	private QuartersTeamsDAO quartersTeams;
	private SemiTeamsDAO semiTeams;
	private JTextField textField1 = new JTextField();
	private JTextField textField2;
	private JTextField textField3 = new JTextField();
	private JTextField textField4;
	private JTextField textField5 = new JTextField();
	private JTextField textField6;
	private JTextField textField7 = new JTextField();
	private JTextField textField8;
	
	public SemiFinalWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 100));
		
		JLabel label = new JLabel();
		label.setText("SELEÇÃO - PLACAR     X     SELEÇÃO - PLACAR");
		label.setPreferredSize(new Dimension(600, 30));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label);
		
		this.add(this.textField1);
		this.textField1.setBackground(Color.GRAY);
		this.textField1.setEditable(false);
		this.textField1.setBackground(Color.BLACK);
		this.textField1.setForeground(Color.WHITE);
		this.textField1.setCaretColor(Color.WHITE);
		
		JTextField textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension(30, 30));
		textField2.setBackground(Color.BLACK);
		textField2.setForeground(Color.WHITE);
		textField2.setCaretColor(Color.WHITE);
		this.add(textField2);
		this.textField2 = textField2;

		this.add(this.textField3);
		this.textField3.setBackground(Color.GRAY);
		this.textField3.setEditable(false);
		textField3.setBackground(Color.BLACK);
		textField3.setForeground(Color.WHITE);
		textField3.setCaretColor(Color.WHITE);
		
		JTextField textField4 = new JTextField();
		textField4.setPreferredSize(new Dimension(30, 30));
		textField4.setBackground(Color.BLACK);
		textField4.setForeground(Color.WHITE);
		textField4.setCaretColor(Color.WHITE);
		this.add(textField4);
		this.textField4 = textField4;

		this.add(this.textField5);
		this.textField5.setBackground(Color.GRAY);
		this.textField5.setEditable(false);
		textField5.setBackground(Color.BLACK);
		textField5.setForeground(Color.WHITE);
		textField5.setCaretColor(Color.WHITE);
		
		JTextField textField6 = new JTextField();
		textField6.setPreferredSize(new Dimension(30, 30));
		textField6.setBackground(Color.BLACK);
		textField6.setForeground(Color.WHITE);
		textField6.setCaretColor(Color.WHITE);
		this.add(textField6);
		this.textField6 = textField6;
		
		this.add(this.textField7);
		this.textField7.setBackground(Color.GRAY);
		this.textField7.setEditable(false);
		textField7.setBackground(Color.BLACK);
		textField7.setForeground(Color.WHITE);
		textField7.setCaretColor(Color.WHITE);
		
		JTextField textField8 = new JTextField();
		textField8.setPreferredSize(new Dimension(30, 30));
		textField8.setBackground(Color.BLACK);
		textField8.setForeground(Color.WHITE);
		textField8.setCaretColor(Color.WHITE);
		this.add(textField8);
		this.textField8 = textField8;
		
		Button send = new Button();
		FinalWindow finalWindow = new FinalWindow(window);
		this.finalWindow = finalWindow;
		send.newButton(this.finalWindow);
		send.addActionListener(this);
		send.setText("Enviar");
		this.add(send);
		
		this.pack();
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SemiTeamsDAO semiTeams = new SemiTeamsDAO(new ArrayList<TeamDAO>());
		semiTeams.setTeamList(new TeamDAO(textField1.getText(), textField2.getText()));
		semiTeams.setTeamList(new TeamDAO(textField3.getText(), textField4.getText()));
		semiTeams.setTeamList(new TeamDAO(textField5.getText(), textField6.getText()));
		semiTeams.setTeamList(new TeamDAO(textField7.getText(), textField8.getText()));
		this.semiTeams = semiTeams;
		this.finalWindow.setUser(this.user);
		this.finalWindow.setQuartersTeams(this.quartersTeams);
		this.finalWindow.setSemiTeams(this.semiTeams);
		
		if(Integer.parseInt(textField2.getText()) > Integer.parseInt(textField4.getText())) {
			this.finalWindow.getTextField1().setText(textField1.getText());
			this.finalWindow.getTextField1().setPreferredSize(new Dimension(300, 30));
		}
		else {
			this.finalWindow.getTextField1().setText(textField3.getText());
			this.finalWindow.getTextField1().setPreferredSize(new Dimension(300, 30));
		}
		
		if(Integer.parseInt(textField6.getText()) > Integer.parseInt(textField8.getText())) {
			this.finalWindow.getTextField3().setText(textField5.getText());
			this.finalWindow.getTextField3().setPreferredSize(new Dimension(300, 30));
		}
		else {
			this.finalWindow.getTextField3().setText(textField7.getText());
			this.finalWindow.getTextField3().setPreferredSize(new Dimension(300, 30));
		}
		
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

	public void setQuartersTeams(QuartersTeamsDAO teams) {
		this.quartersTeams = teams;
	}
	
	public JTextField getTextField1() {
		return textField1;
	}
	
	public JTextField getTextField3() {
		return textField3;
	}
	
	public JTextField getTextField5() {
		return textField5;
	}
	
	public JTextField getTextField7() {
		return textField7;
	}
	
	public void setTextField1(JTextField textField1) {
		this.textField1 = textField1;
	}
	
	public void setTextField3(JTextField textField3) {
		this.textField3 = textField3;
	}
	
	public void setTextField5(JTextField textField5) {
		this.textField5 = textField5;
	}
	
	public void setTextField7(JTextField textField7) {
		this.textField7 = textField7;
	}
}
