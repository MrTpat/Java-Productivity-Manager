package nongui;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Goal_List implements Serializable {

	
	private ArrayList<Goal> goalList = new ArrayList<Goal>();

	public Goal_List() throws Exception {
		get();
	}

	public ArrayList<Goal> getList() {
		return goalList;
	}

	public void save() throws Exception {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.ser"));
			out.writeObject(goalList);
			out.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	public void get() throws Exception {
		try {
			FileInputStream inputStream = new FileInputStream("DATA.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			goalList = (ArrayList<Goal>) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}

	public void clear() throws Exception {
		goalList.clear();
		save();
	}

	public Goal get(int i) {
            try {
                get();
            } catch (Exception ex) {
                Logger.getLogger(Goal_List.class.getName()).log(Level.SEVERE, null, ex);
            }
		return goalList.get(i);
	}
}
