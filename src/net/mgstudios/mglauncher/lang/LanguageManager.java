package net.mgstudios.mglauncher.lang;

import com.google.gson.*;
import net.mgstudios.mglauncher.extra.Resource;
import net.mgstudios.mglauncher.gui.Error;
import net.mgstudios.mglauncher.gui.Frame;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class LanguageManager {
    private final Gson gson = new Gson();
    private final Properties properties = System.getProperties();
    private JsonObject obj;
    private void English(){
        try{
            this.obj = gson.fromJson(new BufferedReader(new InputStreamReader(Resource.getResource("assets/mglauncher/lang/en_us.json"))),JsonObject.class);
            setLangProperties();
        }
        catch (NullPointerException e){
            new Error().LangFileNotFound("English Lang File Not Found, Forcing Quit!");
        }
    }
    private void Portuguese(){
        try{
            this.obj = gson.fromJson(new BufferedReader(new InputStreamReader(Resource.getResource("assets/mglauncher/lang/pt_br.json"))),JsonObject.class);
            setLangProperties();
        }
        catch (NullPointerException e){
            new Error().LangFileNotFound("Arquivo Lang Português Não Foi Encontrado, Forçando Saída!");
        }
    }
    private void Spanish(){
        try{
            this.obj = gson.fromJson(new BufferedReader(new InputStreamReader(Resource.getResource("assets/mglauncher/lang/spanish.json"))),JsonObject.class);
            setLangProperties();
        }
        catch (NullPointerException e){
            new Error().LangFileNotFound("No Se Encuentra El Archivo De Idioma Español, ¡Obligando a Salir!");
        }
    }
    public void Init() {
        switch (System.getProperty("user.language")){
            case "en" -> English();
            case "pt" -> Portuguese();
            case "es" -> Spanish();
            default -> {
                System.out.println("===LANG-ERROR===");
                System.out.println("Using Default: EN-US");
                English();
            }
        }
    }
    private void PropertyRegister(String STRING_ADDRESS){
        try{
            properties.setProperty(STRING_ADDRESS, this.obj.get(STRING_ADDRESS).getAsString());
        }catch (NullPointerException e){
            System.out.println("PropertyRegister Crash!");
            JOptionPane.showMessageDialog(Frame.frame,"Property: '%s' Not Found, Forcing Quit!".formatted(STRING_ADDRESS),"FATAL ERROR",JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    public void setLangProperties(){
        PropertyRegister("init.message.start");
        PropertyRegister("init.message.version");
        PropertyRegister("init.message.newMessage");
        PropertyRegister("init.message.thanks");
        PropertyRegister("gui.info.text_title");
        PropertyRegister("gui.info.credits");
        PropertyRegister("gui.info.programmer");
        PropertyRegister("gui.info.designer");
        PropertyRegister("gui.info.version");
        PropertyRegister("gui.info.text");
        PropertyRegister("gui.fnaf_1.title");
        PropertyRegister("gui.text_title");
        PropertyRegister("gui.fnaf_1.singleplayer");
        PropertyRegister("gui.fnaf_1.multiplayer");
        PropertyRegister("gui.fnaf_1_multiplayer.title");
        PropertyRegister("gui.fnaf_1_multiplayer.host");
        PropertyRegister("gui.fnaf_1_multiplayer.join");
        PropertyRegister("gui.fnaf_1_multiplayer_host.title");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map.cutscene");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map.night");
        PropertyRegister("gui.fnaf_1_multiplayer_host.map.versus");
        PropertyRegister("gui.fnaf_1_multiplayer_host.start");
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
        PropertyRegister("gui.titles.main");
        PropertyRegister("gui.titles.fnaf_1");
        PropertyRegister("gui.titles.host");
        PropertyRegister("gui.titles.join");
        PropertyRegister("gui.titles.mt_select");
        PropertyRegister("gui.error.ip_empty");
        PropertyRegister("gui.titles.info");
    }
}