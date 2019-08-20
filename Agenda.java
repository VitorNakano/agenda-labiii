import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Agenda{
    
    public static void main(String[] args) throws IOException{
        ArrayList<String> agenda = new ArrayList<String>();
        Comandos cmd = new Comandos();
        Scanner scanner = new Scanner(System.in);
        cmd.load(agenda);
        int num = 0;
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Deletar Telefone");
            System.out.println("3 - Deletar Contato");
            System.out.println("4 - Listar Contatos");
            System.out.println("5 - Encerrar");
        while(num != 5){
            int opcao = scanner.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Telefone: ");
                    String tel = scanner.nextLine();
                    cmd.addContato(nome, tel);
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println(cmd.listarContato());
                    break;
                case 5:
                    System.out.println("Encerrado");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
    }
}