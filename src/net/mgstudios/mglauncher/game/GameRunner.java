package net.mgstudios.mglauncher.game;

import net.mgstudios.mglauncher.Main;
import net.mgstudios.mglauncher.gui.error.Error;
import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.sound.JumpScare;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
public class GameRunner {
    static final String WADS_PATH = "Game\\WADs\\FD1";
    static final File GAME_FOLDER = new File("Game");
    static final File FNAF_PK3 = new File("%s\\FNAF.PK3".formatted(WADS_PATH));
    static final File FNAF_WAD = new File("%s\\FiveNightsAtFreddys1REMAKE.wad".formatted(WADS_PATH));
    static final File FNAF_MATERIALS = new File("%s\\FNAF_Materials.pk3".formatted(WADS_PATH));
    static final File FNAF_LOW_POLY = new File("%s\\zFNAF_LowPoly.pk3".formatted(WADS_PATH));
    static final File FONT_SETTINGS = new File("Game\\Wads\\Global\\JF.pk3");
    static final File GZDOOM = new File(".\\Game\\gzdoom.exe");
    public static void SINGLEPLAYER() {
        if (GAME_FOLDER.exists()) {
            if (FNAF_PK3.exists() && FNAF_WAD.exists() && FNAF_MATERIALS.exists() && FNAF_LOW_POLY.exists() && FONT_SETTINGS.exists()) {
                if (GZDOOM.exists()) {
                    Runtime rt = Runtime.getRuntime();
                    try {
                        rt.exec(new String[]{"cmd.exe", "/c", "cd .\\Game && start gzdoom.exe -file .\\Wads\\FD1\\* -map e1m1 -skill 4"});
                        System.exit(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    new Error().GZDoomNotFound();
                }
            } else {
                new Error().GameFilesNotFound();
            }
        } else {
            new Error().GameFolderNotFound();
        }
    }
    public static void JOIN(String HOST_IP) {
        if (GAME_FOLDER.exists()) {
            if (FNAF_PK3.exists() && FNAF_WAD.exists() && FNAF_MATERIALS.exists() && FNAF_LOW_POLY.exists() && FONT_SETTINGS.exists()) {
                if (GZDOOM.exists()) {
                    Runtime rt = Runtime.getRuntime();
                    try {
                        rt.exec(new String[]{"cmd.exe", "/c", "cd .\\Game && start gzdoom.exe -file .\\Wads\\FD1\\* -join " + HOST_IP});
                        System.out.printf("Host Ip: %s", HOST_IP);
                        System.exit(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    new Error().GZDoomNotFound();
                }
            } else {
                new Error().GameFilesNotFound();
            }
        } else {
            new Error().GameFolderNotFound();
        }
    }
    public static void HOST() {
        JumpScare jumpScare = new JumpScare();
        if (GAME_FOLDER.exists()) {
            if (GZDOOM.exists()) {
                Properties properties = System.getProperties();
                if (FNAF_PK3.exists() && FNAF_WAD.exists() && FNAF_MATERIALS.exists() && FNAF_LOW_POLY.exists() && FONT_SETTINGS.exists()) {
                    try {
                        Main.MUSIC_MANAGER.StopMusic();
                        Runtime rt = Runtime.getRuntime();
                        Frame.frame.setVisible(false);
                        jumpScare.Exec();
                        rt.exec(new String[]{"cmd.exe", "/c", "cd .\\Game && start gzdoom.exe -file .\\Wads\\FD1\\* -host " + properties.getProperty("pNumber") + " +map " + properties.getProperty("map") + " +sv_cheats " + properties.getProperty("cheats") + "-netmode 0 -port "+properties.getProperty("port")});
                        System.out.println("Launching Game!");
                        System.out.println("Have Fun!");
                        System.out.printf("Number Of Players: %s\n", properties.getProperty("pNumber"));
                        System.out.printf("Port: %s\n", properties.getProperty("port"));
                        System.out.printf("Night: %s\n", properties.getProperty("map"));
                        System.out.printf("Cheats: %s\n", properties.getProperty("cheats"));
                        System.out.println("NetMode: 0");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    new Error().GameFilesNotFound();
                }
            } else {
                new Error().GZDoomNotFound();
            }
        } else {
            new Error().GameFolderNotFound();
        }
    }
}