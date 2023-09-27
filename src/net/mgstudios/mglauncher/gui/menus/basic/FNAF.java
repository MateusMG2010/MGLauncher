package net.mgstudios.mglauncher.gui.menus.basic;

import net.mgstudios.mglauncher.game.GameRunner;
import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.gui.component.*;
import net.mgstudios.mglauncher.extra.Fonts;
import net.mgstudios.mglauncher.gui.menus.List;
import net.mgstudios.mglauncher.lang.Text;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FNAF extends LitePanel {
    final LiteLabel title = new LiteLabel(Text.getText("gui.fnaf_1.title"));
    final InteractiveButton singleplayer = new InteractiveButton(Text.getText("gui.fnaf_1.singleplayer"));
    final InteractiveButton multiplayer = new InteractiveButton(Text.getText("gui.fnaf_1.multiplayer"));
    public FNAF(){
        super(List.MainMenu);
        title.setFont(Fonts.TITLE_FONT);
        title.setBounds(7,15,490,41);

        singleplayer.setBounds(7,590,350,45);
        singleplayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                GameRunner.SINGLEPLAYER();
            }
        });

        multiplayer.setBounds(7,635,350,45);
        multiplayer.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                multiplayer.reset();
                Frame.LOAD(List.ModeSelect);
            }
        });

        this.add(title);
        this.add(singleplayer);
        this.add(multiplayer);
    }
}
