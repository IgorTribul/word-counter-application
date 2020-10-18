package ru.geekbrains.word.counter.application.controller;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.word.counter.application.service.ResultAggregator;

import java.util.HashMap;

@RestController
public class WordController {

    private final ResultAggregator resultAggregator;

    public WordController(ResultAggregator resultAggregator) {
        this.resultAggregator = resultAggregator;
    }

    @PostMapping("/book")
    public HashMap<String, Integer> countingWordsInBook(@RequestBody String fileName) throws Exception {

        if (fileName.equals("dune")) {
            return resultAggregator.wordCountResult("src/main/resources/dune.txt");
        }
        return  null;
    }
}



