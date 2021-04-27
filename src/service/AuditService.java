package service;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditService {
    private static AuditService instance = null;
    private BufferedWriter bufferedWriter;
    private AuditService(){
        try{
            Path path = Path.of("files/users.csv");
            if (!Files.exists(path)) {
                try {
                    Files.createFile(path);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            this.bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND);

        }
        catch (Exception e){

        }

    }

    public static AuditService getInstance() {
        if (instance == null) {
            instance = new AuditService();
        }
        return instance;
    }

    public void write(String actionName){
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss").format(new Date());
        String output = actionName + "," +
                    timeStamp;
        try{
            bufferedWriter.write(output + "\n");
            bufferedWriter.flush();
//            bufferedWriter.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
