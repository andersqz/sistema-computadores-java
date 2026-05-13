package util;

import exceptions.InvalidCustoBaseException;
import model.Desktop;
import model.Notebook;

public class Util {
    
    
		public static Boolean validaModelo(Desktop pc) {
			if (pc.getModelo() == null || pc.getModelo().isBlank())
	            throw new IllegalArgumentException("Modelo não pode ser vazio.");
			return true;
		}

		public static Boolean validaCustoBase(Desktop pc) {
			if (pc.getCustoBase() <= 0.0 || pc.getCustoBase() > 3500.0)
	            throw new InvalidCustoBaseException("Custo base deve ser maior que 0.0 e menor que 3500.0");
			return true;
		}

		public static Boolean validaQuantidadeComponentes(Desktop pc) {
			if (pc.getNumeroComponentes() <= 0)
	        	throw new IllegalArgumentException("O numero de componentes de um PC deve ser maior que 0.");
			return true;
		}

		 public static Boolean validaNumeroSerie(Notebook note) {
        	if (note.getModelo() == null || note.getModelo().isBlank())
            	throw new IllegalArgumentException("Modelo não pode ser vazio.");
        	return true;
    	}

    	public static Boolean validaPeso(Notebook note) {
        	if (note.getPeso() <= 0.0 || note.getPeso() > 10.0)
            	throw new IllegalArgumentException("Peso deve ser maior que 0kg e menor que 10kg");
        	return true;
    	}
    
}


class Validadores {

			public static Boolean validaModelo(Desktop pc) {
			if (pc.getModelo() == null || pc.getModelo().isBlank())
	            throw new IllegalArgumentException("Modelo não pode ser vazio.");
			return true;
		}

		public static Boolean validaCustoBase(Desktop pc) {
			if (pc.getCustoBase() <= 0.0 || pc.getCustoBase() > 3500.0)
	            throw new InvalidCustoBaseException("Custo base deve ser maior que 0.0 e menor que 3500.0");
			return true;
		}

		public static Boolean validaQuantidadeComponentes(Desktop pc) {
			if (pc.getNumeroComponentes() <= 0)
	        	throw new IllegalArgumentException("O numero de componentes de um PC deve ser maior que 0.");
			return true;
		}

		 public static Boolean validaNumeroSerie(Notebook note) {
        	if (note.getModelo() == null || note.getModelo().isBlank())
            	throw new IllegalArgumentException("Modelo não pode ser vazio.");
        	return true;
    	}

    	public static Boolean validaPeso(Notebook note) {
        	if (note.getPeso() <= 0.0 || note.getPeso() > 10.0)
            	throw new IllegalArgumentException("Peso deve ser maior que 0kg e menor que 10kg");
        	return true;
    	}
}	