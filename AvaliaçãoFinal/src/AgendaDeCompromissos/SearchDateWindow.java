package AgendaDeCompromissos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchDateWindow extends JFrame implements ActionListener{
	private Button send;
	private Button returnButton;
	private Date date;
	private CommitmentsByDateWindow commitmentsByDateWindow;
	private JTextField textField;
	private final SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
	
	public SearchDateWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 250, 90));
		
		JLabel label = new JLabel();
		label.setText("INSIRA A DATA");
		label.setPreferredSize(new Dimension(600, 30));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label);
		
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(300, 30));
		this.add(textField);
		this.textField = textField;
		
		this.send = new Button();
		
		CommitmentsByDateWindow commitmentsByDateWindow = new CommitmentsByDateWindow(window, this);
		this.commitmentsByDateWindow = commitmentsByDateWindow;
		send.newButton(this.commitmentsByDateWindow);
		send.addActionListener(this);
		send.setText("Enviar");
		this.add(send);
		
		this.returnButton = new Button();
		returnButton.newButton(window);
		returnButton.setText("Voltar");
		returnButton.addActionListener(this);
		this.add(returnButton);
		
		this.pack();
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == send) {
			this.setVisible(false);
			Calendar cal = Calendar.getInstance();
			try {
				cal.setTime(dateFormat.parse(textField.getText()));
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			this.date = new java.sql.Date(cal.getTimeInMillis());
			
			String sql = "select * from compromissos";
			Conection conection = new Conection();
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				conection.getConection();
				pstm = (PreparedStatement) conection.getConection().prepareStatement(sql);
				rset = pstm.executeQuery();
				
				while(rset.next()) {
					if (this.date.equals(rset.getDate("date"))) {
						this.commitmentsByDateWindow.getTextField1().setText(rset.getString("hour7"));
						this.commitmentsByDateWindow.getTextField2().setText(rset.getString("hour8"));
						this.commitmentsByDateWindow.getTextField3().setText(rset.getString("hour9"));
						this.commitmentsByDateWindow.getTextField4().setText(rset.getString("hour10"));
						this.commitmentsByDateWindow.getTextField5().setText(rset.getString("hour11"));
						this.commitmentsByDateWindow.getTextField6().setText(rset.getString("hour12"));
						this.commitmentsByDateWindow.getTextField7().setText(rset.getString("hour13"));
						this.commitmentsByDateWindow.getTextField8().setText(rset.getString("hour14"));
						this.commitmentsByDateWindow.getTextField9().setText(rset.getString("hour15"));
						this.commitmentsByDateWindow.getTextField10().setText(rset.getString("hour16"));
						this.commitmentsByDateWindow.getTextField11().setText(rset.getString("hour17"));
						this.commitmentsByDateWindow.getTextField12().setText(rset.getString("hour18"));
					}
				}
				
				pstm.execute();
				conection.getConection().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == returnButton) {
			this.setVisible(false);
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
