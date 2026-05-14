package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.InvalidCustoBaseException;
import model.Desktop;
import model.Notebook;
import repository.ComputadorRepository;
import service.ComputadorService;

public class ComputadorController {

    private Scanner sc = new Scanner(System.in);
    
    public void iniciar() {
        char opcao;
        do {
            exibeMenu();
            opcao = sc.next().charAt(0);

            switch (opcao) {

                case '1': cadastraDesktop(); break;
                case '2': cadastraNotebook(); break;
                case '3': ComputadorRepository.list(); break;
                case '4': System.out.println("Saindo ..."); break;
                default: System.out.println("Entrada invalida."); break;
            }

        } while (opcao != '4');
    }

    private void exibeMenu() {
            System.out.println("\nSISTEMA");
            System.out.println("1 - CADASTRAR PC DE MESA");
            System.out.println("2 - CADASTRAR NOTEBOOK");
            System.out.println("3 - LISTA DE COMPUTADORES");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
    }

    private Desktop leDesktop() {
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Numero de série (9 digitos): ");
        Integer numeroSerie = sc.nextInt();
        sc.nextLine();

        System.out.print("Custo base (até $3500.00): ");
        Double custoBase = sc.nextDouble();
        sc.nextLine();
        
        System.out.print("Numero de componentes do PC:");
        Integer numeroComponentes = sc.nextInt();
        sc.nextLine();

        return new Desktop(modelo, numeroSerie, custoBase, numeroComponentes);
    }

    private void cadastraDesktop() {

        try {
            Desktop pc = leDesktop();
            ComputadorService.validaDados(pc);
            System.out.println("Desktop cadastrado com sucesso!");

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

    private Notebook leNotebook() {
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

        return new Notebook(modelo, numeroSerie, custoBase, peso);
    }

    private void cadastraNotebook() {

        try {
        
            Notebook note = leNotebook();
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
