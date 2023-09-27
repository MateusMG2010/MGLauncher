package net.mgstudios.mglauncher.gui.menus.multiplayer;

import net.mgstudios.mglauncher.game.GameRunner;
import net.mgstudios.mglauncher.gui.component.*;
import net.mgstudios.mglauncher.extra.Fonts;
import net.mgstudios.mglauncher.gui.menus.List;
import net.mgstudios.mglauncher.lang.Text;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Host extends LitePanel {
    final LiteLabel TITLE = new LiteLabel(Text.getText("gui.fnaf_1_multiplayer_host.title"));
    final SpinnerModel PLAYER_SPINNER_MODEL = new SpinnerNumberModel(2, 2, 8, 1);
    final JSpinner PLAYER_SPINNER = new JSpinner(PLAYER_SPINNER_MODEL);
    final JFormattedTextField PLAYER_SPINNER_EDITOR = ((JSpinner.DefaultEditor) PLAYER_SPINNER.getEditor()).getTextField();
    final InteractiveButton START_HOST = new InteractiveButton(Text.getText("gui.fnaf_1_multiplayer_host.start"));
    static final JComboBox<String> NIGHT = new JComboBox<>(new String[]{Text.getText("gui.fnaf_1_multiplayer_host.map.cutscene")});
    public Host(){
        super(List.ModeSelect);
        TITLE.setFont(Fonts.TITLE_FONT);
        TITLE.setBounds(7,15,425,41);

        PLAYER_SPINNER.setBackground(Color.BLACK);
        PLAYER_SPINNER.setForeground(Color.WHITE);
        PLAYER_SPINNER.setBounds(7,557,150,35);

        PLAYER_SPINNER_EDITOR.setBackground(Color.BLACK);
        PLAYER_SPINNER_EDITOR.setForeground(Color.WHITE);
        PLAYER_SPINNER_EDITOR.setFont(new Font(Font.SERIF,Font.PLAIN,32));
        PLAYER_SPINNER_EDITOR.setEditable(false);

        NIGHT.setBounds(7,605,150,35);
        NIGHT.setFocusable(false);
        NIGHT.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        NIGHT.setForeground(Color.WHITE);
        NIGHT.setBackground(Color.BLACK);
        for(int i = 1; i <= 6; i++){
            NIGHT.addItem(Text.getText("gui.fnaf_1_multiplayer_host.map.night").formatted(i));
        }
        NIGHT.addItem(Text.getText("gui.fnaf_1_multiplayer_host.map.versus"));

        START_HOST.setBounds(7,645,250,45);
        START_HOST.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                GameRunner.HOST(PLAYER_SPINNER.getValue().toString(), switch (NIGHT.getSelectedIndex()){
                    case 0: yield "e1m1";
                    case 1: yield "e1m2";
                    case 2: yield "e1m3";
                    case 3: yield "e1m4";
                    case 4: yield "e1m5";
                    case 5: yield "e1m6";
                    case 6: yield "e1m7";
                    case 7: yield "e2m1";
                    default: throw new IllegalStateException("Unexpected value: " + NIGHT.getSelectedIndex());
                });
            }
        });

        this.add(TITLE);
        this.add(PLAYER_SPINNER);
        this.add(START_HOST);
        this.add(NIGHT);
    }
}