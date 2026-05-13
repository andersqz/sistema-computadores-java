package model;

public abstract class Computador {

    private String modelo;
    private Integer numeroSerie;
    private Double custoBase;
    private Double custoAdicional;

    public Computador() {}

    // Constructor
    public Computador(String modelo, Integer numeroSerie, Double custoBase) {
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.custoBase = custoBase;
        this.custoAdicional = 0.0;
    }

    public Computador(Double custoAdicional) {
        this.custoAdicional = custoAdicional;
    }

    // getters
    public String getModelo() { return this.modelo; }
    public Integer getNumeroSerie() { return this.numeroSerie; }
    public Double getCustoBase() { return this.custoBase; }
    public Double getCustoAdicional() { return this.custoAdicional; }


    // setters
    public void setModelo(String value) {
        if (value == null || value.isBlank())
            throw new IllegalArgumentException("Modelo não pode ser vazio.");
        this.modelo = value;
    }

    public void setNumeroSerie(Integer value) {
        String s = String.valueOf(value);
        if (s.length() > 9)
            throw new IllegalArgumentException("O número de série tem 9 digitos.");
        this.numeroSerie = value;
    }

    public void setCustoBase(Double value) {
        if (value <= 0.0 || value > 3500.00)
            throw new IllegalArgumentException("O valor do custo base deve seguir as diretrizes da empresa de até $3500.00 reais.");
        this.custoBase = value;
    }

    public void setCustoAdicional(Double value) {
        if (value <= 0.0)
            throw new IllegalArgumentException("O valor do item de custo adicional deve ser maior que 0");
        this.custoAdicional = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computador{");
        sb.append("modelo=").append(modelo);
        sb.append(", numeroSerie=").append(numeroSerie);
        sb.append(", custoBase=").append(custoBase);
        sb.append(", custoAdicional=").append(custoAdicional);
        sb.append('}');
        return sb.toString();
    }

    public abstract void valida();
}
