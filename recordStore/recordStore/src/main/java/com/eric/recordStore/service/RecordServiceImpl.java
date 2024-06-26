package com.eric.recordStore.service;


import java.util.List;
import java.util.Optional;

import com.eric.recordStore.dao.RecordRepository;
import com.eric.recordStore.entity.Record;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecordServiceImpl implements RecordService {

    private RecordRepository recordRepository;

    @Autowired
    public RecordServiceImpl(RecordRepository theRecordRepository) {
        recordRepository = theRecordRepository;
    }

    @Override
    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public Record findById(int theId) {
        Optional<Record> result = recordRepository.findById(theId);

        Record theRecord = null;

        if (result.isPresent()) {
            theRecord = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theRecord;
    }

    @Override
    public void save(Record theRecord) {
        recordRepository.save(theRecord);
    }

    @Override
    public void deleteById(int theId) {
        recordRepository.deleteById(theId);
    }

}