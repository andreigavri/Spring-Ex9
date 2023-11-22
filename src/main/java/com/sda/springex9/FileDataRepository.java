package com.sda.springex9;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FileDataRepository extends CrudRepository<FileData, UUID> {


}


