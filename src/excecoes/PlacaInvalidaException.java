package excecoes;

public class PlacaInvalidaException extends Exception{

    public PlacaInvalidaException() {
        super();
    }

    public PlacaInvalidaException(String mensagem) {
        super(mensagem);
    }    
}
