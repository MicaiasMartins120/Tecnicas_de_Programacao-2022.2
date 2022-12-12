package trabalho3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewDataWindow extends JFrame implements ActionListener{
	private UserDAO user;
	private JTextField textField;
	private QuartersFinalWindow quartesWindow;
	
	public NewDataWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 120));
		
		JLabel label = new JLabel();
		label.setText("INSIRA SEU NOME");
		label.setPreferredSize(new Dimension(600, 30));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label);
		
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(300, 30));
		this.add(textField);
		this.textField = textField;
		
		Button send = new Button();
		
		QuartersFinalWindow quartesWindow = new QuartersFinalWindow(window);
		this.quartesWindow = quartesWindow;
		send.newButton(this.quartesWindow);
		send.addActionListener(this);
		send.setText("Enviar");
		this.add(send);
		
		this.pack();
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		UserDAO user = new UserDAO(textField.getText());
		this.user = user;
		this.quartesWindow.setUser(this.user);
	}
	
	public UserDAO getUser() {
		return this.user;
	}
}
