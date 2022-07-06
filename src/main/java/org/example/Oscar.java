package org.example;

import org.example.mappers.DadosOscarMapper;
import org.example.model.DadosOscar;
import org.example.service.OscarService;
import org.example.util.StreamUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Oscar {
    public static void main(String[] args) throws IOException {
        Path dir1 = Paths.get("src/main/resources/oscar_age_female.csv");
        Path dir2 = Paths.get("src/main/resources/oscar_age_male.csv");

        var femaleOscar = Files.lines(dir1);
        var maleOscar = Files.lines(dir2).skip(1);
        var file = Stream.concat(femaleOscar, maleOscar);

        var fileUtil = new StreamUtil<DadosOscar>(file);
        var oscarFile = fileUtil.readStream(new DadosOscarMapper());

        var oscarService = new OscarService(oscarFile);

        oscarService.youngestAndMostAwarded();
        oscarService.mostAwardedArtist();
        oscarService.mostAwardedArtistBetween18and24Years();
    }
}
