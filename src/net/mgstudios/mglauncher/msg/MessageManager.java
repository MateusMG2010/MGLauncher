package net.mgstudios.mglauncher.msg;

import java.io.*;
import java.util.Objects;
import java.util.Random;

public class MessageManager {
    public int getRandomNumber(int LIMIT){
        return new Random().nextInt(0,LIMIT);
    }
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("assets/mglauncher/msg/messages.txt")));
    public int getLineNumber() {
        try {
            int lines = 0;
            while (bufferedReader.readLine() != null) lines++;
            bufferedReader.close();
            return lines;
        }
        catch (IOException e){
            e.printStackTrace();

        }
        return 0;
    }
    public String readLine(int LINE_NUMBER){
        this.bufferedReader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("assets/mglauncher/msg/messages.txt")));
        try{
            for(int x = 0; x < LINE_NUMBER; x++){
                bufferedReader.readLine();
            }
            String msg = bufferedReader.readLine();
            return Objects.requireNonNullElse(msg, "ERROR");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "ERROR";
    }
    public String getMessage() {
        return readLine(getRandomNumber(getLineNumber()));
    }
}