import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Agenda {

    public static void main(String[] args) throws IOException {
        ArrayList<String> agenda = new ArrayList<String>();
        Comandos cmd = new Comandos();
        Scanner scanner = new Scanner(System.in);
        String nome = " ";
        String tel = " ";
        cmd.load(agenda);
        int num = 0;
        while (num != 7) {
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Deletar Telefone");
            System.out.println("3 - Deletar Contato");
            System.out.println("4 - Pesquisar Contatos");
            System.out.println("5 - Pesquisar Telefone");
            System.out.println("6 - Listar Contatos");
            System.out.println("7 - Encerrar");
            System.out.print("Selecione a Opcao: ");
            num = scanner.nextInt();
            switch (num) {
            case 1:
                adicionar();
                break;
            case 2:
                delFone();
                break;
            case 3:
                delNome();
                break;
            case 4:
                pesqCont();
                break;
            case 5:
                pesqTel();
                break;
            case 6:
                listar();
                break;
            case 7:
                System.out.println("Encerrado");
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
            }
        }
    }

    private static void listar() throws IOException {
        ArrayList<String> agenda = new ArrayList<String>();
        Comandos cmd = new Comandos();
        cmd.load(agenda);
        cmd.listarContato();
    }

    private static void delNome() throws IOException {
        ArrayList<String> agenda = new ArrayList<String>();
        Comandos cmd = new Comandos();
        cmd.load(agenda);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        cmd.delContatoNome(nome);
    }

    private static void delFone() throws IOException {
        ArrayList<String> agenda = new ArrayList<String>();
        Comandos cmd = new Comandos();
        cmd.load(agenda);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Telefone: ");
        String tel = scanner.nextLine();
        cmd.delContatoFone(tel);
    }

    public static void adicionar() throws IOException {
        ArrayList<String> agenda = new ArrayList<String>();
        Comandos cmd = new Comandos();
        cmd.load(agenda);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String tel = scanner.nextLine();
        cmd.addContato(nome, tel);
    }

    public static void pesqCont() throws IOException {
        ArrayList<String> agenda = new ArrayList<String>();
        Comandos cmd = new Comandos();
        cmd.load(agenda);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String pesqNome = scanner.nextLine();
        cmd.pesquisarContato(pesqNome);
    }

    public static void pesqTel() throws IOException {
        ArrayList<String> agenda = new ArrayList<String>();
        Comandos cmd = new Comandos();
        cmd.load(agenda);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Telefone: ");
        String pesqTel = scanner.nextLine();
        cmd.pesquisarTelefone(pesqTel);
    }
}