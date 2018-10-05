package com.example.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.dao.DemoRepository;
import com.example.dto.MyData;
import com.example.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

  @Autowired
  DemoRepository repository;

  @Override
  @Cacheable(value="myDataAll")
  public List<MyData> getListOfData() {
    return repository.findAll();
  }

  @Override
  @CacheEvict(value="myDataAll")
  public void saveData(List<MyData> listOfData) {
    repository.saveAll(listOfData);
  }

  @Override
  @Cacheable(value="myData.byId")
  public MyData getDataById(Long id) {
    return repository.findById(id).orElse(null);
  }
}
