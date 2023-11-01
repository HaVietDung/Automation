package screenplay.common;

import net.serenitybdd.core.Serenity;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HandleFile {
    String pathFile = "src/test/resources/data/InfoProduct.txt";

    File textFile = new File(pathFile);


//    create file
    public void createFile() throws IOException {
        if (textFile.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("File already exists");
        }
    }

//    write file
    public void writeFile() throws FileNotFoundException, UnsupportedEncodingException {
        String data_S = Serenity.sessionVariableCalled("data-s");
        String nameProduct = Serenity.sessionVariableCalled("nameProduct");
        String linkProduct = Serenity.sessionVariableCalled("linkProduct");
        String priceProduct = Serenity.sessionVariableCalled("priceProduct");
        int size = Serenity.sessionVariableCalled("sizeProduct");
        PrintWriter file = new PrintWriter(textFile, "UTF-8");
        for(int i = 0; i < size; i++){
            file.println(data_S);
            file.println(nameProduct);
            file.println(linkProduct);
            file.println(priceProduct);
            file.close();
        }
    }
    public void readFile() throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(pathFile)), StandardCharsets.UTF_8);
        System.out.println(data);
    }

}
