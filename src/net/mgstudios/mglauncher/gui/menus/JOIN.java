package net.mgstudios.mglauncher.gui.menus;

import net.mgstudios.mglauncher.game.GameRunner;
import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.gui.Menus;
import net.mgstudios.mglauncher.gui.components.*;
import net.mgstudios.mglauncher.font.Fonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;

public class JOIN extends LitePanel implements ActionListener {
    final Properties properties = System.getProperties();
    final JLabel title = new JLabel(properties.getProperty("gui.fnaf_1_multiplayer_join.title"));
    static final JTextField field = new JTextField();
    final LiteButton JOIN_BTN = new LiteButton(properties.getProperty("gui.fnaf_1_multiplayer_join.start"));
    final Copyright copyright = new Copyright();
    final Return return_btn = new Return();
    static final JPopupMenu rightClickMenu = new JPopupMenu();
    final JMenuItem paste = new JMenuItem(properties.getProperty("gui.popup.paste"));
    final JMenuItem copy = new JMenuItem(properties.getProperty("gui.popup.copy"));
    public JOIN(){
        //Popup Menu:
        rightClickMenu.add(paste);
        rightClickMenu.add(copy);

        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        paste.addActionListener(event -> field.paste());
        paste.setBackground(Color.BLACK);
        paste.setForeground(Color.WHITE);

        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        copy.addActionListener(event -> field.copy());
        copy.setBackground(Color.BLACK);
        copy.setForeground(Color.WHITE);
        //

        field.setComponentPopupMenu(rightClickMenu);

        title.setBounds(10,15,420,35);
        title.setForeground(Color.WHITE);
        title.setFont(Fonts.TITLE_FONT);

        field.setFont(new Font(Font.SERIF,Font.PLAIN,30));
        field.setBounds(10,205,280,45);
        field.setBackground(Color.BLACK);
        field.setForeground(Color.WHITE);
        field.setDocument(new JTextFieldLimit(19));

        JOIN_BTN.setBounds(305,205,200,45);
        JOIN_BTN.addActionListener(this);

        return_btn.addActionListener(this);

        field.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char typed_character = e.getKeyChar();
                if (((typed_character < '0') || (typed_character > '9')) && (typed_character != '\b') && (typed_character != '.') && (typed_character != ':')) {
                    e.consume();
                }
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    GameRunner.JOIN(field.getText());
                }
            }
        });
        field.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3){
                    JOIN.field.setInheritsPopupMenu(true);
                }
            }
        });

        this.add(JOIN_BTN);
        this.add(field);
        this.add(return_btn);
        this.add(title);
        this.add(copyright);
        this.add(JOIN_BTN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==JOIN_BTN){
            GameRunner.JOIN(field.getText());
        }
        if(e.getSource()==return_btn){
            Frame.LOAD(Menus.MULTIPLAYER_SELECT);
        }
    }
}