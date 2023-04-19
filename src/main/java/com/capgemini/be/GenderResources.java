package com.capgemini.be;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/gender")
public class GenderResources {


    @RestClient
GenderProxy genderProxy;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getG(){


        return Response.ok(genderProxy.getGender("willy").getGender()).build();
    }
}
