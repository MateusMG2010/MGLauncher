package net.mgstudios.mglauncher.gui.menus;

import net.mgstudios.mglauncher.game.GameRunner;
import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.gui.Menus;
import net.mgstudios.mglauncher.gui.components.*;
import net.mgstudios.mglauncher.font.Fonts;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class HOST extends LitePanel implements ActionListener {
    final Properties properties = System.getProperties();
    final Copyright copyright = new Copyright();
    final LiteLabel TITLE = new LiteLabel(properties.getProperty("gui.fnaf_1_multiplayer_host.title"));
    final LiteLabel MAP_LABEL = new LiteLabel(properties.getProperty("gui.fnaf_1_multiplayer_host.map_label"));
    final LiteLabel CHEATS_LABEL = new LiteLabel(properties.getProperty("gui.fnaf_1_multiplayer_host.cheats"));
    final Return return_btn = new Return();
    final JComboBox<String> NIGHTS_BOX = new JComboBox<>();
    final JComboBox<String> CHEATS_BOX = new JComboBox<>();
    final LiteLabel PLAYERS_LABEL = new LiteLabel(properties.getProperty("gui.fnaf_1_multiplayer_host.players_number"));
    final SpinnerModel PLAYER_SPINNER_MODEL = new SpinnerNumberModel(2, 2, 8, 1);
    final JSpinner PLAYER_SPINNER = new JSpinner(PLAYER_SPINNER_MODEL);
    final JFormattedTextField PLAYER_SPINNER_EDITOR = ((JSpinner.DefaultEditor) PLAYER_SPINNER.getEditor()).getTextField();
    final SpinnerModel PORT_SPINNER_MODEL = new SpinnerNumberModel(5029, 100, 9999, 1);
    final JSpinner PORT_SPINNER = new JSpinner(PORT_SPINNER_MODEL);
    final LiteLabel PORT_LABEL = new LiteLabel(properties.getProperty("gui.fnaf_1_multiplayer_host.port"));
    final JSpinner.NumberEditor PORT_SPINNER_NUMBER_EDITOR = new JSpinner.NumberEditor(PORT_SPINNER, "#");
    final LiteButton START_HOST = new LiteButton(properties.getProperty("gui.fnaf_1_multiplayer_host.start"));
    public HOST(){
        TITLE.setForeground(Color.WHITE);
        TITLE.setFont(Fonts.TITLE_FONT);
        TITLE.setBounds(7,15,425,41);

        return_btn.addActionListener(this);

        //LEFT
        NIGHTS_BOX.setBackground(Color.BLACK);
        NIGHTS_BOX.setForeground(Color.WHITE);
        NIGHTS_BOX.addItem(properties.getProperty("gui.fnaf_1_multiplayer_host.map.cutscene"));
        NIGHTS_BOX.addItem(properties.getProperty("gui.fnaf_1_multiplayer_host.map.night_1"));
        NIGHTS_BOX.addItem(properties.getProperty("gui.fnaf_1_multiplayer_host.map.night_2"));
        NIGHTS_BOX.addItem(properties.getProperty("gui.fnaf_1_multiplayer_host.map.night_3"));
        NIGHTS_BOX.addItem(properties.getProperty("gui.fnaf_1_multiplayer_host.map.night_4"));
        NIGHTS_BOX.addItem(properties.getProperty("gui.fnaf_1_multiplayer_host.map.night_5"));
        NIGHTS_BOX.addItem(properties.getProperty("gui.fnaf_1_multiplayer_host.map.night_6"));
        NIGHTS_BOX.addItem(properties.getProperty("gui.fnaf_1_multiplayer_host.map.versus"));
        NIGHTS_BOX.setBounds(10,160,335,40);
        NIGHTS_BOX.setFont(new Font(Font.SERIF,Font.PLAIN,25));
        NIGHTS_BOX.setFocusable(false);

        CHEATS_BOX.setBackground(Color.BLACK);
        CHEATS_BOX.setForeground(Color.WHITE);
        CHEATS_BOX.addItem(properties.getProperty("gui.fnaf_1_multiplayer_host.cheats.yes"));
        CHEATS_BOX.addItem(properties.getProperty("gui.fnaf_1_multiplayer_host.cheats.no"));
        CHEATS_BOX.setBounds(10,250,335,40);
        CHEATS_BOX.setFont(new Font(Font.SERIF,Font.PLAIN,25));
        CHEATS_BOX.setFocusable(false);

        MAP_LABEL.setBounds(10,120,220,35);

        CHEATS_LABEL.setBounds(10,210,220,35);
        //

        //RIGHT
        PLAYERS_LABEL.setBounds(385,120,275,35);

        PLAYER_SPINNER.setBackground(Color.BLACK);
        PLAYER_SPINNER.setForeground(Color.WHITE);
        PLAYER_SPINNER.setBounds(385,160,335,40);

        PLAYER_SPINNER_EDITOR.setBackground(Color.BLACK);
        PLAYER_SPINNER_EDITOR.setForeground(Color.WHITE);
        PLAYER_SPINNER_EDITOR.setFont(new Font(Font.SERIF,Font.PLAIN,32));
        PLAYER_SPINNER_EDITOR.setEditable(false);

        PORT_SPINNER.setBackground(Color.BLACK);
        PORT_SPINNER.setForeground(Color.WHITE);
        PORT_SPINNER.setBounds(385,250,335,40);
        PORT_SPINNER.setEditor(PORT_SPINNER_NUMBER_EDITOR);

        PORT_LABEL.setBounds(385,210,220,35);
        //

        JFormattedTextField PORT_SPINNER_EDITOR = ((JSpinner.DefaultEditor) PORT_SPINNER.getEditor()).getTextField();
        PORT_SPINNER_EDITOR.setBackground(Color.BLACK);
        PORT_SPINNER_EDITOR.setForeground(Color.WHITE);
        PORT_SPINNER_EDITOR.setFont(new Font(Font.SERIF,Font.PLAIN,32));
        PORT_SPINNER_EDITOR.setEditable(false);

        START_HOST.setBounds(10,325,713,44);
        START_HOST.addActionListener(this);

        this.add(copyright);
        this.add(TITLE);
        this.add(return_btn);
        this.add(NIGHTS_BOX);
        this.add(MAP_LABEL);
        this.add(CHEATS_BOX);
        this.add(CHEATS_LABEL);
        this.add(PLAYER_SPINNER);
        this.add(PLAYERS_LABEL);
        this.add(PORT_SPINNER);
        this.add(PORT_LABEL);
        this.add(START_HOST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == START_HOST) {
            properties.setProperty("pNumber", PLAYER_SPINNER.getValue().toString());
            properties.setProperty("port", PORT_SPINNER.getValue().toString());
            int SELECTED_INDEX = NIGHTS_BOX.getSelectedIndex();
            int CHEATS_INDEX = CHEATS_BOX.getSelectedIndex();
            switch (SELECTED_INDEX) {
                case 0 -> properties.setProperty("map", "e1m1");
                case 1 -> properties.setProperty("map", "e1m2");
                case 2 -> properties.setProperty("map", "e1m3");
                case 3 -> properties.setProperty("map", "e1m4");
                case 4 -> properties.setProperty("map", "e1m5");
                case 5 -> properties.setProperty("map", "e1m6");
                case 6 -> properties.setProperty("map", "e1m7");
                case 7 -> properties.setProperty("map", "e2m1");
                default -> properties.setProperty("map", "ERROR");
            }
            switch (CHEATS_INDEX) {
                case 0 -> properties.setProperty("cheats", "1");
                case 1 -> properties.setProperty("cheats", "0");
            }
            GameRunner.HOST();
        }
        if(e.getSource()==return_btn){
            Frame.LOAD(Menus.MULTIPLAYER_SELECT);
        }
    }
}