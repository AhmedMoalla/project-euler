package com.amoalla.euler.utils;

import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    public static String readFile(String path) {
        try (InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(path)) {
            if (is == null) throw new RuntimeException("File not found: " + path);
            return new String(is.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
