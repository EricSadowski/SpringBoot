package com.concordia.recordStore.controller;

import com.concordia.recordStore.service.RecordService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.concordia.recordStore.entity.Record;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/records")
public class RecordController {

    // load employee data

    private RecordService recordService;
    public RecordController(RecordService theRecordService){
        recordService = theRecordService;
    }


//    private List<Record> theRecords;

//    @PostConstruct
//    private void loadData() {
//
//        // create records
//        Record emp1 = new Record(1, "Superstition", "Stevie Wonder", "https://images-na.ssl-images-amazon.com/images/I/61QS7JNSb6L._SY355_.jpg", 20.00);
//        Record emp2 = new Record(2, "Stairway to Heaven", "Led Zeppelin", "https://upload.wikimedia.org/wikipedia/en/f/ff/Led_Zeppelin_-_Led_Zeppelin_IV.jpg", 25.00);
//        Record emp3 = new Record(3, "Johnny B. Goode", "Chuck Berry", "https://img.discogs.com/axnjou1o0QqkHWAY1UOI3nA4P1Q=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-104557-1424302618-4280.jpeg.jpg", 18.00);
//        Record emp4 = new Record(4, "Bang A Gong (Get It On)", "T. Rex", "https://cps-static.rovicorp.com/3/JPG_500/MI0003/425/MI0003425327.jpg?partner=allrovi.com", 22.00);
//
//        // create the list
//        theRecords = new ArrayList<>();
//
//        // add to the list
//        theRecords.add(emp1);
//        theRecords.add(emp2);
//        theRecords.add(emp3);
//        theRecords.add(emp4);
//    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listRecords(Model theModel) {

        //get record from db
        List<Record> theRecords = recordService.findAll();


        // add to the spring model
        theModel.addAttribute("records", theRecords);

        return "list-records";
    }

    @GetMapping("/main")
    public String indexRecords(Model theModel) {

        //get record from db
        List<Record> theRecords = recordService.findAll();


        // add to the spring model
        theModel.addAttribute("records", theRecords);

        return "main";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd (Model theModel){
        //create model attribute to bind form data
        Record theRecord = new Record();

        theModel.addAttribute("record", theRecord);

        return "record-form";
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
        return "record-form";
    }

    @PostMapping("/save")
    public String saveRecord(@ModelAttribute("record") Record theRecord) {
        recordService.save(theRecord);
        return "redirect:/records/list";
    }


}