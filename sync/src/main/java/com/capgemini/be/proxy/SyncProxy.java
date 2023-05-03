//package com.capgemini.be.proxy;
//
//import com.capgemini.be.lms.model.LeaveRequest;
//import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//
//@Produces(MediaType.APPLICATION_JSON)
//@RegisterRestClient(baseUri = "http://localhost:8081")
//
//
//public interface SyncProxy {
//
//    @POST
//    @Path("/sync")
//    @Consumes(MediaType.APPLICATION_JSON)
//    Response syncLeaveRequest(LeaveRequest leaveRequest);
//
//}
