package gr.aueb.dmst.nereids2;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Contains all the game music
 * Initializes the .wav files that are found on the res/sounds package and also
 * has certain methods to control them throughout the game.
 */

public class Sound {
  static int i = 0;
  static Clip clip;
  static Clip[] clips = new Clip[13];
  URL[] soundUrl = new URL[12];
  
  /**Constructor.*/
  public Sound() {
    soundUrl[0] = getClass().getResource("/sounds/gameplay.wav");
    soundUrl[1] = getClass().getResource("/sounds/conflict.wav");
    soundUrl[2] = getClass().getResource("/sounds/rocks.wav");
    soundUrl[3] = getClass().getResource("/sounds/seaanimals.wav");
    soundUrl[4] = getClass().getResource("/sounds/storm.wav");
    soundUrl[5] = getClass().getResource("/sounds/swell.wav");
    soundUrl[6] = getClass().getResource("/sounds/wind.wav");
    soundUrl[7] = getClass().getResource("/sounds/ohno.wav");
    soundUrl[8] = getClass().getResource("/sounds/wingame.wav");
    soundUrl[9] = getClass().getResource("/sounds/main1.wav");
    soundUrl[10] = getClass().getResource("/sounds/pirate.wav");
    soundUrl[11] = getClass().getResource("/sounds/losegame.wav");
  }
  
  /**sets audio file.*/
  public void setFile(int i) {
    try {
      AudioInputStream ais = AudioSystem.getAudioInputStream(soundUrl[i]);
      clip = AudioSystem.getClip();
      clip.open(ais);
      clips[i] = clip;
      // store Clip object in table clips[]
      i++;
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
   
  public void play() {
    clip.start();
  }

  public void loop() {
    clip.loop(Clip.LOOP_CONTINUOUSLY);
  }
  
  /**stops sound.*/
  public void stop() {
    clip.stop();
    // stop every clip made by stopping every Clip item in the table clips
    // and then print table clips
    for (int j = 0; j < clips.length; j++) {
      if (clips[j] != null) {
        clips[j].stop();
        System.out.println("-----" + j);
        System.out.println(clips[j].toString()); // prints file name
      } else {
        System.out.println("-----" + j);
        System.out.println("null"); // prints null since it doesn't exist
      }
    }
  }
}
