package trabalho2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MapUnit extends Button implements ActionListener {
	private int PositionX;
	private int PositionY;
	private Button button;
	private GoalMapping mapping;
	private Boolean playingStatus;
	private Boolean defenseAreaUnit;
	private Boolean lastOcurrencyIsGol;
	
	public MapUnit(int PositionX, int PositionY, Button button, GoalMapping mapping, Boolean defenseAreaUnit, Boolean playingStatus) {
		this.PositionX = PositionX;
		this.PositionY = PositionY;
		this.button = button;
		this.mapping = mapping;
		this.defenseAreaUnit = defenseAreaUnit;
		setButtonConfig();
		button.addActionListener(this);
	}
	
	public void setButtonConfig() {
		if(this.mapping == GoalMapping.OUTGOAL) {
			this.button.setBackground(Color.BLUE);
		}
		else if(this.mapping == GoalMapping.ONGOALPOST) {
			this.button.setBackground(Color.WHITE);
		}
		else if(this.mapping == GoalMapping.ONGOAL) {
			this.button.setBackground(Color.BLUE);
		}
	}
	
	public void playAudioCaseDefense() {
		File file = new File("assets/sai-que-e-sua-tafarel.wav");
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
	}
	
	public void playAudioCaseGoal() {
		File file = new File("assets/olha_o_gol.wav");
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
	}
	
	public void actionPerformed(ActionEvent e) {
		if(this.getCont() > 1) {
			this.setPlayingStatus(false);
			JOptionPane.showMessageDialog(null, "Click in 'Next turn' or 'Play' button to keep playing !", "Warning", JOptionPane.WARNING_MESSAGE);
		}
		if(this.getPlayingStatus() == true) {
			ImageIcon icon = new ImageIcon("assets/Ball.png");
			icon.setImage(icon.getImage().getScaledInstance(this.button.getWidth() - 10, this.button.getHeight() - 10, 1));
			this.button.setIcon(icon);
			if(this.getDefenseAreaUnit() != true && this.getGoalMapping() == GoalMapping.ONGOAL) {
				this.setLastOcurrencyIsGol(true);
				playAudioCaseGoal();
			}
			else if(this.getDefenseAreaUnit() == true && this.getGoalMapping() == GoalMapping.ONGOAL) {
				this.setLastOcurrencyIsGol(false);
				playAudioCaseDefense();
			}
			else if(this.getGoalMapping() != GoalMapping.ONGOAL) {
				this.setLastOcurrencyIsGol(false);
			}
		}
	}
	
	public int getPositionX() {
		return PositionX;
	}
	
	public void setPositionX(int positionX) {
		PositionX = positionX;
	}
	
	public int getPositionY() {
		return PositionY;
	}
	
	public void setPositionY(int positionY) {
		PositionY = positionY;
	}

	public Button getButton() {
		return button;
	}
	
	public GoalMapping getGoalMapping() {
		return mapping;
	}

	public Boolean getDefenseAreaUnit() {
		return defenseAreaUnit;
	}
	
	public void setDefenseAreaUnit(Boolean defenseAreaUnit) {
		this.defenseAreaUnit = defenseAreaUnit;
	}

	public Boolean getPlayingStatus() {
		return playingStatus;
	}

	public void setPlayingStatus(Boolean playingStatus) {
		this.playingStatus = playingStatus;
	}

	public Boolean getLastOcurrencyIsGol() {
		return lastOcurrencyIsGol;
	}

	public void setLastOcurrencyIsGol(Boolean lastOcurrencyIsGol) {
		this.lastOcurrencyIsGol = lastOcurrencyIsGol;
	}
}
