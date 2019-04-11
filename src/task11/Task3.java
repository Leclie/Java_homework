package task11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Task3 {

    int count = 0;
    File file;

    public Task3(File file) {
        this.file = file;
    }

    public void search() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            while (fileInputStream.available() > 0){
                int data = fileInputStream.read();
                if(data == 44){
                    ++count;
                }
            }
        }
        System.out.println("Количество запятых = " + count);
    }
}
