package com.sda.springex9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class FileDataController {

    private final FileDataRepository fileDataRepository;

    public FileDataController(FileDataRepository fileDataRepository) {
        this.fileDataRepository = fileDataRepository;
    }


    @GetMapping("/api/files-data")
    public FileDataResult getAllFileData() {
        FileDataResult result =new FileDataResult();
        fileDataRepository.findAll().forEach((e)->result.getValues().add(e));
        return result;
    }

}



