package AgendaDeCompromissos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class InitialWindow extends JFrame implements ActionListener{
	public InitialWindow() {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 400, 50));
		
		Button registerNewData = new Button();
		registerNewData.newButton(new NewDataWindow(this));
		registerNewData.addActionListener(this);
		registerNewData.setText("Cadastrar novo compromisso");
		this.add(registerNewData);
		
		Button viewOldDatas = new Button();
		viewOldDatas.newButton(new ShowResultTableWindow(this));
		viewOldDatas.addActionListener(this);
		viewOldDatas.setText("Visualizar compromissos cadastrados");
		this.add(viewOldDatas);
		
		Button searchDate = new Button();
		searchDate.newButton(new SearchDateWindow(this));
		searchDate.addActionListener(this);
		searchDate.setText("Visualizar compromissos por data");
		this.add(searchDate);
		
		Button exportData = new Button();
		exportData.newButton(new ExportDataWindow(this));
		exportData.addActionListener(this);
		exportData.setText("Exportar arquivo com compromissos");
		this.add(exportData);
		
		Button importData = new Button();
		importData.newButton(new ImportDataWindow(this));
		importData.addActionListener(this);
		importData.setText("Importar arquivo com compromissos");
		this.add(importData);
		
		JButton exit = new JButton();
		exit.setText("Sair");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.add(exit);
		
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
