package net.mgstudios.mglauncher.gui;

import net.mgstudios.mglauncher.extra.Resource;
import net.mgstudios.mglauncher.gui.component.LiteButton;
import net.mgstudios.mglauncher.gui.component.LiteLabel;
import net.mgstudios.mglauncher.lang.Text;
import net.mgstudios.mglauncher.sound.ErrorSound;

import javax.swing.*;
import java.awt.*;

public class Error {
    private final Image icon = Toolkit.getDefaultToolkit().getImage(Resource.getURL("assets/mglauncher/icon.png"));
    private final Cursor CURSOR = Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(Resource.getURL("assets/mglauncher/cursor.png")), new Point(0, 0), "cursor");
    private static JDialog dialog;
    private void MakeDialog(String ERROR_CONTENT){
        if(dialog == null || !dialog.isShowing()){
            LiteLabel ERROR_LABEL = new LiteLabel(ERROR_CONTENT);
            dialog = new JDialog(Frame.frame, Text.getText("gui.error.title"));
            ERROR_LABEL.setForeground(Color.RED);
            ERROR_LABEL.setBounds(0, 35, 600, 30);
            ERROR_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
            ERROR_LABEL.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
            LiteButton OK_BUTTON = new LiteButton("OK");
            OK_BUTTON.setBounds(175, 85, 225,35);
            OK_BUTTON.addActionListener(e -> dialog.dispose());
            dialog.getContentPane().setBackground(Color.BLACK);
            dialog.setSize(600, 180);
            dialog.setLocationRelativeTo(null);
            dialog.setIconImage(icon);
            dialog.setLayout(null);
            dialog.setResizable(false);
            dialog.add(OK_BUTTON);
            dialog.setCursor(CURSOR);
            dialog.add(ERROR_LABEL);
            new ErrorSound().Exec();
            dialog.setVisible(true);
        }
    }
    public void EngineNotFound() {
        MakeDialog(Text.getText("gui.error.gzdoom"));
    }
    public void GameFolderNotFound() {
        MakeDialog(Text.getText("gui.error.directory"));
    }
    public void GameFilesNotFound() {
        MakeDialog(Text.getText("gui.error.files"));
    }
    public void PanelError() {
        MakeDialog(Text.getText("gui.error.panel"));
    }
    public void IpEmpty(){
        MakeDialog(Text.getText("gui.error.ip_empty"));
    }
    public void LangFileNotFound(String ERROR_TEXT) {
        JOptionPane.showMessageDialog(null, ERROR_TEXT, "PROPERTY ERROR", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
}