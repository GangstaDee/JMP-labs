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

    @POST
    //@Consumes(MediaType.APPLICATION_XML)
    public Response createUser(User user) {

        UserStorage.addUser(user);
        return Response.status(Response.Status.CREATED).entity("User was successfully created").build();
    }

    @GET
    public Response readUser(@QueryParam("id") int id) {

        if(id <=0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid ID").build();
        }
        User user = UserStorage.readUser(id);
        if(user == null) {
            return Response.status(Response.Status.NO_CONTENT).entity("No users found").build();
        }

        return Response.ok(user).build();
    }

    @PUT
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@QueryParam("id") int id, User user) {

        if(id <=0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid ID").build();
        }
        boolean updated = UserStorage.updateUser(id, user);
        if(!updated)
            return Response.status(Response.Status.NO_CONTENT).entity("No users found").build();

        return Response.ok("User was successfully updated").build();
    }

    @DELETE
    public Response deleteUser(@QueryParam("id") int id) {

        if(id <=0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid ID").build();
        }
        boolean deleted = UserStorage.deleteUser(id);
        if(!deleted) {
            return Response.status(Response.Status.NO_CONTENT).entity("No users found").build();
        }

        return Response.ok("User was successfully deleted").build();
    }
}
