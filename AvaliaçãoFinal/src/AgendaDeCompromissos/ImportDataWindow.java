package AgendaDeCompromissos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ImportDataWindow extends JFrame implements ActionListener{
	private JButton importData;
	private Button returnButton;
	private final SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
	
	public ImportDataWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 200));
		
		this.importData = new JButton();
		
		importData.setText("Importar compromissos para arquivo");
		importData.addActionListener(this);
		this.add(importData);
		
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
		if(e.getSource() == importData) {
			String sql = "select * from compromissos";
			Conection conection = new Conection();
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				FileWriter writer = new FileWriter("lib/compromissosImportados.txt");
				try {
					conection.getConection();
					pstm = (PreparedStatement) conection.getConection().prepareStatement(sql);
					rset = pstm.executeQuery();
					
					while(rset.next()) {
						writer.write(dateFormat.format(rset.getDate("date")) + ";");
						
						if(rset.getString("hour7").equals("") == false) {
							writer.write("7:00;");
							writer.write(rset.getString("hour7") + ";");
						}
						if(rset.getString("hour8").equals("") == false) {
							writer.write("8:00;");
							writer.write(rset.getString("hour8") + ";");
						}
						if(rset.getString("hour9").equals("") == false) {
							writer.write("9:00;");
							writer.write(rset.getString("hour9") + ";");
						}
						if(rset.getString("hour10").equals("") == false) {
							writer.write("10:00;");
							writer.write(rset.getString("hour10") + ";");
						}
						if(rset.getString("hour11").equals("") == false) {
							writer.write("11:00;");
							writer.write(rset.getString("hour11") + ";");
						}
						if(rset.getString("hour12").equals("") == false) {
							writer.write("12:00;");
							writer.write(rset.getString("hour12") + ";");
						}
						if(rset.getString("hour13").equals("") == false) {
							writer.write("13:00;");
							writer.write(rset.getString("hour13") + ";");
						}
						if(rset.getString("hour14").equals("") == false) {
							writer.write("14:00;");
							writer.write(rset.getString("hour14") + ";");
						}
						if(rset.getString("hour15").equals("") == false) {
							writer.write("15:00;");
							writer.write(rset.getString("hour15") + ";");
						}
						if(rset.getString("hour16").equals("") == false) {
							writer.write("16:00;");
							writer.write(rset.getString("hour16") + ";");
						}
						if(rset.getString("hour17").equals("") == false) {
							writer.write("17:00;");
							writer.write(rset.getString("hour17") + ";");
						}
						if(rset.getString("hour18").equals("") == false) {
							writer.write("18:00;");
							writer.write(rset.getString("hour18") + ";");
						}
						
						writer.write("\n");
					}
					
					pstm.execute();
					conection.getConection().close();
					writer.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Compromissos importados !!!", "Mensage", JOptionPane.PLAIN_MESSAGE);
			this.setVisible(true);
		}
		if(e.getSource() == returnButton) {
			this.setVisible(false);
		}
	}
}
