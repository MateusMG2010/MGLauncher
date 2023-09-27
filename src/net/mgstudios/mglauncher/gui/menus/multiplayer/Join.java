package net.mgstudios.mglauncher.gui.menus.multiplayer;

import net.mgstudios.mglauncher.game.GameRunner;
import net.mgstudios.mglauncher.gui.component.*;
import net.mgstudios.mglauncher.extra.Fonts;
import net.mgstudios.mglauncher.gui.Error;
import net.mgstudios.mglauncher.gui.menus.List;
import net.mgstudios.mglauncher.lang.Text;
import net.mgstudios.mglauncher.sound.ErrorSound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Join extends LitePanel {
    final LiteLabel TITLE = new LiteLabel(Text.getText("gui.fnaf_1_multiplayer_join.title"));
    static final JTextField FIELD = new JTextField();
    final InteractiveButton JOIN_BTN = new InteractiveButton(Text.getText("gui.fnaf_1_multiplayer_join.start"));
    static final JPopupMenu rightClickMenu = new JPopupMenu();
    final JMenuItem paste = new JMenuItem(Text.getText("gui.popup.paste"));
    final JMenuItem copy = new JMenuItem(Text.getText("gui.popup.copy"));
    final LiteLabel UNDERLINE = new LiteLabel("_________________");
    public Join(){
        super(List.ModeSelect);
        //Popup Menu:
        rightClickMenu.add(paste);
        rightClickMenu.add(copy);

        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        paste.addActionListener(event -> FIELD.paste());
        paste.setBackground(Color.BLACK);
        paste.setForeground(Color.WHITE);

        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        copy.addActionListener(event -> FIELD.copy());
        copy.setBackground(Color.BLACK);
        copy.setForeground(Color.WHITE);
        //

        FIELD.setComponentPopupMenu(rightClickMenu);

        TITLE.setBounds(10,15,420,35);
        TITLE.setFont(Fonts.TITLE_FONT);

        FIELD.setFont(new Font(Font.SERIF,Font.PLAIN,25));
        FIELD.setBounds(7,590,350,45);
        FIELD.setOpaque(false);
        FIELD.setBorder(BorderFactory.createEmptyBorder());
        FIELD.setBackground(Color.BLACK);
        FIELD.setForeground(Color.WHITE);
        FIELD.setDocument(new JTextFieldLimit(19));

        JOIN_BTN.setBounds(7,635,350,45);
        JOIN_BTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                TryToJoin();
            }
        });

        UNDERLINE.setBounds(7,595,290,35);

        FIELD.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char typed_character = e.getKeyChar();
                if(typed_character == KeyEvent.VK_ENTER){
                    TryToJoin();
                }
                if (((typed_character < '0') || (typed_character > '9')) && (typed_character != '\b') && (typed_character != '.') && (typed_character != ':')) {
                    new ErrorSound().Exec();
                    e.consume();
                }
            }
        });
        FIELD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3){
                    Join.FIELD.setInheritsPopupMenu(true);
                }
            }
        });

        this.add(JOIN_BTN);
        this.add(FIELD);
        this.add(TITLE);
        this.add(JOIN_BTN);
        this.add(UNDERLINE);
    }
    void TryToJoin(){
        if(FIELD.getText().equals("2010")){
            GameRunner.JOIN("localhost");
        }
        else if(FIELD.getText().isEmpty()) {
            new Error().IpEmpty();
        }
        else {
            GameRunner.JOIN(FIELD.getText());
        }
    }
}