package punto4Test;
import punto4.*;

import java.util.Date;

public class Main{
    public static void main(String[] args) {

        Directorio root = new Directorio("root", new Date());
        
        Archivo a1 = new Archivo("archivo1", 100, new Date());
        Archivo a2 = new Archivo("archivo2", 200, new Date());
        
        Directorio subDir = new Directorio("subdir", new Date());
        Archivo a3 = new Archivo("archivo3", 300, new Date());
        
        subDir.add(a3);
        root.add(a1);
        root.add(a2);
        root.add(subDir);
        
        root.printStructure(0);
    }
}