package net.mgstudios.mglauncher.sound;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
public class JumpScare {
    Clip clip;
    public JumpScare() {
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getClassLoader().getResourceAsStream("assets/mglauncher/sound/jumpscare.wav")));
            this.clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.addLineListener(evt -> {
                if (evt.getType() == LineEvent.Type.STOP) {
                    System.exit(0);
                }
            });
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void Exec(){
        this.clip.start();
    }
}