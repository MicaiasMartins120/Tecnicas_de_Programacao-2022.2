package trabalho3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class showResultTableWindow extends JFrame implements ActionListener{
	
	public showResultTableWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(900, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 10));
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Participante");
		model.addColumn("Placar Quartas");
		model.addColumn("Placar Semi");
		model.addColumn("Placar Final");
		model.addColumn("Campeão");
		
		String sql = "select * from palpites_copa";
		Conection conection = new Conection();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conection.getConection();
			pstm = (PreparedStatement) conection.getConection().prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Object[] newRow = {rset.getString("name"), 
						rset.getString("quartersTeam1") + " " + rset.getInt("quartersTeam1Score") + " X "
						+ rset.getString("quartersTeam2") + " " + rset.getInt("quartersTeam2Score") + " - "
						+ rset.getString("quartersTeam3") + " " + rset.getInt("quartersTeam3Score") + " X "
						+ rset.getString("quartersTeam4") + " " + rset.getInt("quartersTeam4Score") + " - "
						+ rset.getString("quartersTeam5") + " " + rset.getInt("quartersTeam5Score") + " X "
						+ rset.getString("quartersTeam6") + " " + rset.getInt("quartersTeam6Score") + " - "
						+ rset.getString("quartersTeam7") + " " + rset.getInt("quartersTeam7Score") + " X "
						+ rset.getString("quartersTeam8") + " " + rset.getInt("quartersTeam8Score"),
						rset.getString("semiTeam1") + " " + rset.getInt("semiTeam1Score") + " X "
						+ rset.getString("semiTeam2") + " " + rset.getInt("semiTeam2Score") + " - "
						+ rset.getString("semiTeam3") + " " + rset.getInt("semiTeam3Score") + " X "
						+ rset.getString("semiTeam4") + " " + rset.getInt("semiTeam4Score"),
						rset.getString("finalTeam1") + " " + rset.getInt("finalTeam1Score") + " X "
						+ rset.getString("finalTeam2") + " " + rset.getInt("finalTeam2Score"),
						rset.getString("winner")};
				model.addRow(newRow);
			}
			
			pstm.execute();
			conection.getConection().close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JTable table = new JTable(model);
		table.setRowHeight(100);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(850, 400));
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(80);
		columnModel.getColumn(1).setPreferredWidth(400);
		columnModel.getColumn(2).setPreferredWidth(200);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(70);
		this.add(scrollPane);
		
		Button returnButton = new Button();
		returnButton.newButton(window);
		returnButton.setText("Voltar");
		returnButton.addActionListener(this);
		this.add(returnButton);
		
		this.pack();
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
