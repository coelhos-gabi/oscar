package org.example.service;

import org.example.model.DadosOscar;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OscarService {

    private final List<DadosOscar> oscarFile;

    public OscarService(List<DadosOscar> oscarFile) {
        this.oscarFile = oscarFile;
    }

    public void youngestAndMostAwarded(){
        oscarFile.stream()
                .min(Comparator.comparing(DadosOscar::getAge))
                .ifPresent(ator ->
                        System.out.printf("Artista mais jovem a ganhar " +
                                "um Oscar foi %s com %d anos.%n",ator.getName(),ator.getAge()));
    }

    public void mostAwardedArtist(){
        oscarFile.stream()
                .collect(Collectors.groupingBy(DadosOscar::getName,Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(ator ->
                        System.out.printf
                                ("Artista com maior quantidade de prêmios é %s com %d prêmios%n",
                                        ator.getKey(),ator.getValue()));

    }

    public void mostAwardedArtistBetween18and24Years(){
        System.out.println("\nArtistas com idades entre 18 e 24 anos que receberam prêmios:");
        oscarFile.stream()
                .filter(ator -> ator.getAge() >= 18 && ator.getAge() <= 24)
                .collect(Collectors.groupingBy(DadosOscar::getName, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key
                        + " com " + value
                        + (value > 1 ? " prêmios" : " prêmio")));
    }


}
