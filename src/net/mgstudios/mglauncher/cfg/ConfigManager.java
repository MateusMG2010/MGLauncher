package net.mgstudios.mglauncher.cfg;

import net.mgstudios.mglauncher.Main;

import java.io.*;
import java.util.Objects;
import java.util.Properties;
public class ConfigManager {
    private static final File CFG_FILE = new File(".\\Launcher\\config.properties");
    public static boolean Check() {
        return CFG_FILE.exists();
    }
    public static boolean getMusic(){
        if (Check()) {
            try (FileReader reader = new FileReader(CFG_FILE)) {
                Properties FILE_PROPERTIES = new Properties();
                FILE_PROPERTIES.load(reader);
                if(!Objects.equals(FILE_PROPERTIES.getProperty("music"), "false") && !Objects.equals(FILE_PROPERTIES.getProperty("music"), "true")){
                    System.out.println("===ERROR===");
                    System.out.println("ConfigManager.getMusic(), Boolean Format Error");
                    Write(true, ConfigManager.getIntro());
                }
                try {
                    return Boolean.parseBoolean(FILE_PROPERTIES.getProperty("music"));
                } catch (NullPointerException e) {
                    System.out.println("===ERROR===");
                    System.out.println("ConfigManager.getMusic(), Error On Parse Config File");
                }
            } catch (IOException e) {
                System.out.println("===ERROR===");
                System.out.println("ConfigManager.getMusic(), Error On Read Config File");
            }
        } else {
            Write(true, true);
        }
        return true;
    }
    public static boolean getIntro(){
        if (Check()) {
            try (FileReader reader = new FileReader(CFG_FILE)) {
                Properties FILE_PROPERTIES = new Properties();
                FILE_PROPERTIES.load(reader);
                if(!Objects.equals(FILE_PROPERTIES.getProperty("intro"), "false") && !Objects.equals(FILE_PROPERTIES.getProperty("intro"), "true")){
                    System.out.println("===ERROR===");
                    System.out.println("ConfigManager.getIntro(), Boolean Format Error");
                    Write(ConfigManager.getMusic(), true);
                }
                try {
                    return Boolean.parseBoolean(FILE_PROPERTIES.getProperty("intro"));
                } catch (NullPointerException e) {
                    System.out.println("===ERROR===");
                    System.out.println("ConfigManager.getIntro(), Error On Parse Config File");
                }
            } catch (IOException e) {
                System.out.println("===ERROR===");
                System.out.println("ConfigManager.getIntro(), Error On Read Config File");
            }
        } else {
            Write(true, true);
        }
        return true;
    }

    public static void Write(boolean MUSIC, boolean INTRO){
        String type;
        if(Check()){
            type = "Modified";
        }
        else {
            type = "Generated";
        }
        try (FileWriter writer = new FileWriter(CFG_FILE)){
            writer.write("#This File Was %s By MGLauncher %s\n".formatted(type, Main.APPLICATION_VERSION));
            writer.write("music=%s\nintro=%s\n".formatted(MUSIC, INTRO));
        }
        catch (IOException e){
            System.out.println("===ERROR===");
            System.out.println("ConfigManager.Write(), Error On Write Config File");
        }
    }
}