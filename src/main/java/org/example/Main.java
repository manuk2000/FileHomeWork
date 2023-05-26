package org.example;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        File soursDir = new File("d1/d2/d3");
        soursDir.mkdirs();
        List<File> files = new ArrayList<>();
        createFile(soursDir.getAbsolutePath() , files , ".txt");
        createFile(soursDir.getAbsolutePath() , files , ".pdf");
        createFile(soursDir.getAbsolutePath() , files , ".jmp");


        String resPath = "res";
        String txtPath = resPath + "/txt";
        String jmpPath = resPath + "/jmp";
        String pdfPath = resPath + "/pdf";

        Files.createDirectories(Path.of(resPath));

        Files.createDirectories(Path.of(txtPath));
        File[] txtFiles =  soursDir.listFiles((file , name) -> name.endsWith(".txt"));
        moveToDerectory(txtFiles , txtPath);

        Files.createDirectories(Path.of(jmpPath));
        File[] jmpFiles =  soursDir.listFiles((file , name) -> name.endsWith(".jmp"));
        moveToDerectory(jmpFiles , jmpPath);

        Files.createDirectories(Path.of(pdfPath));
        File[] pdfFiles =  soursDir.listFiles((file , name) -> name.endsWith(".pdf"));
        moveToDerectory(pdfFiles , pdfPath);

    }

    static void  createFile(String path ,List<? super File> list , String typeFile) throws IOException {
        for (int i = 0; i < 10; i++) {
            File f1 = new File("d1/d2/d3/a" + i + typeFile);
            f1.createNewFile();
            list.add(f1);
        }
    }
    static void moveToDerectory(File[] fileArr , String desPath){
        Arrays.stream(fileArr).forEach(file -> {
            try {
                Files.move(Path.of(file.getAbsolutePath() ) , Path.of(desPath , file.getName()) , StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}


