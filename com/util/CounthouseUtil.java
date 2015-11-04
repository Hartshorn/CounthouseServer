package com.util;


import com.database.CounthouseDataItem;
import com.dto.Request;

import java.util.Random;


public class CounthouseUtil {

  private static Random rng = new Random();

  public CounthouseDataItem createItemFromRequest(Request request) {

    CounthouseDataItem item = new CounthouseDataItem();

    item.setId(generateId());
    item.setName(request.getName());
    item.setCity(request.getCity());
    item.setState(request.getState());

    return item;
  }


  private static Integer generateId() {
    return rng.nextInt(100);
  }
}
