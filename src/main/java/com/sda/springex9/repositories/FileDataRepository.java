package com.sda.springex9.repositories;

import com.sda.springex9.model.FileData;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FileDataRepository extends CrudRepository<FileData, UUID> {


}


