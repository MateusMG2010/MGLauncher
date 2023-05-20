package net.mgstudios.mglauncher.gui.error;

import net.mgstudios.mglauncher.gui.Frame;
import net.mgstudios.mglauncher.gui.components.LiteButton;
import net.mgstudios.mglauncher.sound.ErrorSoundManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

public class Error {
    final Toolkit toolkit = Toolkit.getDefaultToolkit();
    final Properties properties = System.getProperties();
    final Image icon = toolkit.getImage(getClass().getClassLoader().getResource("assets/mglauncher/icon.png"));
    final Image CURSOR_IMAGE = toolkit.getImage(getClass().getClassLoader().getResource("assets/mglauncher/cursor.png"));
    final Cursor CURSOR = toolkit.createCustomCursor(CURSOR_IMAGE, new Point(0, 0), "custom_cursor");
    final JFrame frame = Frame.frame;
    void MakeDialog(String LABEL_TEXT){
        ErrorLabel error_label = new ErrorLabel(LABEL_TEXT);
        LiteButton OK_BUTTON = new LiteButton("OK");
        Dialog dialog = new Dialog(frame, properties.getProperty("gui.error.title"));
        OK_BUTTON.setFont(new Font(Font.SERIF,Font.PLAIN,15));
        OK_BUTTON.setBounds(190, 125, 200,30);
        OK_BUTTON.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        OK_BUTTON.addActionListener((e) -> dialog.dispose());
        dialog.setBackground(Color.BLACK);
        dialog.setSize(600, 180);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.setIconImage(icon);
        dialog.setResizable(false);
        dialog.setLayout(null);
        dialog.add(error_label);
        dialog.add(OK_BUTTON);
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });
        dialog.setCursor(CURSOR);
        new ErrorSoundManager().Exec();
    }
    public void GZDoomNotFound() {
        MakeDialog(properties.getProperty("gui.error.gzdoom"));
    }

    public void GameFolderNotFound() {
        MakeDialog(properties.getProperty("gui.error.directory"));
    }

    public void GameFilesNotFound() {
        MakeDialog(properties.getProperty("gui.error.files"));
    }

    public void PanelError() {
        MakeDialog(properties.getProperty("gui.error.panel"));
    }

    public void LangFileNotFound(String ERROR_TEXT) {
        LangErrorLabel errorLabel = new LangErrorLabel(ERROR_TEXT);
        Dialog dialog = new Dialog(frame, "LANG ERROR");
        dialog.setBackground(Color.BLACK);
        dialog.setSize(600, 180);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.setIconImage(icon);
        dialog.setResizable(false);
        dialog.setLayout(null);
        dialog.add(errorLabel);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });
        dialog.setCursor(CURSOR);
        errorLabel.setText(ERROR_TEXT);
        new ErrorSoundManager().Exec();
        while (dialog.isShowing()){
            System.out.println("Error.LangFileNotFound");
        }
        System.exit(0);
    }
}