package com.kuppuch.KuppuchBot.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryController {

    public List<String> getLibrary() {
        List<String> books = new ArrayList<>();
        File folder = new File("./lib");
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                books.add(file.getName());
            }
        }
        return books;
    }
}
