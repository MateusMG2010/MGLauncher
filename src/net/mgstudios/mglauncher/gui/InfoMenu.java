package net.mgstudios.mglauncher.gui;

import net.mgstudios.mglauncher.Main;
import net.mgstudios.mglauncher.cfg.ConfigManager;
import net.mgstudios.mglauncher.extra.Resource;
import net.mgstudios.mglauncher.gui.component.LiteInfo;
import net.mgstudios.mglauncher.gui.component.LiteLabel;
import net.mgstudios.mglauncher.lang.Text;

import javax.swing.*;
import java.awt.*;

public class InfoMenu extends JDialog {
    final Toolkit toolkit = Toolkit.getDefaultToolkit();
    final Image image = toolkit.getImage(Resource.getURL("assets/mglauncher/cursor.png"));
    final Image LOGO = toolkit.getImage(Resource.getURL("assets/mglauncher/icon.png"));

    final LiteLabel TITLE = new LiteLabel(Text.getText("gui.info.text_title"));
    final JLabel GAME_INFO = new JLabel(Text.getText("gui.info.text"));
    final LiteLabel CREDITS = new LiteLabel(Text.getText("gui.info.credits"));
    final LiteInfo PROGRAMMER = new LiteInfo(Text.getText("gui.info.programmer"));
    final LiteInfo DESIGNER = new LiteInfo(Text.getText("gui.info.designer"));
    final LiteInfo VERSION_LABEL = new LiteInfo(Text.getText("gui.info.version")+ Main.APPLICATION_VERSION);
    final JCheckBox MUSIC = new JCheckBox();
    final LiteLabel MUSIC_LABEL = new LiteLabel(Text.getText("gui.info.music"));
    final ImageIcon CHECK_ICON = new ImageIcon(Resource.getURL("assets/mglauncher/check.png"));
    final ImageIcon UNCHECK_ICON = new ImageIcon(Resource.getURL("assets/mglauncher/uncheck.png"));
    final LiteLabel INTRO_LABEL = new LiteLabel("Intro:");
    final JCheckBox INTRO = new JCheckBox();
    final Cursor cursor = toolkit.createCustomCursor(image, new Point(0, 0), "custom_cursor");
    public static JDialog dialog;
    public InfoMenu() {
        super(Frame.frame);
        dialog = this;
        this.setSize(375, 500);
        this.setTitle(Text.getText("gui.titles.info"));
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
        this.setModalityType(ModalityType.APPLICATION_MODAL);

        this.setIconImage(LOGO);
        this.setCursor(cursor);
        this.add(TITLE);
        this.add(GAME_INFO);
        this.add(PROGRAMMER);
        this.add(DESIGNER);
        this.add(CREDITS);
        this.add(VERSION_LABEL);
        this.add(MUSIC_LABEL);
        this.add(MUSIC);
        this.add(INTRO_LABEL);
        this.add(INTRO);

        MUSIC.setSelected(ConfigManager.getMusic());

        TITLE.setBounds(10, 20, 350, 40);
        TITLE.setFont(new Font(Font.SERIF, Font.BOLD, 35));

        GAME_INFO.setForeground(Color.RED);
        GAME_INFO.setBounds(11, 65, 350, 35);
        GAME_INFO.setFont(new Font(Font.SERIF, Font.PLAIN, 17));

        CREDITS.setBounds(10, 110, 320, 35);
        CREDITS.setFont(new Font(Font.SERIF, Font.BOLD, 35));

        //Development Info
        PROGRAMMER.setBounds(11, 160, 320, 35);
        DESIGNER.setBounds(11, 200, 320, 35);
        VERSION_LABEL.setBounds(11, 240, 320, 35);
        //

        //Music
        MUSIC_LABEL.setBounds(11, 295, 250, 35);
        MUSIC_LABEL.setFont(new Font(Font.SERIF, Font.PLAIN, 25));

        MUSIC.setBounds(11, 325, 90, 96);
        MUSIC.setBackground(Color.BLACK);
        MUSIC.setRolloverEnabled(false);
        MUSIC.setIcon(UNCHECK_ICON);
        MUSIC.setSelectedIcon(CHECK_ICON);
        MUSIC.addChangeListener(e -> {
            if (MUSIC.isSelected()) {
                ConfigManager.Write(true, ConfigManager.getIntro());
                Main.MusicExec();
            } else {
                ConfigManager.Write(false, ConfigManager.getIntro());
                Main.MusicStop();
            }
        });
        //
        //Intro
        INTRO_LABEL.setBounds(133, 295, 250, 35);
        INTRO_LABEL.setFont(new Font(Font.SERIF, Font.PLAIN, 27));

        INTRO.setSelected(ConfigManager.getIntro());
        INTRO.setBounds(133, 325, 90, 96);
        INTRO.setBackground(Color.BLACK);
        INTRO.setRolloverEnabled(false);
        INTRO.setIcon(UNCHECK_ICON);
        INTRO.setSelectedIcon(CHECK_ICON);
        INTRO.addChangeListener(e -> ConfigManager.Write(ConfigManager.getMusic(), INTRO.isSelected()));
        //
    }
}