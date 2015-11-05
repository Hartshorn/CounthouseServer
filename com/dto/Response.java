package com.dto;

import java.util.List;
import java.util.ArrayList;

import com.database.CounthouseDataItem;


public class Response {

  public static enum Status { OK, ERROR }

  private Integer id;
  private String name;
  private String city;
  private String state;
  private Status status;
  private List<CounthouseDataItem> items = new ArrayList<>();
  private List<String> errors = new ArrayList<>();


  public Response() {
    this.status = Status.OK;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Status getStatus() {
    return this.status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public List<CounthouseDataItem> getItems() {
    return this.items;
  }

  public void addItem(CounthouseDataItem item) {
    this.items.add(item);
  }

  public List<String> getErrors() {
    return this.errors;
  }

  public void addError(String error) {
    this.errors.add(error);
  }
}
