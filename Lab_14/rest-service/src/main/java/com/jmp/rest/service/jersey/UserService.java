package com.jmp.rest.service.jersey;

import com.jmp.rest.entity.User;
import com.jmp.rest.entity.UserStorage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created on 3/21/2016.
 */
@Path("/user")
public class UserService {

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Path("/read/{id}")
    public Response readUser(@PathParam("id") int id) {
        if(id <=0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid ID").type(MediaType.TEXT_PLAIN).build();
        }

        User user = UserStorage.readUser(id);
        if(user == null) {
            return Response.status(201).entity("No users found").type(MediaType.TEXT_PLAIN).build();
        }

        return Response.ok(user, MediaType.APPLICATION_XML).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/create")
    public Response createUser(User user) {
        UserStorage.addUser(user);
        return Response.ok("Added successfully", MediaType.TEXT_PLAIN).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public Response updateUser(User user) {
        boolean updated = UserStorage.updateUser(user);
        if(!updated)
            return Response.status(201).entity("User was not updated").type(MediaType.TEXT_PLAIN).build();

        return Response.ok("Updated successfully", MediaType.TEXT_PLAIN).build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        if(id <=0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid ID").type(MediaType.TEXT_PLAIN).build();
        }
        boolean deleted = UserStorage.deleteUser(id);
        if(!deleted) {
            return Response.status(201).entity("No users found").type(MediaType.TEXT_PLAIN).build();
        }

        return Response.ok("Deleted successfully", MediaType.TEXT_PLAIN).build();
    }
}
