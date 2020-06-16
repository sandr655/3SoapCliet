package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Read {

    static String read(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}
