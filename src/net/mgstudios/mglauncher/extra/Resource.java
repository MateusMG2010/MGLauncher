package net.mgstudios.mglauncher.extra;

import java.io.InputStream;
import java.net.URL;

public class Resource {
    public static InputStream getResource(String NAME){
        return Resource.class.getClassLoader().getResourceAsStream(NAME);
    }
    public static URL getURL(String NAME){
        return Resource.class.getClassLoader().getResource(NAME);
    }
}