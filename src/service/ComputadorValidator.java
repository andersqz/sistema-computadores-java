package service;

import exceptions.InvalidCustoBaseException;
import model.Desktop;
import model.Notebook;
import util.Util;

public class ComputadorValidator {
    
    public static void validaDesktop(Desktop pc) throws InvalidCustoBaseException {
	        
			Util.validaModelo(pc);
			Util.validaCustoBase(pc);
			Util.validaQuantidadeComponentes(pc);
		}

	public static void validaNotebook(Notebook note) throws InvalidCustoBaseException {
			
			Util.validaModelo(note);
			Util.validaCustoBase(note);
        	Util.validaNumeroSerie(note);
    		Util.validaPeso(note);
    }
}
