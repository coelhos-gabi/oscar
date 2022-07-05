package org.example;

import org.example.mappers.DadosOscarMapper;
import org.example.model.DadosOscar;
import org.example.service.JoinDatasetsNIO;
import org.example.service.OscarService;
import org.example.util.FileUtil;

import java.io.IOException;

public class Oscar {
    public static void main(String[] args) throws IOException {

        //JoinDatasetsNIO.join();

        var fileUtil = new FileUtil<DadosOscar>("oscar_age_file.csv");
        var oscarFile = fileUtil.readFile(new DadosOscarMapper());

        var oscarService = new OscarService(oscarFile);

        oscarService.youngestAndMostAwarded();
        oscarService.mostAwardedArtist();
        oscarService.mostAwardedArtistBetween18and24Years();
    }
}
