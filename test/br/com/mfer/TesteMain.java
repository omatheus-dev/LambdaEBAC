package br.com.mfer;

import entities.Pessoa;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TesteMain {

    @Test
    public void TesteMain() throws IOException {
        File file = new File("C:\\EBAC Backend\\LambdaEBAC\\src\\in.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {

            List<Pessoa> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(", ");
                list.add(new Pessoa(fields[0], fields[1].charAt(0)));
                line = br.readLine();
            }

            List<Character> listFemininos = list.stream()
                    .map(Pessoa::getGenero)
                    .filter(genero -> genero == 'F')
                    .toList();

            Assert.assertNotEquals("M", listFemininos);
        }
    }
}
