package classes;

import excecoes.PlacaInvalidaException;

public class Carro {
    private String placa;
    private String modelo;
    private String cor;

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) throws PlacaInvalidaException{
        if ( (placa == null) || (placa.equals(""))) 
            throw new PlacaInvalidaException("É necessário informar uma placa");

        if ( placa.length() != 7) 
            throw new PlacaInvalidaException("A placa tem que ter 7 digitos");

        if (placa.matches("A-Z{3}\\d{4}"))
          throw new PlacaInvalidaException("A placa tem que ter 3 letras e quatro dígitos");

        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public Carro(String placa, String modelo, String cor) throws PlacaInvalidaException {
        setPlaca(placa);
        this.modelo = modelo;
        this.cor = cor;
    }

    @Override
    public String toString(){
        return String.format("Modelo: %s - Cor: %s", getModelo(), getCor());
    }
    
}