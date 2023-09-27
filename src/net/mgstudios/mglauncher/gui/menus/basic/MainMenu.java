package net.mgstudios.mglauncher.gui.menus.basic;

import net.mgstudios.mglauncher.extra.Resource;
import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.gui.InfoMenu;
import net.mgstudios.mglauncher.Main;
import net.mgstudios.mglauncher.gui.component.LiteButton;
import net.mgstudios.mglauncher.gui.component.LiteLabel;
import net.mgstudios.mglauncher.extra.Fonts;
import net.mgstudios.mglauncher.gui.menus.List;
import net.mgstudios.mglauncher.lang.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements ActionListener {
    public static final LiteButton INFO = new LiteButton();
    final LiteLabel TITLE = new LiteLabel(Text.getText("gui.text_title"));
    final LiteLabel NAME = new LiteLabel("Five Nights at Freddy's 1:");
    final LiteButton FNAF_1 = new LiteButton();
    final LiteLabel MESSAGE_AREA = new LiteLabel(Main.getMessage());
    final LiteLabel COPYRIGHT = new LiteLabel("©MGStudios -MateusMG2010");
    public MainMenu() {
        FNAF_1.setBounds(120,180,500,281);
        FNAF_1.setIcon(new ImageIcon(Resource.getURL("assets/mglauncher/game_logo.png")));
        FNAF_1.addActionListener(this);

        MESSAGE_AREA.setBounds(7,15,720,30);
        MESSAGE_AREA.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        MESSAGE_AREA.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        MESSAGE_AREA.setHorizontalAlignment(0);

        NAME.setBounds(120,140,500,30);
        NAME.setFont(Fonts.GAME_NAME_FONT);

        TITLE.setFont(Fonts.TITLE_FONT);
        TITLE.setBounds(7,55,320,40);

        INFO.setBounds(680,55,45,45);
        INFO.addActionListener(this);
        INFO.setIcon(new ImageIcon(Resource.getURL("assets/mglauncher/settings.png")));

        COPYRIGHT.setForeground(Color.GREEN);
        COPYRIGHT.setFont(Fonts.COPYRIGHT_FONT);
        COPYRIGHT.setBounds(10,725,225,30);

        this.setBackground(Color.BLACK);
        this.setLayout(null);

        this.add(TITLE);
        this.add(INFO);
        this.add(FNAF_1);
        this.add(NAME);
        this.add(MESSAGE_AREA);
        this.add(COPYRIGHT);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==INFO){
            if(InfoMenu.dialog == null || !InfoMenu.dialog.isShowing()){
                new InfoMenu();
            }
        }
        if(e.getSource()==FNAF_1){
            Frame.LOAD(List.FNAF);
        }
    }
}