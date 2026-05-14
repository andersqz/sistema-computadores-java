package model;

import util.Util;

public class Desktop extends Computador {
	
	private Integer numeroComponentes;
	
	public Desktop() {}
	
    public Desktop(String modelo, Integer numeroSerie, Double custoBase, Integer numeroComponentes) {
        super(modelo, numeroSerie, custoBase);
        this.numeroComponentes = numeroComponentes;
    }
    
    public Desktop(Double custoAdicional) {
    	super(custoAdicional);
    }

	public Integer getNumeroComponentes() {
		return numeroComponentes;
	}

	public void setNumeroComponentes(Integer value) {
		if (value <= 0) 
			throw new IllegalArgumentException("O numero de componentes de um PC nao pode ser 0.");
		this.numeroComponentes = value;
	}

	@Override
	public String toString() {
        return "Tipo: Desktop | Modelo: " + getModelo() + 
		" | Numero de serie: " + getNumeroSerie() + 
		" | Custo base: " + getCustoBase() + 
		" | Numero componentes: " + getNumeroComponentes() + 
		" | Custo Adicional: " + getCustoAdicional();

	}
    
    @Override
	public void valida() {
	        
		Util.validaModelo(this);
		Util.validaCustoBase(this);
		Util.validaQuantidadeComponentes(this);
		Util.validaNumeroSerie(this);
	}

	@Override
	public String toCsv() {
		return "DESKTOP;" + getModelo() + ";" + getNumeroSerie() + ";" +
           getCustoBase() + ";" + getCustoAdicional() + ";" + getNumeroComponentes() + "\n";
	}
}
