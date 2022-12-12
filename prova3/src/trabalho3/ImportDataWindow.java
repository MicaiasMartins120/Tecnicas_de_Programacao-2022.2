package trabalho3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ImportDataWindow extends JFrame implements ActionListener{
	private JButton importData;
	private Button returnButton;
	
	public ImportDataWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 200));
		
		this.importData = new JButton();
		
		importData.setText("Importar palpites para arquivo");
		importData.addActionListener(this);
		this.add(importData);
		
		this.returnButton = new Button();
		returnButton.newButton(window);
		returnButton.setText("Voltar");
		this.add(returnButton);
		
		this.pack();
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == importData) {
			String sql = "select * from palpites_copa";
			Conection conection = new Conection();
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				FileWriter writer = new FileWriter("lib/palpitesImportados.txt");
				try {
					conection.getConection();
					pstm = (PreparedStatement) conection.getConection().prepareStatement(sql);
					rset = pstm.executeQuery();
					
					while(rset.next()) {
						writer.write(rset.getString("name") + ";");
						
						writer.write(rset.getString("quartersTeam1") + ";");
						writer.write(rset.getInt("quartersTeam1Score") + ";");
						writer.write(rset.getString("quartersTeam2") + ";");
						writer.write(rset.getInt("quartersTeam2Score") + ";");
						writer.write(rset.getString("quartersTeam3") + ";");
						writer.write(rset.getInt("quartersTeam3Score") + ";");
						writer.write(rset.getString("quartersTeam4") + ";");
						writer.write(rset.getInt("quartersTeam4Score") + ";");
						writer.write(rset.getString("quartersTeam5") + ";");
						writer.write(rset.getInt("quartersTeam5Score") + ";");
						writer.write(rset.getString("quartersTeam6") + ";");
						writer.write(rset.getInt("quartersTeam6Score") + ";");
						writer.write(rset.getString("quartersTeam7") + ";");
						writer.write(rset.getInt("quartersTeam7Score") + ";");
						writer.write(rset.getString("quartersTeam8") + ";");
						writer.write(rset.getInt("quartersTeam8Score") + ";");
						
						writer.write(rset.getString("semiTeam1") + ";");
						writer.write(rset.getInt("semiTeam1Score") + ";");
						writer.write(rset.getString("semiTeam2") + ";");
						writer.write(rset.getInt("semiTeam2Score") + ";");
						writer.write(rset.getString("semiTeam3") + ";");
						writer.write(rset.getInt("semiTeam3Score") + ";");
						writer.write(rset.getString("semiTeam4") + ";");
						writer.write(rset.getInt("semiTeam4Score") + ";");
						
						writer.write(rset.getString("finalTeam1") + ";");
						writer.write(rset.getInt("finalTeam1Score") + ";");
						writer.write(rset.getString("finalTeam2") + ";");
						writer.write(rset.getInt("finalTeam2Score") + ";");
						
						writer.write(rset.getString("winner") + "\n");
					}
					
					pstm.execute();
					conection.getConection().close();
					writer.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Palpites importados !!!", "Mensage", JOptionPane.PLAIN_MESSAGE);
			this.setVisible(true);
		}
		if(e.getSource() == returnButton) {
			this.setVisible(false);
		}
	}
}
