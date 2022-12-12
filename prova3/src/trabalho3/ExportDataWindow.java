package trabalho3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExportDataWindow extends JFrame implements ActionListener{
	private JButton exportData;
	private Button returnButton;
	
	public ExportDataWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 150));
		
		this.exportData = new JButton();
		
		exportData.setText("Exportar arquivo com palpites");
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
			String sql = "insert into palpites_copa (name, quartersTeam1, quartersTeam1Score, quartersTeam2, quartersTeam2Score, quartersTeam3, quartersTeam3Score, quartersTeam4, quartersTeam4Score, quartersTeam5, quartersTeam5Score, quartersTeam6, quartersTeam6Score, quartersTeam7, quartersTeam7Score, quartersTeam8, quartersTeam8Score, semiTeam1, semiTeam1Score, semiTeam2, semiTeam2Score, semiTeam3, semiTeam3Score, semiTeam4, semiTeam4Score, finalTeam1, finalTeam1Score, finalTeam2, finalTeam2Score, Winner) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
						
						int data = fileReader.read();
						int i = 1;
						while(data != -1) {
							if(i == 1) {
								String result = "";
								while(data != 59) {
									result += (char) data;
									data = fileReader.read();
								}
								System.out.println(result);
								pstm.setString(i, result);
							}
							if(i % 2 == 0) {
								String result = "";
								while(data != 59 && data != -1) {
									result += (char) data;
									data = fileReader.read();
								}
								System.out.println(result);
								pstm.setString(i, result);
							}
							else if(i % 2 != 0 && i != 1){
								String result = "";
								while(data != 59) {
									result += (char) data;
									data = fileReader.read();
								}
								System.out.println(result);
								pstm.setInt(i, Integer.parseInt(result));
							}
							i++;
							data = fileReader.read();
						}
						fileReader.close();
						
						pstm.execute();
						conection.getConection().close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
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
