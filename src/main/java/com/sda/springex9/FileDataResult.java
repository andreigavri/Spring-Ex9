package com.sda.springex9;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FileDataResult {
    List<FileData> values = new ArrayList<>();
}
