package org.example.service;



import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoinDatasetsNIO {
    public static void join() throws IOException {
        Path dir1 = Paths.get("src/main/resources/oscar_age_female.csv");
        Path dir2 = Paths.get("src/main/resources/oscar_age_male.csv");

        var femaleOscar = Files.lines(dir1);
        var maleOscar = Files.lines(dir2).skip(1);
        var file = Stream.concat(femaleOscar, maleOscar);

        Path path = Paths.get("src/main/resources/oscar_age_file.csv");
        List<String> lines = file.collect(Collectors.toList());
        try{
            Files.write(path,lines, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
