import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.Collections;

public class Comandos {
    ArrayList<String> agenda;
    BufferedReader in = null;
    BufferedWriter out = null;
    Scanner scanner = null;

    public Comandos(){
        agenda = new ArrayList<String>();
    }

    public void addContato(String name, String phone) throws IOException {
        agenda.add(name + ", " + phone);
        Collections.sort(agenda);
        save(agenda);
    }

    public void delContatoFone(String phone) {

    }

    public static void delContatoNome(String name) {

    }

    public String listarContato() {
        String temp = "";
        for (int i = 0; i < agenda.size(); i++) {
            temp += agenda.get(i) + "\n";
        }
        return temp;
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

        public void load(ArrayList<String> lista) throws IOException{
            try{
                in = new BufferedReader(new FileReader("Agenda.txt"));
                String line = in.readLine();
                while(line != null){
                    agenda.add(line);
                    line = in.readLine();
                }
            } finally {
                in.close();
            }
        }
}