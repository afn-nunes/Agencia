package programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classes.Carro;
import excecoes.PlacaInvalidaException;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            List<Carro> carros = new ArrayList<>();
            try{
                carros.add(new Carro("KZO0394", "Citroen C3", "Preto"));
                carros.add(new Carro("KMZ0394", "HB20", "Azul"));
                carros.add(new Carro("GYJ0799", "Audi", "Prata"));
                carros.add(new Carro("KNO2601", "Fusca", "Amarelo"));
                carros.add(new Carro("QLW0542", "Citroen C3", "Preto"));
            }catch(PlacaInvalidaException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Informe a placa do carro");
            String placa = sc.nextLine();

            System.out.println(pesquisarPlaca(carros, placa));
        }finally{
            sc.close();
        }    
    }

    private static String pesquisarPlaca(List<Carro> carros, String placa){
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)){                
                return carro.toString();
            }
        }
        return "";
    }

}
