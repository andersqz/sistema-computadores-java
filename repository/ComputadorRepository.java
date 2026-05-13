package repository;

import java.util.ArrayList;
import java.util.List;

import model.Notebook;
import model.Computador;
import model.Desktop;

public class ComputadorRepository {
    
    private static List<Computador> lista = new ArrayList<>();

    public static void saveNotebook(Notebook note) {
        lista.add(note);
    }
    
    public static void saveDesktop(Desktop pc) {
    	lista.add(pc);
    }

    public static void list() {
    	
    	for (Computador i : lista) {
    		System.out.println(i + "\n");
    	}
    }
}
