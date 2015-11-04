package com.server;

import javax.jws.WebService;

import com.dto.Request;
import com.dto.Response;
import com.command.CounthouseCommand;


@WebService(endpointInterface="com.server.CounthouseServer")
public class CounthouseServerImpl implements CounthouseServer {

  private static CounthouseCommand command = new CounthouseCommand();

  /*
  /
  / This should be the only publicly exposed method
  / the client should know of this, a request, and a response
  / this protocal assumes the client knows how to correctly fill out a request
  / and how to process a response
  /
  */
  @Override
  public Response process(Request request) {
    return command.processRequest(request);
  }
}
