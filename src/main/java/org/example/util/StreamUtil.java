package org.example.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtil<T> {
    private Stream<String> streamString;

    public StreamUtil(Stream<String> streamString) {
        this.streamString = streamString;
    }

    public List<T> readStream(Function<String, T> mapper) {
        return streamString.skip(1)
                .map(mapper)
                .collect(Collectors.toList());
    }
}
