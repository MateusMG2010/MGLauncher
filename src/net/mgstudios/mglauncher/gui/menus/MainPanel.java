package net.mgstudios.mglauncher.gui.menus;

import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.gui.InfoMenu;
import net.mgstudios.mglauncher.Main;
import net.mgstudios.mglauncher.gui.Menus;
import net.mgstudios.mglauncher.gui.components.Copyright;
import net.mgstudios.mglauncher.gui.components.LiteButton;
import net.mgstudios.mglauncher.gui.components.LiteLabel;
import net.mgstudios.mglauncher.gui.components.LitePanel;
import net.mgstudios.mglauncher.font.Fonts;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class MainPanel extends LitePanel implements ActionListener {
    final Properties properties = System.getProperties();
    final Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
    final Copyright copyright = new Copyright();
    final ImageIcon FNAF_1_IMAGE = new ImageIcon(getClass().getClassLoader().getResource("assets/mglauncher/game_logo.png"));
    final JLabel title = new JLabel(properties.getProperty("gui.text_title"));
    final JLabel FNAF_1_LABEL = new JLabel("Five Nights at Freddy's 1:");
    public static final JButton info = new JButton("?");
    final LiteButton FNAF_1 = new LiteButton();
    final LiteLabel MESSAGE_AREA = new LiteLabel(Main.MESSAGE);
    public MainPanel(){

        FNAF_1.setBounds(120,180,500,281);
        FNAF_1.setIcon(FNAF_1_IMAGE);
        FNAF_1.addActionListener(this);

        MESSAGE_AREA.setBounds(7,15,720,30);
        MESSAGE_AREA.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        MESSAGE_AREA.setBorder(border);
        MESSAGE_AREA.setHorizontalAlignment(0);

        FNAF_1_LABEL.setBounds(120,140,500,30);
        FNAF_1_LABEL.setFont(Fonts.GAME_NAME_FONT);
        FNAF_1_LABEL.setForeground(Color.WHITE);

        title.setForeground(Color.WHITE);
        title.setFont(Fonts.TITLE_FONT);
        title.setBounds(7,75,320,40);

        info.setForeground(Color.WHITE);
        info.setBackground(Color.BLACK);
        info.setBounds(680,75,45,45);
        info.setFont(new Font("Arial",Font.BOLD,15));
        info.setFocusable(false);
        info.addActionListener(this);

        this.add(copyright);
        this.add(title);
        this.add(info);
        this.add(FNAF_1);
        this.add(FNAF_1_LABEL);
        this.add(MESSAGE_AREA);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==info){
            new InfoMenu();
            info.setEnabled(false);
        }
        if(e.getSource()== FNAF_1){
            Frame.LOAD(Menus.FNAF_1);
        }
    }
}