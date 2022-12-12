package trabalho3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FinalWindow extends JFrame implements ActionListener{
	private WinnerWindow winnerWindow;
	private UserDAO user;
	private QuartersTeamsDAO quartersTeams;
	private SemiTeamsDAO semiTeams;
	private FinalTeamsDAO finalTeams;
	private String winner;
	private JTextField textField1 = new JTextField();
	private JTextField textField2;
	private JTextField textField3 = new JTextField();
	private JTextField textField4;
	
	public FinalWindow(InitialWindow window) {
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 120));
		
		JLabel label = new JLabel();
		label.setText("SELEÇÃO - PLACAR     X     SELEÇÃO - PLACAR");
		label.setPreferredSize(new Dimension(600, 30));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		this.add(label);
		
		this.add(this.textField1);
		this.textField1.setBackground(Color.GRAY);
		this.textField1.setEditable(false);
		textField1.setBackground(Color.BLACK);
		textField1.setForeground(Color.WHITE);
		textField1.setCaretColor(Color.WHITE);
		
		JTextField textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension(30, 30));
		textField2.setBackground(Color.BLACK);
		textField2.setForeground(Color.WHITE);
		textField2.setCaretColor(Color.WHITE);
		this.add(textField2);
		this.textField2 = textField2;
		
		this.add(this.textField3);
		this.textField3.setBackground(Color.GRAY);
		this.textField3.setEditable(false);
		textField3.setBackground(Color.BLACK);
		textField3.setForeground(Color.WHITE);
		textField3.setCaretColor(Color.WHITE);
		
		JTextField textField4 = new JTextField();
		textField4.setPreferredSize(new Dimension(30, 30));
		textField4.setBackground(Color.BLACK);
		textField4.setForeground(Color.WHITE);
		textField4.setCaretColor(Color.WHITE);
		this.add(textField4);
		this.textField4 = textField4;
		
		Button send = new Button();
		WinnerWindow winnerWindow = new WinnerWindow(window);
		this.winnerWindow = winnerWindow;
		send.newButton(this.winnerWindow);
		send.addActionListener(this);
		send.setText("Enviar");
		this.add(send);
		
		this.pack();
		this.setVisible(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FinalTeamsDAO finalTeams = new FinalTeamsDAO(new ArrayList<TeamDAO>());
		finalTeams.setTeamList(new TeamDAO(textField1.getText(), textField2.getText()));
		finalTeams.setTeamList(new TeamDAO(textField3.getText(), textField4.getText()));
		this.finalTeams = finalTeams;
		this.winnerWindow.setUser(this.user);
		this.winnerWindow.setQuartersTeams(this.quartersTeams);
		this.winnerWindow.setSemiTeams(this.semiTeams);
		this.winnerWindow.setFinalTeams(this.finalTeams);
		
		if(Integer.parseInt(finalTeams.getTeamList().get(0).getScore()) > Integer.parseInt(finalTeams.getTeamList().get(1).getScore())) {
			this.winner = finalTeams.getTeamList().get(0).getName();
		}
		else {
			this.winner = finalTeams.getTeamList().get(1).getName();
		}
		
		switch (this.winner) {
		case "BRA":
			ImageIcon icon1 = new ImageIcon("assets/bandeiraBrasil.jpg");
			icon1.setImage(icon1.getImage().getScaledInstance(800, 450, 1));
			winnerWindow.getLabel().setIcon(icon1);
			break;
		case "FRA":
			ImageIcon icon2 = new ImageIcon("assets/bandeiraFranca.png");
			icon2.setImage(icon2.getImage().getScaledInstance(800, 450, 1));
			winnerWindow.getLabel().setIcon(icon2);
			break;
		case "POR":
			ImageIcon icon3 = new ImageIcon("assets/bandeiraPortugal.jpg");
			icon3.setImage(icon3.getImage().getScaledInstance(800, 450, 1));
			winnerWindow.getLabel().setIcon(icon3);
			break;
		case "MAR":
			ImageIcon icon4 = new ImageIcon("assets/bandeiraMarrocos.jpg");
			icon4.setImage(icon4.getImage().getScaledInstance(800, 450, 1));
			winnerWindow.getLabel().setIcon(icon4);
			break;
		case "HOL":
			ImageIcon icon5 = new ImageIcon("assets/bandeiraHolanda.png");
			icon5.setImage(icon5.getImage().getScaledInstance(800, 450, 1));
			winnerWindow.getLabel().setIcon(icon5);
			break;
		case "CRO":
			ImageIcon icon6 = new ImageIcon("assets/bandeiraCroacia.jpg");
			icon6.setImage(icon6.getImage().getScaledInstance(800, 450, 1));
			winnerWindow.getLabel().setIcon(icon6);
			break;
		case "ARG":
			ImageIcon icon7 = new ImageIcon("assets/bandeiraArgentina.png");
			icon7.setImage(icon7.getImage().getScaledInstance(800, 450, 1));
			winnerWindow.getLabel().setIcon(icon7);
			break;
		case "ING":
			ImageIcon icon8 = new ImageIcon("assets/bandeiraInglaterra.png");
			icon8.setImage(icon8.getImage().getScaledInstance(800, 450, 1));
			winnerWindow.getLabel().setIcon(icon8);
			break;
		default:
			break;
		}
		
		String sql = "insert into palpites_copa (name, quartersTeam1, quartersTeam1Score, quartersTeam2, quartersTeam2Score, quartersTeam3, quartersTeam3Score, quartersTeam4, quartersTeam4Score, quartersTeam5, quartersTeam5Score, quartersTeam6, quartersTeam6Score, quartersTeam7, quartersTeam7Score, quartersTeam8, quartersTeam8Score, semiTeam1, semiTeam1Score, semiTeam2, semiTeam2Score, semiTeam3, semiTeam3Score, semiTeam4, semiTeam4Score, finalTeam1, finalTeam1Score, finalTeam2, finalTeam2Score, Winner) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Conection conection = new Conection();
		PreparedStatement pstm = null;
		try {
			conection.getConection();
			pstm = (PreparedStatement) conection.getConection().prepareStatement(sql);
			
			int i = 1;
			if(i == 1) {
				pstm.setString(i, this.user.getName());
				i++;
			}
			if(i > 1 && i <18) {
				for (TeamDAO quartersTeam : this.quartersTeams.getTeamList()) {
					if(i % 2 == 0) {
						pstm.setString(i, quartersTeam.getName());
						i++;
					}
					if(i % 2 != 0) {
						pstm.setString(i, quartersTeam.getScore());
						i++;
					}
				}
			}
			if(i >= 18 && i < 26) {
				for (TeamDAO semiTeam : this.semiTeams.getTeamList()) {
					if(i % 2 == 0) {
						pstm.setString(i, semiTeam.getName());
						i++;
					}
					if(i % 2 != 0) {
						pstm.setString(i, semiTeam.getScore());
						i++;
					}
				}
			}
			if(i >= 26 && i < 30) {
				for (TeamDAO finalTeam : this.finalTeams.getTeamList()) {
					if(i % 2 == 0) {
						pstm.setString(i, finalTeam.getName());
						i++;
					}
					if(i % 2 != 0) {
						pstm.setString(i, finalTeam.getScore());
						i++;
					}
				}
			}
			if(i == 30) {
				pstm.setString(i, this.winner);
				i++;
			}
			
			pstm.execute();
			conection.getConection().close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		this.setVisible(false);
	}

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}

	public QuartersTeamsDAO getQuartersTeams() {
		return quartersTeams;
	}

	public void setQuartersTeams(QuartersTeamsDAO quartersTeams) {
		this.quartersTeams = quartersTeams;
	}

	public SemiTeamsDAO getSemiTeams() {
		return semiTeams;
	}

	public void setSemiTeams(SemiTeamsDAO semiTeams) {
		this.semiTeams = semiTeams;
	}
	
	public FinalTeamsDAO getFinalTeams() {
		return finalTeams;
	}

	public void setFinalTeams(FinalTeamsDAO finalTeams) {
		this.finalTeams = finalTeams;
	}
	
	public JTextField getTextField1() {
		return textField1;
	}
	
	public JTextField getTextField3() {
		return textField3;
	}
	
	public void setTextField1(JTextField textField1) {
		this.textField1 = textField1;
	}
	
	public void setTextField3(JTextField textField3) {
		this.textField3 = textField3;
	}
}
