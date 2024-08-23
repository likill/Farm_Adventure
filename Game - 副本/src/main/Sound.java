package main;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound(){
        soundURL[0] = getClass().getResource("/sound/game_music.wav");
        soundURL[1] = getClass().getResource("/sound/game_over.wav");
        soundURL[2] = getClass().getResource("/sound/game_win.wav");
        soundURL[3] = getClass().getResource("/sound/pickup.wav");
        soundURL[4] = getClass().getResource("/sound/pickup_key.wav");
        soundURL[5] = getClass().getResource("/sound/pickup_potato.wav");
        soundURL[6] = getClass().getResource("/sound/pickup_seed.wav");

    }
    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e){

        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
