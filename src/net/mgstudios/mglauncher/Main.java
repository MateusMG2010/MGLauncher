package net.mgstudios.mglauncher;

import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.lang.LanguageManager;
import net.mgstudios.mglauncher.lang.Text;
import net.mgstudios.mglauncher.msg.MessageManager;
import net.mgstudios.mglauncher.sound.MusicManager;

public class Main {
    private static final String Message = new MessageManager().getMessage();
    public static final String APPLICATION_VERSION = "1.5.1";
    private static final MusicManager MUSIC_MANAGER = new MusicManager();

    public static void main(String[] args) {
        new LanguageManager().Init();
        System.out.printf("%s\n", Text.getText("init.message.start"));
        System.out.printf("%s %s\n", Text.getText("init.message.version"), APPLICATION_VERSION);
        System.out.printf("%s '%s'\n", Text.getText("init.message.newMessage"), getMessage());
        System.out.printf("Locale: '%s'\n", Text.getText("user.language"));
        new Frame();
    }
    public static String getMessage(){return Message;}
    public static void MusicExec(){
        MUSIC_MANAGER.ExecMusic();
    }
    public static void MusicStop(){
        MUSIC_MANAGER.StopMusic();
    }
}
