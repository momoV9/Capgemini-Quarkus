package com.capgemini.be;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fact")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface FactsProxy {
    @GET
    Fact getFact();

}
