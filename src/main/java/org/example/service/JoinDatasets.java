package org.example.service;

import java.io.*;

public class JoinDatasets {
    public static void join() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/home/gabrielacoelho/Área de Trabalho/ProjetosJava/oscar/src/main/resources/oscar_age_female.csv"));
        BufferedReader reader2 = new BufferedReader(new FileReader("/home/gabrielacoelho/Área de Trabalho/ProjetosJava/oscar/src/main/resources/oscar_age_male.csv"));

        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/gabrielacoelho/Área de Trabalho/ProjetosJava/oscar/src/main/resources/oscar_age.csv"));
        String linha = reader.readLine();
        while (linha != null){
            writer.write((linha+"\n").replaceAll("; ",";"));
            linha = reader.readLine();
        }
        reader.close();
        linha = reader2.readLine();
        linha = reader2.readLine();
        while(linha != null){
            writer.write((linha + "\n").replaceAll("; ",";"));
            linha = reader2.readLine();
        }
        reader2.close();
        writer.close();
    }
}
