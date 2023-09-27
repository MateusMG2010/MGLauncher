package net.mgstudios.mglauncher.msg;

import net.mgstudios.mglauncher.extra.Resource;

import java.io.*;
import java.util.Objects;
import java.util.Random;

public class MessageManager {
    private int getRandomNumber(int LIMIT){
        return new Random().nextInt(0,LIMIT);
    }
    private static BufferedReader br;
    private static void setReader(){
        br = new BufferedReader(new InputStreamReader(Resource.getResource("assets/mglauncher/msg/messages.txt")));
    }
    private int getLineNumber() {
        try {
            int lines = 0;
            while (br.readLine() != null) lines++;
            br.close();
            return lines;
        }
        catch (IOException e){
            return 0;
        }
    }
    private String readLine(int LINE_NUMBER){
        setReader();
        try{
            for(int i = 0; i < LINE_NUMBER; i++){
                br.readLine();
            }
            String msg = br.readLine();
            return Objects.requireNonNullElse(msg, "ERROR");
        }
        catch (IOException e){
            return "ERROR";
        }
    }
    public String getMessage() {
        setReader();
        return readLine(getRandomNumber(getLineNumber()));
    }
}