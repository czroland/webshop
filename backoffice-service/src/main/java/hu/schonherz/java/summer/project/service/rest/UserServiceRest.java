package hu.schonherz.java.summer.project.service.rest;


import hu.schonherz.java.summer.project.service.api.vo.UserVo;
import hu.schonherz.java.summer.project.service.impl.user.UserServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Component
@Path("/users")
public class UserServiceRest {

    @Autowired
    private UserServiceBean userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(UserVo user, @Context UriInfo uriInfo) {
        userService.registrationUser(user);

        return Response.status(Response.Status.CREATED.getStatusCode())
            .header(
                "Location",
                String.format("%s/%s", uriInfo.getAbsolutePath().toString(),
                    user.getId())).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserVo getEmployee(@PathParam("id") Long id) {
        return userService.findById(id);
    }

}
