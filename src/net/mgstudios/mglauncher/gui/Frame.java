package net.mgstudios.mglauncher.gui;

import net.mgstudios.mglauncher.Main;
import net.mgstudios.mglauncher.cfg.ConfigManager;
import net.mgstudios.mglauncher.extra.Resource;
import net.mgstudios.mglauncher.gui.menus.List;
import net.mgstudios.mglauncher.gui.menus.basic.FNAF;
import net.mgstudios.mglauncher.gui.menus.basic.MainMenu;
import net.mgstudios.mglauncher.gui.menus.multiplayer.Host;
import net.mgstudios.mglauncher.gui.menus.multiplayer.Join;
import net.mgstudios.mglauncher.gui.menus.multiplayer.ModeSelect;
import net.mgstudios.mglauncher.lang.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame extends JFrame {
    public static JFrame frame;
    static final MainMenu mainMenu = new MainMenu();
    static final FNAF fnaf = new FNAF();
    static final ModeSelect modeSelect = new ModeSelect();
    static final Host host = new Host();
    static final Join join = new Join();
    static final JLabel BACKGROUND = new JLabel();
    static boolean canShow = ConfigManager.getIntro();
    public Frame(){
        frame = this;
        BACKGROUND.setSize(750,800);
        BACKGROUND.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(ConfigManager.getMusic()){
                    Main.MusicExec();
                }
                Frame.LOAD(List.MainMenu);
                canShow = false;
            }
        });
        this.add(BACKGROUND);
        this.setSize(750,800);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(Resource.getURL("assets/mglauncher/icon.png")));
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(Resource.getURL("assets/mglauncher/cursor.png")), new Point(0,0), "cursor"));
        new Intro().start();
    }
    static class Intro extends Thread implements Runnable {
        @Override
        public void run(){
            System.out.printf("Can Show: %s\n",canShow);
                while (canShow){
                    try {
                        changeTitle("gui.titles.main");
                        setImage("assets/mglauncher/intro/INTRO_0.png");
                        sleep(250);
                        setImage("assets/mglauncher/intro/INTRO_1.png");
                        sleep(250);
                        setImage("assets/mglauncher/intro/INTRO_2.png");
                        sleep(250);
                        setImage("assets/mglauncher/intro/INTRO_3.png");
                        sleep(250);
                        setImage("assets/mglauncher/intro/INTRO_4.png");
                        sleep(250);
                        setImage("assets/mglauncher/intro/INTRO_5.png");
                        sleep(250);
                        setImage("assets/mglauncher/intro/INTRO_6.png");
                        sleep(250);
                        setImage("assets/mglauncher/intro/INTRO_7.png");
                        sleep(250);
                        setImage("assets/mglauncher/intro/INTRO_8.png");
                        sleep(1750);
                        if(!canShow){
                            break;
                        }
                        Frame.LOAD(List.MainMenu);
                        if(ConfigManager.getMusic()){
                            Main.MusicExec();
                        }
                        canShow = false;
                    } catch (InterruptedException e) {
                        System.out.println("Ignored!");
                    }
                }
                Frame.LOAD(List.MainMenu);
        }
    }
    static void setImage(String URL){
        BACKGROUND.setIcon(new ImageIcon(Resource.getURL(URL)));
    }
    private static void changeTitle(String newTitle){
        Frame.frame.setTitle(Text.getText(newTitle));
    }
    private static void refresh(){
        SwingUtilities.updateComponentTreeUI(frame);
    }
    public static void LOAD(List Menu){
        switch (Menu) {
            case MainMenu -> {
                frame.setContentPane(mainMenu);
                changeTitle("gui.titles.main");
                refresh();
            }
            case FNAF -> {
                frame.setContentPane(fnaf);
                changeTitle("gui.titles.fnaf_1");
                refresh();
            }
            case ModeSelect -> {
                frame.setContentPane(modeSelect);
                changeTitle("gui.titles.mt_select");
                refresh();
            }
            case HOST -> {
                frame.setContentPane(host);
                changeTitle("gui.titles.host");
                refresh();
            }
            case JOIN -> {
                frame.setContentPane(join);
                changeTitle("gui.titles.join");
                refresh();
            }
            default -> {
                new Error().PanelError();
                System.exit(1);
            }
        }
    }
}