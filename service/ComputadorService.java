package service;

import exceptions.InvalidCustoBaseException;
import model.Desktop;
import model.Notebook;
import repository.ComputadorRepository;
import util.Util;
import model.Computador;

public class ComputadorService {
	

	public static Boolean validaDados(Computador comp) {

		try {
			if (comp instanceof Desktop)
				validaDesktop((Desktop) comp);
			else if (comp instanceof Notebook)
				validaNotebook((Notebook) comp);
			return true;

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		} catch (InvalidCustoBaseException e) {
			System.out.println(e.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}




	 public static void validaDesktop(Desktop pc) throws InvalidCustoBaseException {
	        
		Util.validaModelo(pc);
		Util.validaCustoBase(pc);
		Util.validaQuantidadeComponentes(pc);

		ComputadorRepository.saveDesktop(pc);
	 }

	public static void validaNotebook(Notebook note) throws InvalidCustoBaseException {

        Util.validaNumeroSerie(note);
    	Util.validaPeso(note);

        ComputadorRepository.saveNotebook(note);
    }
}
