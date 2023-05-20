package net.mgstudios.mglauncher.gui.menus;

import net.mgstudios.mglauncher.game.GameRunner;
import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.gui.Menus;
import net.mgstudios.mglauncher.gui.components.Copyright;
import net.mgstudios.mglauncher.gui.components.LitePanel;
import net.mgstudios.mglauncher.gui.components.LiteButton;
import net.mgstudios.mglauncher.font.Fonts;
import net.mgstudios.mglauncher.gui.components.Return;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class FNAF_1 extends LitePanel implements ActionListener {
    final Properties properties = System.getProperties();
    final JLabel title = new JLabel(properties.getProperty("gui.fnaf_1.title"));
    final LiteButton singleplayer = new LiteButton(properties.getProperty("gui.fnaf_1.singleplayer"));
    final LiteButton multiplayer = new LiteButton(properties.getProperty("gui.fnaf_1.multiplayer"));
    final Return return_btn = new Return();
    final Copyright copyright = new Copyright();
    public FNAF_1(){

        title.setFont(Fonts.TITLE_FONT);
        title.setBounds(7,15,490,41);
        title.setForeground(Color.WHITE);

        singleplayer.setBounds(7,135,720,45);
        singleplayer.addActionListener(this);

        multiplayer.setBounds(7,185,720,45);

        multiplayer.addActionListener(this);
        return_btn.addActionListener(this);

        this.add(title);
        this.add(singleplayer);
        this.add(multiplayer);
        this.add(copyright);
        this.add(return_btn);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==singleplayer){
            GameRunner.SINGLEPLAYER();
        }
        if(e.getSource()==multiplayer){
            Frame.LOAD(Menus.MULTIPLAYER_SELECT);
        }
        if(e.getSource()==return_btn){
            Frame.LOAD(Menus.MAIN_PANEL);
        }
    }
}
