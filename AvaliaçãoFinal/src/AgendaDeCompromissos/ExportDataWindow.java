package AgendaDeCompromissos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExportDataWindow extends JFrame implements ActionListener{
	private JButton exportData;
	private Button returnButton;
	private final SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
	
	public ExportDataWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 150));
		
		this.exportData = new JButton();
		
		exportData.setText("Exportar arquivo com compromissos");
		exportData.addActionListener(this);
		this.add(exportData);
		
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
		if(e.getSource() == exportData) {
			String sql = "insert into compromissos (date, hour7, hour8, hour9, hour10, hour11, hour12, hour13, hour14, hour15, hour16, hour17, hour18) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Conection conection = new Conection();
			PreparedStatement pstm = null;
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("C:\\Users\\micai\\OneDrive\\Documentos"));
			int response = fileChooser.showOpenDialog(null);
			
			if(response == JFileChooser.APPROVE_OPTION) {
				try {
					FileReader fileReader = new FileReader(fileChooser.getSelectedFile());
					
					try {
						conection.getConection();
						pstm = (PreparedStatement) conection.getConection().prepareStatement(sql);
						
						CommitmentsDAO commitments = new CommitmentsDAO();
						int data = fileReader.read();
						int i = 1;
						while(data != -1) {
							if(i == 1) {
								String result = "";
								while(data != 59) {
									result += (char) data;
									data = fileReader.read();
								}
								Date date;
								Calendar cal = Calendar.getInstance();
								try {
									cal.setTime(dateFormat.parse(result));
								} catch (ParseException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								date = new java.sql.Date(cal.getTimeInMillis());
								pstm.setDate(i, date);
							}
							else {
								String result = "";
								while(data != 59 && data != -1 && data != 10) {
									result += (char) data;
									data = fileReader.read();
								}
								
								switch (result) {
								case "7:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(0, result);
									break;
								case "8:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(1, result);
									break;
								case "9:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(2, result);
									break;
								case "10:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(3, result);
									break;
								case "11:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(4, result);
									break;
								case "12:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(5, result);
									break;
								case "13:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(6, result);
									break;
								case "14:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(7, result);
									break;
								case "15:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(8, result);
									break;
								case "16:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(9, result);
									break;
								case "17:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(10, result);
									break;
								case "18:00":
									result = "";
									data = fileReader.read();
									while(data != 59 && data != -1) {
										result += (char) data;
										data = fileReader.read();
									}
									commitments.setCommitment(11, result);
									break;
								default:
									break;
								}
							}
							i++;
							data = fileReader.read();
						}
						for (int j = 0; j < commitments.getCommitmentsList().length; j++) {
							pstm.setString(j + 2, commitments.getCommitmentsList()[j]);
						}
						
						fileReader.close();
						pstm.execute();
						conection.getConection().close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 
			}
			JOptionPane.showMessageDialog(null, "Arquivo exportado !!!", "Mensage", JOptionPane.PLAIN_MESSAGE);
			
			this.setVisible(true);
		}
		if(e.getSource() == returnButton) {
			this.setVisible(false);
		}
	}
}
