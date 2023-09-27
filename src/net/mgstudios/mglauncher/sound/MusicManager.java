package net.mgstudios.mglauncher.sound;

import net.mgstudios.mglauncher.extra.Resource;
import net.mgstudios.mglauncher.gui.Frame;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.IOException;

public class MusicManager {
    Clip clip;
    public MusicManager(){
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(Resource.getResource("assets/mglauncher/sound/music.wav")));
            this.clip = AudioSystem.getClip();
            this.clip.open(audioInputStream);
        }
        catch (IOException | UnsupportedAudioFileException | LineUnavailableException | NullPointerException e){
            JOptionPane.showMessageDialog(Frame.frame, "Music System Crash!", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    public void ExecMusic() {
        this.clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void StopMusic() {
        this.clip.stop();
    }
}
