package net.mgstudios.mglauncher.sound;

import net.mgstudios.mglauncher.extra.Resource;
import net.mgstudios.mglauncher.gui.Frame;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.IOException;
public class ErrorSound {
    Clip clip;
    public ErrorSound() {
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(Resource.getResource("assets/mglauncher/sound/error.wav")));
            this.clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | NullPointerException e) {
            JOptionPane.showMessageDialog(Frame.frame, "Sound System Crash!", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    public void Exec(){
        this.clip.start();
    }
}