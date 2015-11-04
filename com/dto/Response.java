package com.dto;

import java.util.List;
import java.util.ArrayList;


public class Response {

  private Integer id;
  private String name;
  private String city;
  private String state;
  private Integer status;
  private List<String> errors = new ArrayList<>();


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
  
  public Response(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return this.status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public List<String> getErrors() {
    return this.errors;
  }

  public void addError(String error) {
    this.errors.add(error);
  }
}
