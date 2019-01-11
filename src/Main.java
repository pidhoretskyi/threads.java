import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        Out out = new Out();
        int NumOfFiles=2;
        int FileSize=1024;

      //  System.out.println("Enter num of files:");
        while(true) {
            System.out.println("Enter num of files:");
            if (in.hasNextInt() == true) {
                NumOfFiles=in.nextInt();
                //break;
            } else {
                continue;
            }
            System.out.println("Enter size of files(in kbytes):");
            if (in.hasNextInt() == true) {
                FileSize=in.nextInt()*1024;
               // break;
            } else {
                continue;
            }
            break;
        }
        String[] FilesPath;
        Thread []threads = new Thread[NumOfFiles];
        FilesPath=new String[NumOfFiles];
        createFile(NumOfFiles, FileSize, FilesPath);
        for(int i=0; i<NumOfFiles; i++) {
            threads[i]=new Thread(new Read(FilesPath[i], out));
            threads[i].run();
        }


        System.out.println(out.out);
        //rand();
        out.WriteToFile();
    }

    static public void createFile(int NumOfFiles, int FileSize, String []FilesPath){
        //Створюємо файли
        //єCounter починється з acii коду букви а і йде до кінця алфавіту або до необхідного числа файлів
        for(int i=97; i<122 && i<97+NumOfFiles; i++){
            FilesPath[i-97]=(char)i+".txt";
            try(FileOutputStream fos=new FileOutputStream(FilesPath[i-97])){
                byte letter = (byte)i;
                for(int j=0; j<FileSize; j++){//Записуємо у файл FileSize байт символів
                    fos.write(letter);
                }
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }

        }
    }

    static void rand(){
        Random rand = new Random();
        System.out.println(rand.nextInt(1000));
    }
}
