package repository;

import java.util.ArrayList;
import java.util.List;
import model.Computador;

public class ComputadorRepository {
    
    private static List<Computador> lista = new ArrayList<>();

    public static void save(Computador comp) {
        lista.add(comp);
    }

    public static void list() {
    	
    	for (Computador i : lista) {
    		System.out.println(i + "\n");
    	}
    }
}
