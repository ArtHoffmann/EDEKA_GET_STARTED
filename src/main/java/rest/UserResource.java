package rest;

import entities.User;
import jpa.JpaUserDao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    JpaUserDao jpaUserDao;


    @GET
    @Path("/all")
    @Transactional
    public Response getResources() {
        List<User> all = jpaUserDao.findAll();
        StringBuilder builder = new StringBuilder();
        return Response.ok(all).build();
    }

    @GET
    @Path("/specificUser/{id}")
    @Transactional
    public Response getOneUser(@PathParam("id") int id) {
        System.out.println("ID" + id);
        User user = jpaUserDao.specificUser(id);
        return Response.ok(user).build();
    }

    @POST
    @Path("/create/{firstname}/{lastname}")
    @Produces("application/json")
    @Transactional
    public User createUser(@PathParam("firstname") String fn, @PathParam("lastname") String ln) {
        User u = new User();
        u.setFirstName(fn);
        u.setLastName(ln);
        jpaUserDao.create(u);
        return u;
    }

}
