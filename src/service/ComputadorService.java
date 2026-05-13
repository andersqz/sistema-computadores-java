package service;

import exceptions.InvalidCustoBaseException;
import model.Desktop;
import model.Notebook;
import util.Util;
import model.Computador;

public class ComputadorService {
	

	public static Boolean validaDados(Computador comp) {

		try {
			if (comp instanceof Desktop)
				Util.validaDesktop((Desktop) comp);
			else if (comp instanceof Notebook)
				Util.validaNotebook((Notebook) comp);
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
}
