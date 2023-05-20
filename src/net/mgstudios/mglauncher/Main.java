package net.mgstudios.mglauncher;

import net.mgstudios.mglauncher.cfg.ConfigManager;
import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.lang.LanguageManager;
import net.mgstudios.mglauncher.msg.MessageManager;
import net.mgstudios.mglauncher.sound.MusicManager;

import java.util.Properties;

public class Main {
    public static final String APPLICATION_VERSION = "1.3";
    public static final String MESSAGE = new MessageManager().getMessage();
    public static final MusicManager MUSIC_MANAGER = new MusicManager();

    //======================================================//
    //This Launcher Is Open-Source, But Do Not Take Credits!//
    //======================================================//

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        new LanguageManager().Init();
        new Frame();
        System.out.printf("%s \n", properties.getProperty("init.message.start"));
        System.out.printf("%s %s \n", properties.getProperty("init.message.version"), APPLICATION_VERSION);
        System.out.printf("%s '%s'\n", properties.getProperty("init.message.newMessage"), MESSAGE);
        System.out.printf("Locale: '%s' \n", System.getProperty("user.language"));
        if (ConfigManager.Verification()) {
            MUSIC_MANAGER.ExecMusic();
        }
    }
}