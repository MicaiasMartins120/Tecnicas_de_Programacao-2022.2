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

public class QuartersFinalWindow extends JFrame implements ActionListener{
	private SemiFinalWindow semiWindow;
	private QuartersTeamsDAO teams;
	private UserDAO user;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JTextField textField10;
	private JTextField textField11;
	private JTextField textField12;
	private JTextField textField13;
	private JTextField textField14;
	private JTextField textField15;
	private JTextField textField16;
	
	public QuartersFinalWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 60));
		
		JLabel label = new JLabel();
		label.setText("SELEÇÃO - PLACAR     X     SELEÇÃO - PLACAR");
		label.setPreferredSize(new Dimension(600, 30));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label);
		
		JTextField textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension(300, 30));
		textField1.setBackground(Color.BLACK);
		textField1.setForeground(Color.WHITE);
		textField1.setCaretColor(Color.WHITE);
		this.add(textField1);
		this.textField1 = textField1;
		
		JTextField textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension(30, 30));
		textField2.setBackground(Color.BLACK);
		textField2.setForeground(Color.WHITE);
		textField2.setCaretColor(Color.WHITE);
		this.add(textField2);
		this.textField2 = textField2;
		
		JTextField textField3 = new JTextField();
		textField3.setPreferredSize(new Dimension(300, 30));
		textField3.setBackground(Color.BLACK);
		textField3.setForeground(Color.WHITE);
		textField3.setCaretColor(Color.WHITE);
		this.add(textField3);
		this.textField3 = textField3;
		
		JTextField textField4 = new JTextField();
		textField4.setPreferredSize(new Dimension(30, 30));
		textField4.setBackground(Color.BLACK);
		textField4.setForeground(Color.WHITE);
		textField4.setCaretColor(Color.WHITE);
		this.add(textField4);
		this.textField4 = textField4;
		
		JTextField textField5 = new JTextField();
		textField5.setPreferredSize(new Dimension(300, 30));
		textField5.setBackground(Color.BLACK);
		textField5.setForeground(Color.WHITE);
		textField5.setCaretColor(Color.WHITE);
		this.add(textField5);
		this.textField5 = textField5;
		
		JTextField textField6 = new JTextField();
		textField6.setPreferredSize(new Dimension(30, 30));
		textField6.setBackground(Color.BLACK);
		textField6.setForeground(Color.WHITE);
		textField6.setCaretColor(Color.WHITE);
		this.add(textField6);
		this.textField6 = textField6;
		
		JTextField textField7 = new JTextField();
		textField7.setPreferredSize(new Dimension(300, 30));
		textField7.setBackground(Color.BLACK);
		textField7.setForeground(Color.WHITE);
		textField7.setCaretColor(Color.WHITE);
		this.add(textField7);
		this.textField7 = textField7;
		
		JTextField textField8 = new JTextField();
		textField8.setPreferredSize(new Dimension(30, 30));
		textField8.setBackground(Color.BLACK);
		textField8.setForeground(Color.WHITE);
		textField8.setCaretColor(Color.WHITE);
		this.add(textField8);
		this.textField8 = textField8;
		
		JTextField textField9 = new JTextField();
		textField9.setPreferredSize(new Dimension(300, 30));
		textField9.setBackground(Color.BLACK);
		textField9.setForeground(Color.WHITE);
		textField9.setCaretColor(Color.WHITE);
		this.add(textField9);
		this.textField9 = textField9;
		
		JTextField textField10 = new JTextField();
		textField10.setPreferredSize(new Dimension(30, 30));
		textField10.setBackground(Color.BLACK);
		textField10.setForeground(Color.WHITE);
		textField10.setCaretColor(Color.WHITE);
		this.add(textField10);
		this.textField10 = textField10;
		
		JTextField textField11 = new JTextField();
		textField11.setPreferredSize(new Dimension(300, 30));
		textField11.setBackground(Color.BLACK);
		textField11.setForeground(Color.WHITE);
		textField11.setCaretColor(Color.WHITE);
		this.add(textField11);
		this.textField11 = textField11;
		
		JTextField textField12 = new JTextField();
		textField12.setPreferredSize(new Dimension(30, 30));
		textField12.setBackground(Color.BLACK);
		textField12.setForeground(Color.WHITE);
		textField12.setCaretColor(Color.WHITE);
		this.add(textField12);
		this.textField12 = textField12;
		
		JTextField textField13 = new JTextField();
		textField13.setPreferredSize(new Dimension(300, 30));
		textField13.setBackground(Color.BLACK);
		textField13.setForeground(Color.WHITE);
		textField13.setCaretColor(Color.WHITE);
		this.add(textField13);
		this.textField13 = textField13;
		
		JTextField textField14 = new JTextField();
		textField14.setPreferredSize(new Dimension(30, 30));
		textField14.setBackground(Color.BLACK);
		textField14.setForeground(Color.WHITE);
		textField14.setCaretColor(Color.WHITE);
		this.add(textField14);
		this.textField14 = textField14;
		
		JTextField textField15 = new JTextField();
		textField15.setPreferredSize(new Dimension(300, 30));
		textField15.setBackground(Color.BLACK);
		textField15.setForeground(Color.WHITE);
		textField15.setCaretColor(Color.WHITE);
		this.add(textField15);
		this.textField15 = textField15;
		
		JTextField textField16 = new JTextField();
		textField16.setPreferredSize(new Dimension(30, 30));
		textField16.setBackground(Color.BLACK);
		textField16.setForeground(Color.WHITE);
		textField16.setCaretColor(Color.WHITE);
		this.add(textField16);
		this.textField16 = textField16;
		
		Button send = new Button();
		SemiFinalWindow semiWindow = new SemiFinalWindow(window);
		this.semiWindow = semiWindow;
		send.newButton(this.semiWindow);
		send.addActionListener(this);
		send.setText("Enviar");
		this.add(send);
		
		this.pack();
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		QuartersTeamsDAO teams = new QuartersTeamsDAO(new ArrayList<TeamDAO>());
		teams.setTeamList(new TeamDAO(textField1.getText(), textField2.getText()));
		teams.setTeamList(new TeamDAO(textField3.getText(), textField4.getText()));
		teams.setTeamList(new TeamDAO(textField5.getText(), textField6.getText()));
		teams.setTeamList(new TeamDAO(textField7.getText(), textField8.getText()));
		teams.setTeamList(new TeamDAO(textField9.getText(), textField10.getText()));
		teams.setTeamList(new TeamDAO(textField11.getText(), textField12.getText()));
		teams.setTeamList(new TeamDAO(textField13.getText(), textField14.getText()));
		teams.setTeamList(new TeamDAO(textField15.getText(), textField16.getText()));
		this.teams = teams;
		this.semiWindow.setUser(this.user);
		this.semiWindow.setQuartersTeams(this.teams);
		
		if(Integer.parseInt(textField2.getText()) > Integer.parseInt(textField4.getText())) {
			this.semiWindow.getTextField1().setText(textField1.getText());
			this.semiWindow.getTextField1().setPreferredSize(new Dimension(300, 30));
		}
		else {
			this.semiWindow.getTextField1().setText(textField3.getText());
			this.semiWindow.getTextField1().setPreferredSize(new Dimension(300, 30));
		}
		
		if(Integer.parseInt(textField6.getText()) > Integer.parseInt(textField8.getText())) {
			this.semiWindow.getTextField3().setText(textField5.getText());
			this.semiWindow.getTextField3().setPreferredSize(new Dimension(300, 30));
		}
		else {
			this.semiWindow.getTextField3().setText(textField7.getText());
			this.semiWindow.getTextField3().setPreferredSize(new Dimension(300, 30));
		}
		
		if(Integer.parseInt(textField10.getText()) > Integer.parseInt(textField12.getText())) {
			this.semiWindow.getTextField5().setText(textField9.getText());
			this.semiWindow.getTextField5().setPreferredSize(new Dimension(300, 30));
		}
		else {
			this.semiWindow.getTextField5().setText(textField11.getText());
			this.semiWindow.getTextField5().setPreferredSize(new Dimension(300, 30));
		}
		
		if(Integer.parseInt(textField14.getText()) > Integer.parseInt(textField16.getText())) {
			this.semiWindow.getTextField7().setText(textField13.getText());
			this.semiWindow.getTextField7().setPreferredSize(new Dimension(300, 30));
		}
		else {
			this.semiWindow.getTextField7().setText(textField15.getText());
			this.semiWindow.getTextField7().setPreferredSize(new Dimension(300, 30));
		}
		
		this.setVisible(false);
	}

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}
}
