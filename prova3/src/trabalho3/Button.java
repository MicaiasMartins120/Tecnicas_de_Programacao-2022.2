package trabalho3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Button extends JButton implements ActionListener{
	private JFrame frame;
	
	public Button newButton(JFrame frame) {
		Button button = new Button();
		this.setSize(800, 600);
		this.setFrame(frame);
		this.addActionListener(this);
		
		return button;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.getFrame().setVisible(true);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
