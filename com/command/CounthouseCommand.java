package com.command;

import com.database.CounthouseDataItem;
import com.database.CounthouseDatabase;

import com.dto.Request;
import com.dto.Response;
import com.dto.Response.Status;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CounthouseCommand {

  private static CounthouseDatabase database = new CounthouseDatabase();
  private static Logger logger = Logger.getLogger(CounthouseCommand.class.getName());
  private static Random rng = new Random();

    /**
     * @param request
     * @return
     */
    public Response processRequest(Request request) {

    Response response = new Response();

    switch (request.getRequestCode()) {

      case CREATE:

        logger.log(Level.INFO, "Create Data Item");

        CounthouseDataItem itemToCreate = createItemFromRequest(request);

        if (!database.createDataItem(itemToCreate)) {
          response.setStatus(Status.ERROR);
        }
        return response;

      case READ:

        logger.log(Level.INFO, "Read Data Item: " + request.getId());

        CounthouseDataItem itemToRead = database.readDataItem(request.getId());

        response.setId(itemToRead.getId());
        response.setName(itemToRead.getName());
        response.setCity(itemToRead.getCity());
        response.setState(itemToRead.getState());

        return response;

      case UPDATE:

        logger.log(Level.INFO, "Update Data Item: " + request.getId());

        CounthouseDataItem itemToUpdate = createItemFromRequest(request);

        if(!database.updateDataItem(request.getId(), itemToUpdate)) {
          response.setStatus(Status.ERROR);
        }
        return response;

      case DELETE:

        logger.log(Level.INFO, "Delete Data Item");

        if(!database.deleteDataItem(request.getId())) {
          response.setStatus(Status.ERROR);
        }
        return response;

      case DISPLAY:

        logger.log(Level.INFO, "Display All Data Items");

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
    item.setActive(true);

    return item;
  }

  private static Integer generateId() {
    return rng.nextInt(100);
  }

}
