package ru.geekbrains.word.counter.application.service;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;


@Service
public class FileProcessor {

    private final WordCounter wordCounter;

    public FileProcessor(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    public HashMap<String, Integer> readBookInLines(String fileName) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/dune.txt"))) {
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("\n");
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
            return wordCounter.getMapWords(stringBuilder.toString());
        }
    }
}
