package net.mgstudios.mglauncher.game;

import net.mgstudios.mglauncher.Main;
import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.gui.Error;
import net.mgstudios.mglauncher.sound.JumpScare;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class GameRunner {
    static final String FD1_PATH = "Game\\WADs\\FD1";
    static final File FNAF_PK3 = new File("%s\\FNAF.PK3".formatted(FD1_PATH));
    static final File FNAF_WAD = new File("%s\\FiveNightsAtFreddys1REMAKE.wad".formatted(FD1_PATH));
    static final File FNAF_MATERIALS = new File("%s\\FNAF_Materials.pk3".formatted(FD1_PATH));
    static final File FNAF_LOW_POLY = new File("%s\\zFNAF_LowPoly.pk3".formatted(FD1_PATH));
    static final File FONT_SETTINGS = new File("Game\\Wads\\Font\\JF.pk3");
    static final File ENGINE = new File("Game\\gzdoom.exe");
    static final File GZDOOM_INI = new File("Game\\gzdoom.ini");
    private static boolean FindAll(){
        return FNAF_PK3.exists() && FNAF_WAD.exists() && FNAF_MATERIALS.exists() && FNAF_LOW_POLY.exists() && FONT_SETTINGS.exists() && GZDOOM_INI.exists();
    }
    private static boolean GameFolder(){
        return new File("Game").exists();
    }
    public static void SINGLEPLAYER() {
        if (GameFolder()) {
            if (ENGINE.exists()) {
                if (FindAll()) {
                    try {
                        Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "cd Game && start gzdoom.exe +map e1m1 +sv_cheats 1"});
                        System.exit(0);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(Frame.frame, "FATAL ERROR ON LAUNCH", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    new Error().GameFilesNotFound();
                }
            } else {
                new Error().EngineNotFound();
            }
        } else {
            new Error().GameFolderNotFound();
        }
    }
    public static void JOIN(String HOST_IP) {
        if (GameFolder()) {
            if (ENGINE.exists()) {
                if (FindAll()) {
                    try {
                        Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "cd Game && start gzdoom.exe -join %s -skill 4".formatted(HOST_IP)});
                        System.out.println("Join Info:");
                        System.out.printf("Host Ip: %s", HOST_IP);
                        System.exit(0);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(Frame.frame, "FATAL ERROR ON LAUNCH", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    new Error().GameFilesNotFound();
                }
            } else {
                new Error().EngineNotFound();
            }
        } else {
            new Error().GameFolderNotFound();
        }
    }
    public static void HOST(String PLAYER_NUMBER, String MAP_CODE) {
        if (GameFolder()) {
            if (ENGINE.exists()) {
                if (FindAll()) {
                    try {
                        Main.MusicStop();
                        Frame.frame.setVisible(false);
                        new JumpScare().Exec();
                        Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "cd Game && start gzdoom.exe -host %s +map %s -netmode 0".formatted(PLAYER_NUMBER, MAP_CODE)});
                        System.out.println("Host Info:");
                        System.out.printf("Number Of Players: %s\n", PLAYER_NUMBER);
                        System.out.println("Port: 5029");
                        System.out.printf("Night: %s\n", MAP_CODE);
                        System.out.println("Cheats: TRUE\n");
                        System.out.println("NetMode: PEER-TO-PEER");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(Frame.frame, "FATAL ERROR ON LAUNCH", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    new Error().GameFilesNotFound();
                }
            } else {
                new Error().EngineNotFound();
            }
        } else {
            new Error().GameFolderNotFound();
        }
    }
}