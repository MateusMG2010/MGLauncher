package net.mgstudios.mglauncher.lang;

import com.google.gson.*;
import net.mgstudios.mglauncher.gui.error.Error;
import net.mgstudios.mglauncher.gui.Frame;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class LanguageManager {
    final Gson gson = new Gson();
    final Properties properties = System.getProperties();
    JsonObject obj;
    public void English(){
        try{
            this.obj = gson.fromJson(new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("assets/mglauncher/lang/en_us.json"))),JsonObject.class);
            setLangProperties();
        }
        catch (NullPointerException e){
            new Error().LangFileNotFound("English Lang File Not Found, Forcing Quit!");
        }
    }
    public void Portuguese(){
        try{
            this.obj = gson.fromJson(new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("assets/mglauncher/lang/pt_br.json"))),JsonObject.class);
            setLangProperties();
        }
        catch (NullPointerException e){
            new Error().LangFileNotFound("Arquivo Lang Português Não Foi Encontrado, Forçando Saída!");
        }
    }
    public void Init(){
        switch (System.getProperty("user.language")){
            case "en" -> English();
            case "pt" -> Portuguese();
            default -> System.out.println("We Can't Find Your Language, Setting to Default (English)");
        }
    }
    public void PropertyRegister(String STRING_ADDRESS){
        try{
            properties.setProperty(STRING_ADDRESS, this.obj.get(STRING_ADDRESS).getAsString());
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(Frame.frame,"Some Properties Not Found, Forcing Quit!","FATAL ERROR",JOptionPane.ERROR_MESSAGE);
            System.out.printf("The Property Is: %s \n", STRING_ADDRESS);
            e.printStackTrace();
            System.exit(0);
        }
    }
    public void setLangProperties(){
        PropertyRegister("init.message.start");
        PropertyRegister("init.message.version");
        PropertyRegister("init.message.newMessage");
        PropertyRegister("init.message.thanks");
        PropertyRegister("gui.title");
        PropertyRegister("gui.info.title");
        PropertyRegister("gui.info.text_title");
        PropertyRegister("gui.text_title");
        PropertyRegister("gui.info.credits");
        PropertyRegister("gui.info.programmer");
        PropertyRegister("gui.info.designer");
        PropertyRegister("gui.info.version");
        PropertyRegister("gui.info.text");
        PropertyRegister("gui.fnaf_1.title");
        PropertyRegister("gui.fnaf_1.singleplayer");
        PropertyRegister("gui.fnaf_1.multiplayer");
        PropertyRegister("gui.fnaf_1_multiplayer.title");
        PropertyRegister("gui.fnaf_1_multiplayer.host");
        PropertyRegister("gui.fnaf_1_multiplayer.join");
        PropertyRegister("gui.fnaf_1_multiplayer_host.title");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map_label");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map.cutscene");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map.night_1");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map.night_2");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map.night_3");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map.night_4");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map.night_5");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map.night_6");
        PropertyRegister("gui.fnaf_1_multiplayer_host.players_number");
        PropertyRegister("gui.fnaf_1_multiplayer_host.cheats");
        PropertyRegister("gui.fnaf_1_multiplayer_host.cheats.yes");
        PropertyRegister("gui.fnaf_1_multiplayer_host.cheats.no");
        PropertyRegister("gui.fnaf_1_multiplayer_host.port");
        PropertyRegister("gui.fnaf_1_multiplayer_host.start");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map.versus");
        PropertyRegister("gui.fnaf_1_multiplayer_join.title");
        PropertyRegister("gui.fnaf_1_multiplayer_join.start");
        PropertyRegister("gui.info.music");
        PropertyRegister("gui.error.title");
        PropertyRegister("gui.error.gzdoom");
        PropertyRegister("gui.error.directory");
        PropertyRegister("gui.error.files");
        PropertyRegister("gui.error.panel");
        PropertyRegister("gui.popup.paste");
        PropertyRegister("gui.popup.copy");
        PropertyRegister("gui.other.ugly");
    }
}