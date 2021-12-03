package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Tag(name = "Authentication", description = "Handles the Authentication")
public class UserController {
    @Inject
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/new-user")
    @PermitAll
    @Operation(summary = "creates a new user", description = "creates a new user")
    public void newUser(User user) {
        userService.createUser(user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Users", description = "")
    public List<User> list() {
        return userService.findAll();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @Operation(summary = "Remove all Entry", description = "Removes Entries by id")
    public void deleteEntry(@PathParam("id") Long id) {
        userService.delete(id);
    }

    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User update(User user){
        return userService.update(user);
    }
    
}
