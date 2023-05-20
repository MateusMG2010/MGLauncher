package net.mgstudios.mglauncher.sound;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;

public class MusicManager {
    Clip clip;
    public MusicManager(){
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getClassLoader().getResourceAsStream("assets/mglauncher/sound/music.wav")));
            this.clip = AudioSystem.getClip();
            this.clip.open(audioInputStream);
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException | NullPointerException e){
            e.printStackTrace();
        }
    }
    public void ExecMusic() {
        this.clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void StopMusic() {
        this.clip.stop();
    }
}
