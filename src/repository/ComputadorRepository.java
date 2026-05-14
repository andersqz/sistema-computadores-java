package repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Computador;

public class ComputadorRepository {

    static File path = new File("C:\\dev\\sistema-computador\\sistema-computadores-java\\src\\repository\\computadores.csv");
    
    private static List<Computador> lista = new ArrayList<>();

    public static void save(Computador comp) {
        lista.add(comp);

        try {

            Boolean arquivoExiste = path.exists() &&  path.length() > 0;
            FileWriter escritor = new FileWriter(path, true);

            if (!arquivoExiste)
                escritor.write("tipo;modelo;numeroSerie;custoBase;custoAdicional;numeroComponentes;peso\n");

            escritor.write(comp.toCsv());
            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void list() {
    	
    	for (Computador i : lista) {
    		System.out.println(i + "\n");
    	}
    }
}
