package trabalho3;

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
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 400, 70));
		
		Button registerNewData = new Button();
		registerNewData.newButton(new NewDataWindow(this));
		registerNewData.addActionListener(this);
		registerNewData.setText("Registrar novo palpite");
		this.add(registerNewData);
		
		Button viewOldDatas = new Button();
		viewOldDatas.newButton(new showResultTableWindow(this));
		viewOldDatas.addActionListener(this);
		viewOldDatas.setText("Visualizar palpites cadastrados");
		this.add(viewOldDatas);
		
		Button exportData = new Button();
		exportData.newButton(new ExportDataWindow(this));
		exportData.addActionListener(this);
		exportData.setText("Exportar arquivo com palpites");
		this.add(exportData);
		
		Button importData = new Button();
		importData.newButton(new ImportDataWindow(this));
		importData.addActionListener(this);
		importData.setText("Importar arquivo com palpites");
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
