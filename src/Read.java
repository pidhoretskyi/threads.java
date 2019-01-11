import java.io.FileInputStream;
import java.io.IOException;

public class Read implements Runnable{

    String path;
    String buff;
    Out out;

    public Read(String path, Out out){
        this.path=path;
        this.out=out;
        buff="";

    }

    @Override
    public void run() {
        int steps=1024/64;
        try (FileInputStream fin = new FileInputStream(path)) {
            for (int i = 0; i < steps; i++) {
                byte letter;
                for (int j = 0; j < 64; j++) {
                    letter = (byte) fin.read();
                    buff += (char) letter;
                }

                synchronized (out) {
                    out.out += buff + "-";

                }
                buff = "";
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
