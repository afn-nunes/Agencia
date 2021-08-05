package programa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classes.Carro;
import excecoes.PlacaInvalidaException;

public class App2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        try{

            List<Carro> carros = new ArrayList<>();            
            int opcao;

            do {
                System.out.println("Informe a opção desejada\n");
                System.out.println("1 - Cadastrar um carro");
                System.out.println("2 - Localizar um carro");
                System.out.println("3 - Listar todos os carros");
                System.out.println("0 - sair");
                
                opcao = sc.nextInt();
                sc.nextLine();
    
                if(opcao  == 1){
                    System.out.println("Informe a placa do carro");
                    String placa = sc.nextLine();

                    System.out.println("Informe o modelo do carro");
                    String modelo = sc.nextLine();

                    System.out.println("Informe a cor do carro");
                    String cor = sc.nextLine();
                    
                    try{
                        Carro carro = new Carro(placa, modelo, cor);
                        System.out.println(carro);
                        carros.add(carro);
                    }catch(PlacaInvalidaException e){
                        e.getMessage();
                    }

                    voltarMenu(sc);
                }  
                else if( opcao == 2){
                    System.out.println("Informe a placa do veículo a ser pesquisada");
                    String placa = sc.nextLine();
                    boolean carroEncontrado = false;

                    for (Carro carro : carros) {
                        if (carro.getPlaca().equals(placa)){
                            System.out.println(carro);
                            carroEncontrado = true;
                            break;
                        }
                    }

                    if (!carroEncontrado){
                        System.out.println("Carro não encontrado");                        
                    }

                    sc.nextLine();
                    voltarMenu(sc);
                } else if(opcao == 3) {
                    for (Carro carro : carros) {
                        System.out.println(carro);
                    }
                    sc.nextLine();
                    voltarMenu(sc);
                }
            } while (opcao != 0);
            System.out.println("Fim do programa");           

        }finally{
            sc.close();
        }         
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}
