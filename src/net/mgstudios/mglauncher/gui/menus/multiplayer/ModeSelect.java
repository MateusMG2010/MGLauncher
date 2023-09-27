package net.mgstudios.mglauncher.gui.menus.multiplayer;

import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.gui.component.*;
import net.mgstudios.mglauncher.extra.Fonts;
import net.mgstudios.mglauncher.gui.menus.List;
import net.mgstudios.mglauncher.lang.Text;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModeSelect extends LitePanel {
    final LiteLabel TITLE = new LiteLabel(Text.getText("gui.fnaf_1_multiplayer.title"));
    final InteractiveButton JOIN_BTN = new InteractiveButton(Text.getText("gui.fnaf_1_multiplayer.join"));
    final InteractiveButton HOST_BTN = new InteractiveButton(Text.getText("gui.fnaf_1_multiplayer.host"));
    public ModeSelect(){
        super(List.FNAF);
        TITLE.setBounds(7,15,510,41);
        TITLE.setFont(Fonts.TITLE_FONT);

        JOIN_BTN.setBounds(7,590,350,45);
        HOST_BTN.setBounds(7,635,350,45);

        HOST_BTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                HOST_BTN.reset();
                Frame.LOAD(List.HOST);
            }
        });

        JOIN_BTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOIN_BTN.reset();
                Frame.LOAD(List.JOIN);
            }
        });

        this.add(TITLE);
        this.add(JOIN_BTN);
        this.add(HOST_BTN);
    }
}