
package jdialogdemo;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JTextField;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Project_Two {
	
    public static boolean authenticate(String username, String password) throws Exception {
    	
  	  	List lines =  (List) Files.readAllLines(Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt"), StandardCharsets.UTF_8);
  	  	
  	 
  	  	
        if (lines.contains(username) && lines.contains(password)) {
            return true;
        }
        return false;
    }
    public static boolean create(String username, String password, String email) throws Exception {
    	
  	  	List lines =  (List) Files.readAllLines(Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt"), StandardCharsets.UTF_8);
  	  	
        if (lines.contains(username)) {
            return false;
        }
        return true;
    }
    public static boolean userConf(String username, String password) throws Exception
    {
    	
    	List lines =  (List) Files.readAllLines(Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt"), StandardCharsets.UTF_8);
  	  	
        if (lines.contains("U: " + username) && lines.contains("P: " + password)) {
            return true;
        }
        return false;
    	
    }
    public static boolean emailConf(String email) throws Exception
    {
    	List lines =  (List) Files.readAllLines(Paths.get("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\ProjectTwo.txt"), StandardCharsets.UTF_8);
    	if (lines.contains(email)) {
            return false;
    	}
		return true;
    	
    }
    public static void playMusic()
    {
    	
    }
    
    
    public static void quitProgram()
    {
    	
    	System.exit(0);
    	
    }
    
    
    public static void writeToFile(String username, String password) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("ProjectTwo.txt"));
        out.write(username + "#" + password);
        out.newLine();
        out.close();
    }
}