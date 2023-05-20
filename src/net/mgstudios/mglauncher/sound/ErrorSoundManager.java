package net.mgstudios.mglauncher.sound;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
public class ErrorSoundManager {
    Clip clip;
    public ErrorSoundManager() {
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getClassLoader().getResourceAsStream("assets/mglauncher/sound/error.wav")));
            this.clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void Exec(){
        this.clip.start();
    }
}