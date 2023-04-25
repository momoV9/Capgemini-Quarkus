package com.capgemini.be;


import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/fact")
public class FactsResources {
@RestClient
FactsProxy factsProxy;



@GET

@Produces(MediaType.APPLICATION_JSON)
public Response getF(){

    return Response.ok(factsProxy.getFact().getFact()).build();
}

}




