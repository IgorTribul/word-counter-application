package ru.geekbrains.word.counter.application.service;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WordCounter {


    public HashMap<String, Integer> getMapWords(String line) {

        HashMap<String, Integer> mapWords = new HashMap<>();

        List<String> stringList = new ArrayList<>();
        stringList = Stream.of(line.toLowerCase().split("\\W+")).collect(Collectors.toList());
        for (String s : stringList) {
            if (mapWords.containsKey(s)) {
                mapWords.put(s, mapWords.get(s) + 1);
            } else {
                mapWords.put(s, 1);
            }
        }
        return mapWords;
    }
}
