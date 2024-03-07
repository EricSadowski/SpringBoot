package com.eric.recordStore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.recordStore.entity.Record;

public interface RecordRepository extends JpaRepository<Record, Integer> {

    // that's it ... no need to write any code LOL!

}
