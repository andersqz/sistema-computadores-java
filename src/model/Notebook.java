package model;
import util.Util;

public class Notebook extends Computador {

    private Double peso;
    
    public Notebook() {}

    public Notebook(String modelo, Integer numeroSerie, Double custoBase, Double peso) {
        super(modelo, numeroSerie, custoBase);
        this.peso = peso;
    }
    
    public Notebook(Double custoAdicional) {
    	super(custoAdicional);
    }

    public Double getPeso() { return peso; }


    @Override 
    public String toString() {

        return "Tipo: Notebook | Modelo: " + getModelo() + 
        " | Numero de serie: " + getNumeroSerie() + 
        " | Custo base: " + getCustoBase() + 
        " | Peso: " + getPeso() + 
        " | Custo Adicional: " + getCustoAdicional();
    }

    @Override
    public void valida() {
			
        Util.validaModelo(this);
        Util.validaCustoBase(this);
        Util.validaNumeroSerie(this);
        Util.validaPeso(this);
    }
}
