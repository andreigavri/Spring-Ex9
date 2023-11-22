package com.sda.springex9.controlers;

import com.sda.springex9.exceptions.SDAJava60Exception;
import com.sda.springex9.repositories.FileDataRepository;
import com.sda.springex9.model.FileDataResult;
import com.sda.springex9.model.FileData;
import com.sda.springex9.services.FileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;


import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files-data/")
public class FileDataController {

   private final FileDataService fileDataService;


    @GetMapping
    public FileDataResult getAllFileData() {
       return  fileDataService.getAllFiles();
    }

    @GetMapping("/{id}")
    public FileData getFileById(@PathVariable UUID id){
        return fileDataService.findFileByID(id);
    }

    @PostMapping
    public ResponseEntity<FileData> createFile(@RequestBody FileData fileData) throws URISyntaxException {
        FileData result = fileDataService.createFile(fileData);
        URI location= new URI("/api/files-data/"+result.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getFileById(@PathVariable UUID id,@RequestBody FileData fileData){
        fileDataService.updateFile(id,fileData);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFile(@PathVariable UUID id){
        fileDataService.deleteFileById(id);
    }
    @ExceptionHandler(SDAJava60Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlingException(SDAJava60Exception exception){
        return exception.getMessage();
    }
}



