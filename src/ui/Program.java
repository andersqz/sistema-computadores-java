package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.InvalidCustoBaseException;
import model.Notebook;
import repository.ComputadorRepository;
import model.Desktop;
import service.ComputadorService;

public class Program {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        char opcao;

        do { 
            

            opcao = sc.next().charAt(0);
            sc.nextLine();

            switch (opcao) {

                case '1':
                	cadastraDesktop();
                    break;

                case '2':
                    cadastraNotebook();
                    break;

                case '3':
                    ComputadorRepository.list();
                    break;

                case '4':
                    System.out.println("saindo ...");
                    break;

                default:
                    System.out.println("Entrada invalida...");
                    break;
            }
        } while (opcao != '4');
        sc.close();
    }


    public static void cadastraDesktop() {

        try {
            System.out.println("CADASTRAR DESKTOP");
            
            
            
            Desktop pc = 
            
                 
            
            
    
    }


    public static void cadastraNotebook() {
        try {
            System.out.println("CADASTRAR NOTEBOOK");

            System.out.print("Modelo: ");
            String modelo = sc.nextLine();

            System.out.print("Numero de série (9 digitos): ");
            Integer numeroSerie = sc.nextInt();
            sc.nextLine();

            System.out.print("Custo base (até $3500.00): ");
            Double custoBase = sc.nextDouble();
            sc.nextLine();

            System.out.println("Peso em kg: ");
            Double peso = sc.nextDouble();
            sc.nextLine();

            Notebook note = new Notebook(modelo, numeroSerie, custoBase, peso);

            ComputadorService.validaDados(note);
            System.out.println("Notebook cadastrado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            
        } catch (InvalidCustoBaseException e) {
            System.out.println(e.getMessage());
            
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println(e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
