package net.mgstudios.mglauncher.gui;

import net.mgstudios.mglauncher.Main;
import net.mgstudios.mglauncher.cfg.ConfigManager;
import net.mgstudios.mglauncher.gui.components.LiteInfo;
import net.mgstudios.mglauncher.gui.components.LiteLabel;
import net.mgstudios.mglauncher.gui.menus.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
public class InfoMenu extends Dialog{

    final Toolkit toolkit = Toolkit.getDefaultToolkit();
    final Image image = toolkit.getImage(getClass().getClassLoader().getResource("assets/mglauncher/cursor.png"));
    final Image LOGO = toolkit.getImage(getClass().getClassLoader().getResource("assets/mglauncher/icon.png"));
    final Properties properties = System.getProperties();
    final LiteLabel TITLE = new LiteLabel(properties.getProperty("gui.info.text_title"));
    final JLabel GAME_INFO = new JLabel(properties.getProperty("gui.info.text"));
    final LiteLabel CREDITS = new LiteLabel(properties.getProperty("gui.info.credits"));
    final LiteInfo PROGRAMMER = new LiteInfo(properties.getProperty("gui.info.programmer")+"@MateusMG2010");
    final LiteInfo DESIGNER = new LiteInfo(properties.getProperty("gui.info.designer")+"@MateusMG2010");
    final LiteInfo VERSION_LABEL = new LiteInfo(properties.getProperty("gui.info.version")+Main.APPLICATION_VERSION);
    final JCheckBox MUSIC = new JCheckBox();
    final LiteLabel MUSIC_LABEL = new LiteLabel(properties.getProperty("gui.info.music"));
    final ImageIcon CHECK_ICON = new ImageIcon(getClass().getClassLoader().getResource("assets/mglauncher/check.png"));
    final ImageIcon UNCHECK_ICON = new ImageIcon(getClass().getClassLoader().getResource("assets/mglauncher/uncheck.png"));
    public InfoMenu(){
        super(Frame.frame);
        InfoMenu menu = this;
        this.setSize(350,495);
        this.setTitle(properties.getProperty("gui.info.title"));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(GAME_INFO);
        this.add(MUSIC);
        this.setResizable(false);

        MUSIC.setSelected(ConfigManager.Verification());

        TITLE.setBounds(20,40,350,40);
        TITLE.setFont(new Font(Font.SERIF,Font.BOLD,35));

        GAME_INFO.setForeground(Color.RED);
        GAME_INFO.setBounds(20,90,320,35);
        GAME_INFO.setFont(new Font(Font.SERIF,Font.PLAIN,16));

        CREDITS.setBounds(20,140,320,35);
        CREDITS.setFont(new Font(Font.SERIF,Font.BOLD,35));

        //Development Info
        PROGRAMMER.setBounds(20,190,320,35);
        DESIGNER.setBounds(20,220,320,35);
        VERSION_LABEL.setBounds(20,250,320,35);
        //

        MUSIC.setBounds(15,340,90,96);
        MUSIC.setForeground(Color.WHITE);
        MUSIC.setBackground(Color.BLACK);
        MUSIC.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        MUSIC.setFocusable(false);
        MUSIC.setIcon(UNCHECK_ICON);
        MUSIC.setSelectedIcon(CHECK_ICON);
        MUSIC.addChangeListener(e -> {
            if(MUSIC.isSelected()){
                ConfigManager.Write(true);
                Main.MUSIC_MANAGER.ExecMusic();
            }
            else {
                ConfigManager.Write(false);
                Main.MUSIC_MANAGER.StopMusic();
            }
        });

        MUSIC_LABEL.setBounds(20,305,125,35);
        MUSIC_LABEL.setFont(new Font(Font.SERIF, Font.PLAIN, 20));

        Cursor cursor = toolkit.createCustomCursor(image, new Point(0,0), "custom_cursor");
        this.setIconImage(LOGO);
        this.setCursor(cursor);
        this.add(TITLE);
        this.add(PROGRAMMER);
        this.add(DESIGNER);
        this.add(MUSIC_LABEL);
        this.add(CREDITS);
        this.add(VERSION_LABEL);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                menu.dispose();
                MainPanel.info.setEnabled(true);
            }
        });
    }
}