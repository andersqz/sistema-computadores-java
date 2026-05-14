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
    
    /**
     * método 'principal'. Ele inicia o sistema chamado os métodos necessárias
     */
    public void iniciar() {
        char opcao;
        do {
            exibeMenu();
            opcao = sc.next().charAt(0);
            sc.nextLine();

            switch (opcao) {

                case '1': cadastraDesktop(); break;
                case '2': cadastraNotebook(); break;
                case '3': ComputadorRepository.list(); break;
                case '4': System.out.println("Saindo ..."); break;
                default: System.out.println("Entrada invalida."); break;
            }

        } while (opcao != '4');
    }

    /**
     * método que exibe o menu principal na tela para o usuário decidir o que fazer
     */
    private void exibeMenu() {
            System.out.println("\nSISTEMA");
            System.out.println("1 - CADASTRAR PC DE MESA");
            System.out.println("2 - CADASTRAR NOTEBOOK");
            System.out.println("3 - LISTA DE COMPUTADORES");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
    }

    /**
     * método que solicita os dados do DESKTOP para o usuário e retorna um objeto Desktop com os dados informados por ele
     * @return obj Desktop
     */
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

    /**
     * método que valida os dados informados pelo usuario do objeto Desktop, e cadastra o objeto na lista e no arquivo CSV, 
     * caso encontre algum erro de entrada do usuário, lança excessão 
     */
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
            System.out.println("Entrada inválida! Digite um número.");
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }

    /**
     * método que solicita os dados para preenchimento do usuario do objeto Notebook, retorna um objeto Notebook
     * @return Obj Notebook
     */
    private Notebook leNotebook() {
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Numero de série (9 digitos): ");
        Integer numeroSerie = sc.nextInt();
        sc.nextLine();

        System.out.print("Custo base (até $3500.00): ");
        Double custoBase = sc.nextDouble();
        sc.nextLine();

        System.out.print("Peso em kg: ");
        Double peso = sc.nextDouble();
        sc.nextLine();

        return new Notebook(modelo, numeroSerie, custoBase, peso);
    }

    /**
     * método que valida os dados informados pelo usuario do objeto Notebook e se tudo certo, cadastra o objeto na lista e no arquivo CSV,
     * caso de algum erro de input do usuário, lança excessão
     */
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
            System.out.println("Entrada inválida! Digite um número.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
