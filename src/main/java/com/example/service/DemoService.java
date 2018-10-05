package com.example.service;

import java.util.List;
import com.example.dto.MyData;

public interface DemoService {
  
  List<MyData> getListOfData();
  
  void saveData(List<MyData> listOfData);
  
  MyData getDataById(Long id);

}
