package fitness;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class FitnessLogger {
    File file;

    FitnessLogger(File file){
        this.file = file;
    }

    public void add(Human human, FitnessServiceEnumeration type){
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true)){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(human.getSurname() + " ")
                         .append(human.getName() + " ")
                         .append(type.toString() + " ")
                         .append(new Date().toString())
                         .append('\n');
            byte[] bytes = stringBuilder.toString().getBytes();
            fileOutputStream.write(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
