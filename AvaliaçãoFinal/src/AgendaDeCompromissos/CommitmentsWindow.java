package AgendaDeCompromissos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CommitmentsWindow extends JFrame implements ActionListener{
	private Button send;
	private Button returnButton;
	private JTextField textField1 = new JTextField();
	private JTextField textField2 = new JTextField();
	private JTextField textField3 = new JTextField();
	private JTextField textField4 = new JTextField();
	private JTextField textField5 = new JTextField();
	private JTextField textField6 = new JTextField();
	private JTextField textField7 = new JTextField();
	private JTextField textField8 = new JTextField();
	private JTextField textField9 = new JTextField();
	private JTextField textField10 = new JTextField();
	private JTextField textField11 = new JTextField();
	private JTextField textField12 = new JTextField();
	private int id;
	private Date date;
	private Boolean isSameDate;
	
	public CommitmentsWindow(InitialWindow window, NewDataWindow window1) {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
		
		JLabel label = new JLabel();
		label.setText("INSIRA OU ALTERE OS COMPROMISSOS");
		label.setPreferredSize(new Dimension(800, 30));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label);
		
		JLabel label1 = new JLabel();
		label1.setText("7:00");
		label1.setPreferredSize(new Dimension(40, 30));
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label2 = new JLabel();
		label2.setText("8:00");
		label2.setPreferredSize(new Dimension(40, 30));
		label2.setHorizontalTextPosition(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label3 = new JLabel();
		label3.setText("9:00");
		label3.setPreferredSize(new Dimension(40, 30));
		label3.setHorizontalTextPosition(JLabel.CENTER);
		label3.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label4 = new JLabel();
		label4.setText("10:00");
		label4.setPreferredSize(new Dimension(40, 30));
		label4.setHorizontalTextPosition(JLabel.CENTER);
		label4.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label5 = new JLabel();
		label5.setText("11:00");
		label5.setPreferredSize(new Dimension(40, 30));
		label5.setHorizontalTextPosition(JLabel.CENTER);
		label5.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label6 = new JLabel();
		label6.setText("12:00");
		label6.setPreferredSize(new Dimension(40, 30));
		label6.setHorizontalTextPosition(JLabel.CENTER);
		label6.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label7 = new JLabel();
		label7.setText("13:00");
		label7.setPreferredSize(new Dimension(40, 30));
		label7.setHorizontalTextPosition(JLabel.CENTER);
		label7.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label8 = new JLabel();
		label8.setText("14:00");
		label8.setPreferredSize(new Dimension(40, 30));
		label8.setHorizontalTextPosition(JLabel.CENTER);
		label8.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label9 = new JLabel();
		label9.setText("15:00");
		label9.setPreferredSize(new Dimension(40, 30));
		label9.setHorizontalTextPosition(JLabel.CENTER);
		label9.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label10 = new JLabel();
		label10.setText("16:00");
		label10.setPreferredSize(new Dimension(40, 30));
		label10.setHorizontalTextPosition(JLabel.CENTER);
		label10.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label11 = new JLabel();
		label11.setText("17:00");
		label11.setPreferredSize(new Dimension(40, 30));
		label11.setHorizontalTextPosition(JLabel.CENTER);
		label11.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label12 = new JLabel();
		label12.setText("18:00");
		label12.setPreferredSize(new Dimension(40, 30));
		label12.setHorizontalTextPosition(JLabel.CENTER);
		label12.setHorizontalAlignment(JLabel.CENTER);
		
		this.getTextField1().setPreferredSize(new Dimension(330, 30));
		this.getTextField2().setPreferredSize(new Dimension(330, 30));
		this.getTextField3().setPreferredSize(new Dimension(330, 30));
		this.getTextField4().setPreferredSize(new Dimension(330, 30));
		this.getTextField5().setPreferredSize(new Dimension(330, 30));
		this.getTextField6().setPreferredSize(new Dimension(330, 30));
		this.getTextField7().setPreferredSize(new Dimension(330, 30));
		this.getTextField8().setPreferredSize(new Dimension(330, 30));
		this.getTextField9().setPreferredSize(new Dimension(330, 30));
		this.getTextField10().setPreferredSize(new Dimension(330, 30));
		this.getTextField11().setPreferredSize(new Dimension(330, 30));
		this.getTextField12().setPreferredSize(new Dimension(330, 30));
		
		this.add(label1);
		this.add(this.textField1);
		this.add(label2);
		this.add(this.textField2);
		this.add(label3);
		this.add(this.textField3);
		this.add(label4);
		this.add(this.textField4);
		this.add(label5);
		this.add(this.textField5);
		this.add(label6);
		this.add(this.textField6);
		this.add(label7);
		this.add(this.textField7);
		this.add(label8);
		this.add(this.textField8);
		this.add(label9);
		this.add(this.textField9);
		this.add(label10);
		this.add(this.textField10);
		this.add(label11);
		this.add(this.textField11);
		this.add(label12);
		this.add(this.textField12);
		
		this.send = new Button();
		send.newButton(window);
		send.addActionListener(this);
		send.setText("Enviar");
		this.add(send);
		
		this.returnButton = new Button();
		returnButton.newButton(window1);
		returnButton.setText("Voltar");
		returnButton.addActionListener(this);
		this.add(returnButton);
		
		this.pack();
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == send) {
			if(this.isSameDate == true) {
				String sql = "update compromissos set hour7 = ?, hour8 = ?, hour9 = ?, hour10 = ?, hour11 = ?, hour12 = ?, hour13 = ?, hour14 = ?, hour15 = ?, hour16 = ?, hour17 = ?, hour18 = ? where id = ?";
				Conection conection = new Conection();
				PreparedStatement pstm = null;
				try {
					conection.getConection();
					pstm = (PreparedStatement) conection.getConection().prepareStatement(sql);
					
					for (int i = 1; i < 13; i++) {
						switch (i) {
						case 1:
							pstm.setString(i, this.textField1.getText());
							break;
						case 2:
							pstm.setString(i, this.textField2.getText());
							break;
						case 3:
							pstm.setString(i, this.textField3.getText());
							break;
						case 4:
							pstm.setString(i, this.textField4.getText());
							break;
						case 5:
							pstm.setString(i, this.textField5.getText());
							break;
						case 6:
							pstm.setString(i, this.textField6.getText());
							break;
						case 7:
							pstm.setString(i, this.textField7.getText());
							break;
						case 8:
							pstm.setString(i, this.textField8.getText());
							break;
						case 9:
							pstm.setString(i, this.textField9.getText());
							break;
						case 10:
							pstm.setString(i, this.textField10.getText());
							break;
						case 11:
							pstm.setString(i, this.textField11.getText());
							break;
						case 12:
							pstm.setString(i, this.textField12.getText());
							break;
						default:
							break;
						}
						
						pstm.setInt(13, this.id);
					}
					
					pstm.execute();
					conection.getConection().close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			else {
				String sql = "insert into compromissos (date, hour7, hour8, hour9, hour10, hour11, hour12, hour13, hour14, hour15, hour16, hour17, hour18) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				Conection conection = new Conection();
				PreparedStatement pstm = null;
				try {
					conection.getConection();
					pstm = (PreparedStatement) conection.getConection().prepareStatement(sql);
					
					for (int i = 1; i < 14; i++) {
						switch (i) {
						case 1:
							pstm.setDate(i, this.date);
							break;
						case 2:
							pstm.setString(i, this.textField1.getText());
							break;
						case 3:
							pstm.setString(i, this.textField2.getText());
							break;
						case 4:
							pstm.setString(i, this.textField3.getText());
							break;
						case 5:
							pstm.setString(i, this.textField4.getText());
							break;
						case 6:
							pstm.setString(i, this.textField5.getText());
							break;
						case 7:
							pstm.setString(i, this.textField6.getText());
							break;
						case 8:
							pstm.setString(i, this.textField7.getText());
							break;
						case 9:
							pstm.setString(i, this.textField8.getText());
							break;
						case 10:
							pstm.setString(i, this.textField9.getText());
							break;
						case 11:
							pstm.setString(i, this.textField10.getText());
							break;
						case 12:
							pstm.setString(i, this.textField11.getText());
							break;
						case 13:
							pstm.setString(i, this.textField12.getText());
							break;
						default:
							break;
						}
					}
					
					pstm.execute();
					conection.getConection().close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			this.setVisible(false);
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
	
	public JTextField getTextField1() {
		return this.textField1;
	}
	
	public JTextField getTextField2() {
		return this.textField2;
	}
	
	public JTextField getTextField3() {
		return this.textField3;
	}
	
	public JTextField getTextField4() {
		return this.textField4;
	}
	
	public JTextField getTextField5() {
		return this.textField5;
	}
	
	public JTextField getTextField6() {
		return this.textField6;
	}
	
	public JTextField getTextField7() {
		return this.textField7;
	}
	
	public JTextField getTextField8() {
		return this.textField8;
	}
	
	public JTextField getTextField9() {
		return this.textField9;
	}
	
	public JTextField getTextField10() {
		return this.textField10;
	}
	
	public JTextField getTextField11() {
		return this.textField11;
	}
	
	public JTextField getTextField12() {
		return this.textField12;
	}

	public Boolean getIsSameDate() {
		return isSameDate;
	}

	public void setIsSameDate(Boolean isSameDate) {
		this.isSameDate = isSameDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
