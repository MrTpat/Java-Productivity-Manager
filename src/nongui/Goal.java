package nongui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tilak
 */
public class Goal implements Serializable {
	private String name;
	private double hC;
	private double hN;

	public Goal(String name, double hoursComplete, double hoursNeeded) {
		this.name = name;
		hC = hoursComplete;
		hN = hoursNeeded;
	}

	public Goal() {
		this.name = "";
		hC = 0;
		hN = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double gethC() {
		return hC;
	}

	public void sethC(double hC) {
		this.hC = hC;
	}

	public double gethN() {
		return hN;
	}

	public void sethN(double hN) {
		this.hN = hN;
	}
        public void addTime(double hours){
            hC+=hours;
        }

	public void notification() {
		// Obtain only one instance of the SystemTray object
		SystemTray tray = SystemTray.getSystemTray();
		// If the icon is a file
		Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		// Alternative (if the icon is on the classpath):
		// Image image =
		// Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));
		TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
		// Let the system resizes the image if needed
		trayIcon.setImageAutoSize(true);
		// Set tooltip text for the tray icon
		trayIcon.setToolTip("System tray icon demo");
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trayIcon.displayMessage(name + " Completed!", name + " was automatically deleted", MessageType.INFO);
	}
        
        
}
