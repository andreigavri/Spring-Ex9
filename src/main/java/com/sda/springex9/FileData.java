package com.sda.springex9;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;
@Data
@Entity(name="Files_data")

public class FileData {
    private String fileName;
    private String extension;
    private Integer sizeInKb;
    private String content;


    @Id
    @GeneratedValue //should always look for the annotation provided by Java ( in this specific case Jakarta)
    private UUID id;


}
