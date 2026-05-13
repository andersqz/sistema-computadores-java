package service;

import repository.ComputadorRepository;
import model.Computador;

public class ComputadorService {
	
	public static void validaDados(Computador comp) {
			comp.valida();
			ComputadorRepository.save(comp);
	}
}
