package trabalho2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Button extends JButton implements ActionListener {
	private int cont = 0;
	public Button newButton(String text) {
		Button button = new Button();
		this.setSize(400, 400);
		this.setText(text);
		
		return button;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int getCont() {
		return cont;
	}

	public void increaseCont() {
		this.cont++;
	}
	
	public void descreaseCont() {
		this.cont--;
	}
}
