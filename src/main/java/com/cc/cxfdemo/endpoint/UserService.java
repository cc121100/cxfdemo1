package com.cc.cxfdemo.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.cc.cxfdemo.domain.User;

@Path("/userservice")
public interface UserService {
	
	@GET
	@Path("/users")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	/*@Produces(MediaType.APPLICATION_JSON)*/
	public List<User> getAllUsers(); 
	
	@GET
    @Path("/user/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public User getUserById(@PathParam("id") String id);
	
	@POST
	@Path("/user/add")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response addUser(User user);
    
}
