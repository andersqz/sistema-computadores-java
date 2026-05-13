package ui;

import java.util.Scanner;

import exceptions.InvalidCustoBaseException;
import model.Notebook;
import repository.ComputadorRepository;
import model.Desktop;
import service.ComputadorService;

public class Program {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        char opcao;

        do { 
            
            System.out.println("SISTEMA");

            System.out.println("1 - CADASTRAR PC DE MESA");
            System.out.println("2 - CADASTRAR NOTEBOOK");
            System.out.println("3 - LISTA DE COMPUTADORES");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            opcao = sc.next().charAt(0);
            sc.nextLine();

            switch (opcao) {

                case '1':
                	
                	try {
	                    System.out.println("CADASTRAR DESKTOP");
	                    
	                    System.out.print("Modelo: ");
	                    String modelo = sc.nextLine();
	
	                    System.out.print("Numero de série (4 - 9 digitos): ");
	                    Integer numeroSerie = sc.nextInt();
	                    sc.nextLine();
	
	                    System.out.print("Custo base (até $3500.00): ");
	                    Double custoBase = sc.nextDouble();
	                    sc.nextLine();
	                    
	                    System.out.print("Numero de componentes do PC:");
	                    Integer numeroComponentes = sc.nextInt();
	                    sc.nextLine();
	                    
	                    Desktop pc = new Desktop(modelo, numeroSerie, custoBase, numeroComponentes);
	                    
	                    ComputadorService.validaDados(pc);     
	                    System.out.println("Desktop cadastrado com sucesso!");
	                    
                	} catch (IllegalArgumentException e) {
                		System.out.println(e.getMessage());
                		
                	} catch (InvalidCustoBaseException e) {
                    	System.out.println(e.getMessage());
                    	
                	} catch (Exception e) {
                		System.out.println(e.getMessage());
                	}                 
                    break;

                case '2':

                    try {
                        System.out.println("CADASTRAR NOTEBOOK");

                        System.out.print("Modelo: ");
                        String modelo = sc.nextLine();

                        System.out.print("Numero de série (4 - 9 digitos): ");
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
                    	
                    } catch (Exception e) {
                    	System.out.println(e.getMessage());
                    }
                    
                    break;

                case '3':
                    System.out.println("LISTAS");
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
}
