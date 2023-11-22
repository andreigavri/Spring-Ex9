package com.sda.springex9;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;


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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getFileById(@PathVariable UUID id,@RequestBody FileData fileData){
        FileData object= fileDataRepository.findById(id).orElseThrow(()-> new RuntimeException("File not found"));
        object.setFileName(fileData.getFileName());
        object.setExtension(fileData.getExtension());
        object.setSizeInKb(fileData.getSizeInKb());
        object.setContent(fileData.getContent());
        fileDataRepository.save(object);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFile(@PathVariable UUID id){
        FileData object= fileDataRepository.findById(id).orElseThrow(()-> new RuntimeException("File not found"));
        fileDataRepository.deleteById(id);
    }
}



