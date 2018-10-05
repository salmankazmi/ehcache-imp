package com.example.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dto.MyData;
import com.example.service.DemoService;

@RestController
@RequestMapping("/cashew")
public class DemoController {
  
  private static Logger log = LoggerFactory.getLogger(DemoController.class);
  
  @Autowired
  DemoService service;
  
  @PostMapping("/saveData")
  public String saveData(@RequestBody List<MyData> myData) {
    service.saveData(myData);
    return "Hooray!";
  }
  
  @GetMapping("/retrieveData")
  public List<MyData> retrieveData() {
    List<MyData> data = service.getListOfData();
    return data;
  }
  
  @GetMapping("/retrieveDataById/{id}")
  public MyData retrieveDataById(@PathVariable(value="id") Long id) {
    return service.getDataById(id);
  }
}
