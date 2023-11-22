package com.sda.springex9.services;

import com.sda.springex9.exceptions.SDAJava60Exception;
import com.sda.springex9.model.FileData;
import com.sda.springex9.model.FileDataResult;
import com.sda.springex9.repositories.FileDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileDataService {
    private final FileDataRepository fileDataRepository;

    public FileDataResult getAllFiles() {
        FileDataResult result = new FileDataResult();
        result.setValues(new ArrayList<>((Collection) fileDataRepository.findAll()));
        return result;
    }

    public FileData findFileByID(UUID id) {
        return fileDataRepository.findById(id).orElseThrow(()-> new SDAJava60Exception("File not found for file:"+ id));
    }

    public FileData createFile(FileData fileData) {
        return fileDataRepository.save(fileData);
    }

    public void updateFile(UUID id, FileData fileData) {
        FileData object= findFileByID(id);
        object.setFileName(fileData.getFileName());
        object.setExtension(fileData.getExtension());
        object.setSizeInKb(fileData.getSizeInKb());
        object.setContent(fileData.getContent());
        fileDataRepository.save(object);
    }

    public void deleteFileById(UUID id) {
        findFileByID(id);
        fileDataRepository.deleteById(id);
    }
}
