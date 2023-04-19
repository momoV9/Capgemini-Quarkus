package com.capgemini.be;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("name") String name) {
        if (name != null && !name.isEmpty()) {
            return "Hello, " + name + "!";
        } else {
            return "Hello from RESTEasy Reactive";
        }
    }
}
