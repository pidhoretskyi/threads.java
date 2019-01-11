import java.io.FileOutputStream;
import java.io.IOException;

public class Out {
    public String out="";

    public void WriteToFile() {
        try (FileOutputStream fos = new FileOutputStream("out.txt")) {
            byte[] buffer=out.getBytes();
            fos.write(buffer, 0, buffer.length);

        } catch (IOException ex) {
            System.out.println((ex.getMessage()));
        }
    }
}

