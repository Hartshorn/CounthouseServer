package com.command;

import com.dto.Request;
import com.dto.Request.Code;
import com.dto.Response;
import com.dto.Response.Status;
import com.database.CounthouseDataItem;
import com.database.CounthouseDatabase;

import java.util.List;
import java.util.Random;


public class CounthouseCommand {

  private static CounthouseDatabase database = new CounthouseDatabase();
  private static Random rng = new Random();

  public Response processRequest(Request request) {

    Response response = new Response();

    switch (request.getRequestCode()) {

      case CREATE:

        CounthouseDataItem itemToCreate = createItemFromRequest(request);

        if (!database.createDataItem(itemToCreate)) {
          response.setStatus(Status.ERROR);
        }
        return response;

      case READ:

        CounthouseDataItem itemToRead = database.readDataItem(request.getId());

        response.setId(itemToRead.getId());
        response.setName(itemToRead.getName());
        response.setCity(itemToRead.getCity());
        response.setState(itemToRead.getState());

        return response;

      case UPDATE:

        CounthouseDataItem itemToUpdate = createItemFromRequest(request);

        if(!database.updateDataItem(request.getId(), itemToUpdate)) {
          response.setStatus(Status.ERROR);
        }
        return response;

      case DELETE:

        if(!database.deleteDataItem(request.getId())) {
          response.setStatus(Status.ERROR);
        }
        return response;

      case DISPLAY:

        List<CounthouseDataItem> dataList = database.getDataItems();

        dataList.forEach((item) -> response.addItem(item));

        return response;

      default:

        return response;
    }
  }

  private CounthouseDataItem createItemFromRequest(Request request) {

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
