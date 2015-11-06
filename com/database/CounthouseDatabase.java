package com.database;


import java.util.List;
import java.util.ArrayList;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

import java.io.IOException;



/*
/ Database - CRUD - Create, Read, Update, Delete
/ only public methods are these!
/
*/
public class CounthouseDatabase implements Database {

  private static final String DATABASE_FILE_PATH = "com/database/db.txt";
  private static final Charset ENCODING = StandardCharsets.UTF_8;

  /*
  /
  / When a new DB is created - load the existing data
  /
  */
  public CounthouseDatabase() {
    initDataItems();
  }

  private static List<CounthouseDataItem> data = new ArrayList<>();
  

    /**
     * @param newDataItem
     * @return
     */
    @Override
  public boolean createDataItem(CounthouseDataItem newDataItem) {

      //TODO: wrap this in a method to check for duplicate id's
      data.add(newDataItem);
      return writeItems();
  }


    /**
     * @param id
     * @return
     */
    @Override
  public CounthouseDataItem readDataItem(Integer id) {
    for (CounthouseDataItem item : data) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }


    /**
     * @param id
     * @param newDataItem
     * @return
     */
    @Override
  public boolean updateDataItem(Integer id, CounthouseDataItem newDataItem) {
    data.forEach((item) -> {
      if (item.getId() == id && item.isActive()) {
        item.setName(newDataItem.getName());
        item.setCity(newDataItem.getCity());
        item.setState(newDataItem.getState());
      }
    });
    return writeItems();
  }



    /**
     * @param id
     * @return
     */
    @Override
  public boolean deleteDataItem(Integer id) {
    data.forEach((item) -> {
      if (item.getId() == id && item.isActive()) {
        item.setActive(false);
    }});
    return writeItems();
  }

  private boolean initDataItems() {
    Path path = Paths.get(DATABASE_FILE_PATH);

    try (Scanner scanner = new Scanner(path, ENCODING.name())) {

      while(scanner.hasNextLine()) {
        processLine(scanner.nextLine());
      }

    } catch (Exception e) {
      System.out.println(e.toString());
      return false;
    }
    return true;
  }

  private boolean processLine(String line) {
    Scanner scanner = new Scanner(line);
    scanner.useDelimiter(",");

    if(scanner.hasNext()) {

      CounthouseDataItem item = new CounthouseDataItem();
      item.setId(Integer.parseInt(scanner.next()));
      item.setName(scanner.next());
      item.setCity(scanner.next());
      item.setState(scanner.next());
      item.setActive(scanner.nextBoolean());

      return data.add(item);
    }
    return false;
  }

  private boolean writeItems() {
    try (BufferedWriter writer = new BufferedWriter(
                                  new OutputStreamWriter(
                                    new FileOutputStream(DATABASE_FILE_PATH), "utf-8"))) {
      for (CounthouseDataItem item : data) {
        writer.write(item.toString());
        writer.newLine();
      }
      return true;
    } catch (IOException e) {
      System.out.println(e.toString());
      return false;
    }
  }

    /**
     * @return
     */
    public List<CounthouseDataItem> getDataItems() {
    return data;
  }
}
