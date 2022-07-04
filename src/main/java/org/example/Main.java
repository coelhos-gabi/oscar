package org.example;


import org.example.mappers.DadosOscarMapper;
import org.example.model.DadosOscar;
import org.example.service.JoinDatasets;
import org.example.util.FileUtil;

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        // exercicios

        // 3 - Transformar os dois arquivos em apenas 1 stream
        //JoinDatasets.join();

        var fileUtil = new FileUtil<DadosOscar>("oscar_age.csv");
        var oscarFile = fileUtil.readFile(new DadosOscarMapper());

        // 4 - Ator mais jovem a ser premiado
        oscarFile.stream()
                .min(Comparator.comparing(DadosOscar::getAge))
                .ifPresent(ator ->
                        System.out.printf("O ator mais jovem a ganhar um Oscar é: %s %n",ator.getName()));

        // 5 - Ator com maior qtd de prêmios
        oscarFile.stream()
                .collect(Collectors.groupingBy(DadosOscar::getName,Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(ator ->
                        System.out.printf
                                ("O ator maior quantidade de prêmios é %s com %d prêmios%n",ator.getKey(),ator.getValue()));


    }
}