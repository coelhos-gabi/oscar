package org.example.mappers;

import org.example.model.DadosOscar;

import java.util.function.Function;

public class DadosOscarMapper implements Function<String, DadosOscar> {
    @Override
    public DadosOscar apply(String s) {
        var dadosLinha = s.split(";");
        int index = Integer.parseInt(dadosLinha[0]);
        String stringYear = dadosLinha[1];
        int year = Integer.parseInt(stringYear);
        int age = Integer.parseInt(dadosLinha[2]);
        String name = dadosLinha[3];
        String movie = dadosLinha[4];
        return new DadosOscar(index,year,age,name,movie);
    }
}
