package net.mgstudios.mglauncher.gui;

import net.mgstudios.mglauncher.gui.error.Error;
import net.mgstudios.mglauncher.gui.menus.*;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class Frame extends JFrame {
    final Properties properties = System.getProperties();
    final Toolkit toolkit = Toolkit.getDefaultToolkit();
    final Image CURSOR_IMAGE = toolkit.getImage(getClass().getClassLoader().getResource("assets/mglauncher/cursor.png"));
    final Image LOGO = toolkit.getImage(getClass().getClassLoader().getResource("assets/mglauncher/icon.png"));
    static final MainPanel mainPanel = new MainPanel();
    static final FNAF_1 fnaf_1 = new FNAF_1();
    static final MULTIPLAYER_SELECT multiplayer_select = new MULTIPLAYER_SELECT();
    static final JOIN join = new JOIN();
    static final HOST host = new HOST();
    final Cursor CURSOR = toolkit.createCustomCursor(CURSOR_IMAGE, new Point(0,0), "custom_cursor");

    public static JFrame frame;

    public Frame(){
        frame = this;
        this.setTitle(properties.getProperty("gui.title"));
        this.setSize(750,800);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(fnaf_1);
        this.add(multiplayer_select);
        this.add(host);
        this.setIconImage(LOGO);
        this.setCursor(CURSOR);
    }
    public static void LOAD(Menus Menu){
        switch (Menu) {
            case MAIN_PANEL -> {
                fnaf_1.setVisible(false);
                mainPanel.setVisible(true);
                frame.setContentPane(mainPanel);
            }
            case FNAF_1 -> {
                fnaf_1.setVisible(true);
                mainPanel.setVisible(false);
                multiplayer_select.setVisible(false);
                frame.setContentPane(fnaf_1);
            }
            case MULTIPLAYER_SELECT -> {
                multiplayer_select.setVisible(true);
                fnaf_1.setVisible(false);
                host.setVisible(false);
                join.setVisible(false);
                frame.setContentPane(multiplayer_select);
            }
            case HOST -> {
                host.setVisible(true);
                multiplayer_select.setVisible(false);
                frame.setContentPane(host);
            }
            case JOIN -> {
                join.setVisible(true);
                multiplayer_select.setVisible(false);
                frame.setContentPane(join);
            }
            default -> {
                new Error().PanelError();
                System.exit(0);
            }
        }
    }
}