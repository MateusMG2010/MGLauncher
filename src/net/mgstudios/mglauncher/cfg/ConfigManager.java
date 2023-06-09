package net.mgstudios.mglauncher.cfg;

import net.mgstudios.mglauncher.Main;
import net.mgstudios.mglauncher.gui.Frame;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    static final File FILE = new File(".\\Launcher\\config.properties");
    static final Properties properties = System.getProperties();
    public static boolean Verification() {
        if (FILE.exists()) {
            try (FileReader reader = new FileReader(FILE)) {
                Properties FILE_PROPERTIES = new Properties();
                FILE_PROPERTIES.load(reader);
                try {
                    if(!FILE_PROPERTIES.getProperty("im_beautiful").equals("true")){
                        JOptionPane.showMessageDialog(Frame.frame, properties.getProperty("gui.other.ugly"), "INFO", JOptionPane.WARNING_MESSAGE);
                    }
                    return Boolean.parseBoolean(FILE_PROPERTIES.getProperty("music"));
                } catch (Exception e) {
                    System.out.println("===ERROR===");
                    System.out.println("ConfigManager.CheckFileExists (Error On Read Config File)");
                    System.out.println("Java Error:");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("===ERROR===");
                System.out.println("ConfigManager.CheckFileExists (Error On Read Config File)");
                System.out.println("Java Error:");
                e.printStackTrace();
            }
        } else {
            Write(true);
        }
        return true;
    }
    public static void Write(boolean MUSIC){
        try (FileWriter writer = new FileWriter(FILE)){
            writer.write("#This File Was Generated By MGLauncher "+ Main.APPLICATION_VERSION+"\n");
            writer.write("music="+MUSIC+"\n");
            writer.write("im_beautiful=true");
        }
        catch (IOException e){
            System.out.println("===ERROR===");
            System.out.println("ConfigManager.Write (Error On Write Config File)");
            System.out.println("Java Error:");
            e.printStackTrace();
        }
    }
}