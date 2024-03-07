package com.eric.recordStore.controller;


import com.eric.recordStore.service.RecordService;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.eric.recordStore.entity.Record;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/records")
public class RecordController {

    private RecordService recordService;
    public RecordController(RecordService theRecordService){
        recordService = theRecordService;
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("recordId") int theId){

        recordService.deleteById(theId);

        return "redirect:/records/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("recordId") int theId,
                                    Model theModel){

        // get the record from the service
        Record theRecord = recordService.findById(theId);

        // set record as a model attribute to pre-populate the form
        theModel.addAttribute("record", theRecord);

        // send over to our form
        return "records/record-form";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd (Model theModel){
        //create model attribute to bind form data
        Record theRecord = new Record();

        theModel.addAttribute("record", theRecord);

        return "records/record-form";
    }

    // load record data

    @PostMapping("/save")
    public String saveRecord(@ModelAttribute("record") Record theRecord) {
        recordService.save(theRecord);
        return "redirect:/records/list";
    }


    // add mapping for "/list"

    @GetMapping("/list")
    public String listRecords(Model theModel) {

        //get record from db
        List<Record> theRecord = recordService.findAll();

        // add to the spring model
        theModel.addAttribute("records", theRecord);

        return "records/list-records";
    }
}