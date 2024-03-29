import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.Collections;

public class Comandos {
    ArrayList<String> agenda;
    BufferedReader in = null;
    BufferedWriter out = null;
    Scanner scanner = null;

    public Comandos() {
        agenda = new ArrayList<String>();
    }

    public void addContato(String name, String phone) throws IOException {
        agenda.add(name.toUpperCase() + "," + phone);
        Collections.sort(agenda);
        save(agenda);
    }

    public void delContatoFone(String phone) throws IOException {
        String temp = "";
        String[] splited = new String[agenda.size()];
        for (int i = 0; i < agenda.size(); i++) {
            temp = agenda.get(i);
            splited = temp.split(",");
            if (phone.equals(splited[1])) {
                agenda.remove(i);
                save(agenda);
            }
        }
    }

    public void delContatoNome(String name) throws IOException {
        String temp = "";
        String[] splited = new String[agenda.size()];
        for (int i = 0; i < agenda.size(); i++) {
            temp = agenda.get(i);
            splited = temp.split(",");
            if (name.toUpperCase().equals(splited[0].toUpperCase())) {
                agenda.remove(i);
                save(agenda);
            }
        }
    }

    public void listarContato() {
        for(String s : agenda){
            System.out.println(s);
        }
    }

    public void pesquisarContato(String nome) throws IOException {
        String[] nom = new String[2];
        for(String name : agenda){
            nom = name.split(",");
            if(name.contains(nome.toUpperCase())){
                System.out.println(nom[0]);
            }
        } 
    }

    public void pesquisarTelefone(String fone) throws IOException {
        String[] fon = new String[2];
        for(String phone : agenda){
            fon = phone.split(",");
            if(phone.contains(fone.toUpperCase())){
                System.out.println(fon[1]);
            }
        } 
    }

    public void save(ArrayList<String> lista) throws IOException {
        try {
            out = new BufferedWriter(new FileWriter("Agenda.txt"));

            for (int i = 0; i < agenda.size(); i++) {
                out.write(agenda.get(i).toString());
                out.write("\n");
            }

        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public void load(ArrayList<String> lista) throws IOException {
        try {
            in = new BufferedReader(new FileReader("Agenda.txt"));
            String line = in.readLine();
            while (line != null) {
                agenda.add(line);
                line = in.readLine();
            }
        } finally {
            in.close();
        }
    }
}