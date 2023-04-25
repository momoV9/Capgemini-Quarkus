package com.capgemini.be;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/gender")
public class GenderResources {

    @Inject
    @RestClient
    GenderProxy genderProxy;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGender(@QueryParam("name") String name) {
        Gender gender = genderProxy.getGender(name);
        return Response.ok(gender).build();
    }
}


