package gr.aueb.dmst.nereids.sound;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[30];
	InputStream[] url = new InputStream[30];
	InputStream is;

	public Sound() {
		
		
		try {
			is = new FileInputStream("sound_of_game/CHIPTUNE_Minstrel_Dance.wav");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		soundURL[0] = getClass().getResource("sound_of_game/CHIPTUNE_Minstrel_Dance.wav");
		soundURL[1] = getClass().getResource("sound_of_game/angry-mob-loop-6847 (1).wav");
		soundURL[2] = getClass().getResource("sound_of_game/big_lightning_with_dc_spike_reverse-6157.wav");
		soundURL[3] = getClass().getResource("sound_of_game/bubbling-6184.wav");
		soundURL[4] = getClass().getResource("sound_of_game/jurassic-creatures-animal-nature-sounds-9682 (1).wav");
		soundURL[5] = getClass().getResource("sound_of_game/Komiku_-_04_-_Shopping_List.wav");
		soundURL[6] = getClass().getResource("sound_of_game/oh-no-oh-crap-7164.wav");
		soundURL[7] = getClass().getResource("sound_of_game/rope-under-tension-7144.wav");
		soundURL[8] = getClass().getResource("sound_of_game/sea.wav");
		soundURL[9] = getClass().getResource("sound_of_game/stones-falling-6375.wav");
		soundURL[10] = getClass().getResource("sound_of_game/success-1-6297.wav");
		soundURL[11] = getClass().getResource("sound_of_game/talking-people-2-6400.wav");
		soundURL[12] = getClass().getResource("sound_of_game/winfantasia-6912.wav");
		soundURL[13] = getClass().getResource("sound_of_game/negative_beeps-6008.wav");
	}

	public void setFile(int i) {
		try {
			/* AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			*/
			
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(is);
			//clip = AudioSystem.getClip();
			//clip.open(inputStream);

		} catch (Exception e) {
			System.out.println("exception");
		}

	}

	public void play() {
		clip.start();
	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
		clip.stop();
	}

}