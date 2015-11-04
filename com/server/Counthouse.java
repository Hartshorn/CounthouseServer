package com.server;

import javax.xml.ws.Endpoint;

public class Counthouse {
  public static void main(String ... args) {
    Endpoint.publish("http://localhost:8080/counthouse", new CounthouseServerImpl());

    //on c9 (check this)
    //Endpoint.publish("http://0.0.0.0:8080/counthouse", new CounthouseServerImpl());
  }
}
