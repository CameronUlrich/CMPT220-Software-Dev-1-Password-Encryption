package jdialogdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Music {
	 public static void music() 
     {       
         AudioPlayer MGP = AudioPlayer.player;
         AudioStream BGM;
         AudioData MD;

         ContinuousAudioDataStream loop = null;

         try
         {
             InputStream test = new FileInputStream("C:\\Users\\ckulr\\workspace\\CMPT220\\src\\Happy Background Music #1 NO COPYRIGHT.mp3");
             BGM = new AudioStream(test);
             AudioPlayer.player.start(BGM);
             //MD = BGM.getData();
             //loop = new ContinuousAudioDataStream(MD);

         }
         catch(FileNotFoundException e){
             System.out.print(e.toString());
         }
         catch(IOException error)
         {
             System.out.print(error.toString());
         }
         MGP.start(loop);
     }
	 

}
