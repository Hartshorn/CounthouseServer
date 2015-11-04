package com.command;

import com.dto.Request;
import com.dto.Response;
import com.database.CounthouseDataItem;
import com.database.CounthouseDatabase;
import com.util.CounthouseUtil;
import static com.constants.Constants.*;



public class CounthouseCommand {

  private static CounthouseDatabase database = new CounthouseDatabase();
  private static CounthouseUtil util = new CounthouseUtil();

  public Response processRequest(Request request) {

    Response response = new Response(RESPONSE_STATUS_OK);

    switch (request.getRequestCode()) {

      case 100:
        CounthouseDataItem itemToCreate = util.createItemFromRequest(request);

        if (!database.createDataItem(itemToCreate)) {

          response.setStatus(RESPONSE_STATUS_BAD);
        }

        return response;

      case 200:

        CounthouseDataItem itemToRead = database.readDataItem(request.getId());

        response.setId(itemToRead.getId());
        response.setName(itemToRead.getName());
        response.setCity(itemToRead.getCity());
        response.setState(itemToRead.getState());

        return response;

      case 300:

        return response;

      case 400:

        return response;

      case 999:

        return response;

      default:

        return response;
    }
  }

}
