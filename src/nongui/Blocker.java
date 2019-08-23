package nongui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;


public class Blocker {
    ArrayList<String> sites;
	public static void main(String[] args) throws Exception{
		
	}
        public Blocker(){
            sites = new ArrayList<String>();
        try {
            get();
        } catch (Exception ex) {
            Logger.getLogger(Blocker.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        public ArrayList<String> getSites(){
            return sites;
        }
        public void save() throws Exception {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("blockList.ser"));
			out.writeObject(sites);
			out.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
                get();
	}

	public void get() throws Exception {
		try {
			FileInputStream inputStream = new FileInputStream("blockList.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			sites = (ArrayList<String>) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}
	public void write() throws Exception{
		String x = "WebsitesToBlock = Array(\"";
		if(sites.size()==0){
			x="WebsitesToBlock = Array(\"\")";
		}
		else{
		FileUtils.copyFile(new File("copyText.txt"),new File("y8y89huhuui8uosfdu0sduf90s8df09sdfjsd0f09s8dfsdf.vbs"));



		 x = "WebsitesToBlock = Array(\"";
		for(int i =0;i<sites.size()-1;i++){
			x+=sites.get(i)+"\", \"";
		}
		x+=sites.get(sites.size()-1)+"\")";
		}
		RandomAccessFile file = new RandomAccessFile("y8y89huhuui8uosfdu0sduf90s8df09sdfjsd0f09s8dfsdf.vbs", "rws");
	    byte[] text = new byte[(int) file.length()];
	    file.readFully(text);
	    file.seek(0);
	    file.writeBytes(x);
	    file.write(text);
	    file.close();
	}
        
}
