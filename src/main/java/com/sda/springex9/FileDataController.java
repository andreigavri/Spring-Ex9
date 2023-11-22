package com.sda.springex9;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/files-data/")
public class FileDataController {

    private final FileDataRepository fileDataRepository;

    public FileDataController(FileDataRepository fileDataRepository) {
        this.fileDataRepository = fileDataRepository;
    }


    @GetMapping
    public FileDataResult getAllFileData() {
        FileDataResult result =new FileDataResult();
        fileDataRepository.findAll().forEach((e)->result.getValues().add(e));
        return result;
    }

    @GetMapping("/{id}")
    public FileData getFileById(@PathVariable UUID id){
        return fileDataRepository.findById(id).orElseThrow(()-> new RuntimeException("File not found"));
    }

    @PostMapping
    public ResponseEntity<FileData> createFile(@RequestBody FileData fileData) throws URISyntaxException {
        FileData result = fileDataRepository.save(fileData);
        URI location= new URI("/api/files-data/"+result.getId());
        return ResponseEntity.created(location).build();
    }
}



