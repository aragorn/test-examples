package me.jkkim.example;

import java.nio.file.Path;
import java.nio.file.Paths;

class NormalizedPath {

    static String solve(String path) {
        Path input = Paths.get(path);
        return input.normalize().toString();
    }
}
