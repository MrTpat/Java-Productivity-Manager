package nongui;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Alarm {
	public Alarm(String mp3){
		new javafx.embed.swing.JFXPanel();
		String urlString = new File(mp3).toURI().toString();
		new MediaPlayer(new Media(urlString)).play();
	}
}
