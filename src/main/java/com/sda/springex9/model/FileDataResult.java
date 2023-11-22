package com.sda.springex9.model;

import com.sda.springex9.model.FileData;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FileDataResult {
    List<FileData> values = new ArrayList<>();
}
