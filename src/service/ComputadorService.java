package service;

import repository.ComputadorRepository;
import model.Computador;

public class ComputadorService {
	
	/**
	 * método que recebe como parâmetro um objeto do tipo Cmputador e chama o método valida de cada Entidade
	 * o método valida() verifica se os dados estão corretos, se sim, é chamado o método save() do repository
	 * @param comp
	 */
	public static void validaDados(Computador comp) {
		comp.valida();
		ComputadorRepository.save(comp);
	}
}
