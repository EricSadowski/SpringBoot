package com.eric.recordStore.service;

import java.util.List;

import com.eric.recordStore.entity.Record;



public interface RecordService {

    List<Record> findAll();

    Record findById(int theId);

    void save(Record theRecord);

    void deleteById(int theId);

}
