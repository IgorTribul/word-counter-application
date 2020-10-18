package ru.geekbrains.word.counter.application.service;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ResultAggregator {

    private FileProcessor fileProcessor;

    public ResultAggregator(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    public HashMap<String, Integer> wordCountResult (String fileName) throws Exception {

        HashMap<String, Integer> sortedMap = fileProcessor.readBookInLines(fileName);
        sortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        return sortedMap;
    }
}
