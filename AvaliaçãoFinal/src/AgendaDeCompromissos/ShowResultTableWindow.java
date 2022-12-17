package AgendaDeCompromissos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ShowResultTableWindow extends JFrame implements ActionListener{
	private final SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
	
	public ShowResultTableWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(1000, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 10));
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Data");
		model.addColumn("7:00");
		model.addColumn("8:00");
		model.addColumn("9:00");
		model.addColumn("10:00");
		model.addColumn("11:00");
		model.addColumn("12:00");
		model.addColumn("13:00");
		model.addColumn("14:00");
		model.addColumn("15:00");
		model.addColumn("16:00");
		model.addColumn("17:00");
		model.addColumn("18:00");
		
		String sql = "select * from compromissos";
		Conection conection = new Conection();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conection.getConection();
			pstm = (PreparedStatement) conection.getConection().prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Object[] newRow = {dateFormat.format(rset.getDate("date")), 
						rset.getString("hour7"), rset.getString("hour8"), rset.getString("hour9"), 
						rset.getString("hour10"), rset.getString("hour11"), rset.getString("hour12"),
						rset.getString("hour13"), rset.getString("hour14"), rset.getString("hour15"),
						rset.getString("hour16"), rset.getString("hour17"), rset.getString("hour18")};
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
		scrollPane.setPreferredSize(new Dimension(950, 400));
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(200);
		columnModel.getColumn(1).setPreferredWidth(200);
		columnModel.getColumn(2).setPreferredWidth(200);
		columnModel.getColumn(3).setPreferredWidth(200);
		columnModel.getColumn(4).setPreferredWidth(200);
		columnModel.getColumn(5).setPreferredWidth(200);
		columnModel.getColumn(6).setPreferredWidth(200);
		columnModel.getColumn(7).setPreferredWidth(200);
		columnModel.getColumn(8).setPreferredWidth(200);
		columnModel.getColumn(9).setPreferredWidth(200);
		columnModel.getColumn(10).setPreferredWidth(200);
		columnModel.getColumn(11).setPreferredWidth(200);
		columnModel.getColumn(12).setPreferredWidth(200);
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