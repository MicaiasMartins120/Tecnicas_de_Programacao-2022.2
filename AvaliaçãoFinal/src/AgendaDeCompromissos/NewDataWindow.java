package AgendaDeCompromissos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewDataWindow extends JFrame implements ActionListener{
	private Button send;
	private Button returnButton;
	private Date date;
	private CommitmentsWindow commitmentsWindow;
	private JTextField textField;
	private final SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
	
	public NewDataWindow(InitialWindow window) {
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
		
		CommitmentsWindow commitmentsWindow = new CommitmentsWindow(window, this);
		this.commitmentsWindow = commitmentsWindow;
		send.newButton(this.commitmentsWindow);
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
			this.commitmentsWindow.setDate(this.date);
			
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
						this.commitmentsWindow.setId(rset.getInt("id"));
						this.commitmentsWindow.setIsSameDate(true);
						this.commitmentsWindow.getTextField1().setText(rset.getString("hour7"));
						this.commitmentsWindow.getTextField2().setText(rset.getString("hour8"));
						this.commitmentsWindow.getTextField3().setText(rset.getString("hour9"));
						this.commitmentsWindow.getTextField4().setText(rset.getString("hour10"));
						this.commitmentsWindow.getTextField5().setText(rset.getString("hour11"));
						this.commitmentsWindow.getTextField6().setText(rset.getString("hour12"));
						this.commitmentsWindow.getTextField7().setText(rset.getString("hour13"));
						this.commitmentsWindow.getTextField8().setText(rset.getString("hour14"));
						this.commitmentsWindow.getTextField9().setText(rset.getString("hour15"));
						this.commitmentsWindow.getTextField10().setText(rset.getString("hour16"));
						this.commitmentsWindow.getTextField11().setText(rset.getString("hour17"));
						this.commitmentsWindow.getTextField12().setText(rset.getString("hour18"));
					}
					else {
						this.commitmentsWindow.setIsSameDate(false);
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
