package util;

import exceptions.InvalidCustoBaseException;
import model.Desktop;
import model.Notebook;
import model.Computador;

public class Util {
    
    /**
	 * método que recebe um obj Computador e valida se o modelo é diferente de null ou se modelo isBlanck()
	 * @param pc Objeto Computador que é passado por parâmetro
	 * @return retorna true se o objeto é valido e lança excessao se é invalido
	 */
	public static Boolean validaModelo(Computador pc) {
		if (pc.getModelo() == null || pc.getModelo().isBlank())
			throw new IllegalArgumentException("Modelo não pode ser vazio.");
		return true;
	}

	/**
	 * método que recebe um obj Computador e valida se o CustoBase é menor que 0.0 ou maior que 3500.0, se sim, lança excessão, se não, retorna true com o obj validado
	 * @param pc Objeto Computador que é passado por parâmetro
	 * @return retorna true se foi validado ou lança excessão se deu erro
	 */
	public static Boolean validaCustoBase(Computador pc) {
		if (pc.getCustoBase() <= 0.0 || pc.getCustoBase() > 3500.0)
			throw new InvalidCustoBaseException("Custo base deve ser maior que 0.0 e menor que 3500.0");
		return true;
	}

	/**
	 * método que recebe um Obj Desktop por parâmetro e valida se a quantidade de componentes é maior que 0, se sim, retorna true, se não, lança excessão
	 * @param pc Obj Desktop passado por parâmetro
	 * @return return true se foi validado ou lança excessão se deu erro
	 */
	public static Boolean validaQuantidadeComponentes(Desktop pc) {
		if (pc.getNumeroComponentes() <= 0)
			throw new IllegalArgumentException("O numero de componentes de um PC deve ser maior que 0.");
		return true;
	}

	/**
	 * método que recebe um Obj Computador por parâmetro e valida se o númeroSérie tem 9 digitos, se sim, retorna true, se não, lança excessão
	 * @param note Obj Computador passado por parâmetro
	 * @return retorna true se deu tudo certo, lança excessão se deu erro
	 */
	public static Boolean validaNumeroSerie(Computador note) {
		String s = String.valueOf(note.getNumeroSerie());
		if (s.length() != 9)
			throw new IllegalArgumentException("Numero de serie deve ter exatamente 9 digitos.");
		return true;
	}

	/**
	 * método que recebe um Obj Notebook por parâmetro e valida se o peso é menor ou igual a 0.0kg ou maior que 10.0kg, se sim, lança excessão, se não, retorna true
	 * @param note Obj Notebook passado por parÂmetro
	 * @return retorna true se deu tudo certo, lança excessão se deu erro
	 */
	public static Boolean validaPeso(Notebook note) {
		if (note.getPeso() <= 0.0 || note.getPeso() > 10.0)
			throw new IllegalArgumentException("Peso deve ser maior que 0kg e menor que 10kg");
		return true;
	}
    
}

