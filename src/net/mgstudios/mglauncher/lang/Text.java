package net.mgstudios.mglauncher.lang;
import net.mgstudios.mglauncher.gui.Error;
import java.util.Properties;

public class Text {
    private static final Properties properties = System.getProperties();
    public static String getText(String TEXT_ADDRESS){
        if(properties.getProperty(TEXT_ADDRESS) != null){
            return properties.getProperty(TEXT_ADDRESS);
        }
        else {
            System.out.println("===PropertyCrash===");
            System.out.printf("Property: %s Not Found!\n", TEXT_ADDRESS);
            new Error().LangFileNotFound("Property: %s Not Found!".formatted(TEXT_ADDRESS));
        }
        return "ERROR";
    }
}