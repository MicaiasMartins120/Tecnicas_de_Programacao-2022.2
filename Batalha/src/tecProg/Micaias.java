package tecProg;

import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.HitWallEvent;
import robocode.HitRobotEvent;
import robocode.WinEvent;

public class Micaias extends AdvancedRobot {
	int direction;
	
    public void run(){
        setColors(Color.red, Color.gray, Color.red);
        setRadarColor(Color.red);
    
        while(true) {
            ahead(100);
            direction = 1;
            turnLeft(35);
            turnGunRight(360);
            turnRight(30);
            back(90);
            direction = 0;
            turnGunRight(360);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        if (e.getDistance() < 50 && getEnergy() > 30) {
            fire(3);
        }
        else if(e.getDistance() < 100 && getEnergy() > 50) {
            fire(2);
        }
        else {
            fire(1);
        }
        scan();
    }

    public void onHitWall(HitWallEvent e) {
        if(direction == 1) {
            turnLeft(30);
            back(100);
        }
        if(direction == 0) {
            turnRight(30);
            ahead(100);
        }
    }

    public void onHitRobot(HitRobotEvent e) {
        turnRight(e.getBearing());
        fire(2);
    }

    public void onWin(WinEvent e) {
        turnRight(360000);
    }
}