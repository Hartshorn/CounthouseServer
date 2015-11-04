package com.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.dto.Response;
import com.dto.Request;


@WebService
@SOAPBinding(style=Style.RPC)
public interface CounthouseServer {

  @WebMethod
  Response process(Request request);
}
