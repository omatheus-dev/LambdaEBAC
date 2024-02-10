package application;

import entities.Pessoa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        File file = new File("C:\\EBAC Backend\\LambdaEBAC\\src\\in.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {

            List<Pessoa> list = new ArrayList<>();

            String line = br.readLine();
            while(line != null) {
                String[] fields = line.split(", ");
                list.add(new Pessoa(fields[0], fields[1].charAt(0)));
                line = br.readLine();
            }

            List<String> listFemininos = list.stream()
                    .filter(p -> p.getGenero() == 'F')
                    .map(Pessoa::getNome)
                    .toList();

            List<String> listMasculinos = list.stream()
                    .filter(p -> p.getGenero() == 'M')
                    .map(Pessoa::getNome)
                    .toList();

            System.out.println("Lista com todos os nomes:");
            for (Pessoa p : list) {
                System.out.println(p.getNome());
            }

            System.out.println("\nLista com todos os nomes femininos:");
            listFemininos.forEach(System.out::println);

            System.out.println("\nLista com todos os nomes masculinos:");
            listMasculinos.forEach(System.out::println);
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}
