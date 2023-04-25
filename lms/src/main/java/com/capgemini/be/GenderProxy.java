package com.capgemini.be;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
public interface GenderProxy {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Gender getGender(@QueryParam("name") String name);
}