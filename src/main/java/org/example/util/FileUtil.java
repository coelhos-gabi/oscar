package org.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileUtil<T> {
    private String fileName;

    public FileUtil(String fileName) {
        this.fileName = fileName;
    }

    public List<T> readFile(Function<String, T> mapper) throws IOException{
        InputStream file = this.getClass().getClassLoader().getResourceAsStream(this.fileName);

        if(file == null){
            throw new IllegalArgumentException("Arquivo não encontrado");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))){
            return reader.lines()
                    .skip(1)
                    .map(mapper)
                    .collect(Collectors.toList());
        }
    }
}
