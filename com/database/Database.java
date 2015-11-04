package com.database;


public interface Database {

  // CRUD ONLY!
  boolean createDataItem(CounthouseDataItem newDataItem);
  CounthouseDataItem readDataItem(Integer id);
  boolean updateDataItem(Integer id, CounthouseDataItem newDataItem);
  boolean deleteDataItem(Integer id);
}
