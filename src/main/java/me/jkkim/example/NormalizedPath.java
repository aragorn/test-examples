package me.jkkim.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

class NormalizedPath {

    static String solve0(String path) {
        Path input = Paths.get(path);
        return input.normalize().toString();
    }

    static String solve(String path) {
        boolean isAbsolute = false;
        Stack<String> pathStack = new Stack<>();

        if (path.isEmpty()) return path;
        if (path.charAt(0) == '/') isAbsolute = true;

        for (String p : path.split("/")) {
            if ("..".equals(p)) {
                if (pathStack.isEmpty()) {
                    if (isAbsolute) {
                        ; // continue;
                    } else {
                        pathStack.push(p);
                    }
                } else if ("..".equals(pathStack.peek())) {
                    pathStack.push(p);
                } else {
                    pathStack.pop();
                }
            } else if (p.equals(".") || p.isEmpty()) {
                ; // continue;
            } else {
                pathStack.push(p);
            }
        }

        return (isAbsolute ? "/" : "") + String.join("/", pathStack);
    }
}
