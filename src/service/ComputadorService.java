package service;

import model.Desktop;
import model.Notebook;
import repository.ComputadorRepository;
import util.Util;
import model.Computador;

public class ComputadorService {
	

	public static void validaDados(Computador comp) {

		if (comp instanceof Desktop) {

			Util.validaDesktop((Desktop) comp);
			ComputadorRepository.saveDesktop((Desktop) comp);
		}
		else if (comp instanceof Notebook) {
			
			Util.validaNotebook((Notebook) comp);
			ComputadorRepository.saveNotebook((Notebook) comp);
		}
	}
}
