package service;

import model.Desktop;
import model.Notebook;
import repository.ComputadorRepository;
import model.Computador;

public class ComputadorService {
	

	public static void validaDados(Computador comp) {

		if (comp instanceof Desktop) {

			ComputadorValidator.validaDesktop((Desktop) comp);
			ComputadorRepository.save((Desktop) comp);
		}
		else if (comp instanceof Notebook) {
			
			ComputadorValidator.validaNotebook((Notebook) comp);
			ComputadorRepository.save((Notebook) comp);
		}
	}
}
