package rest;

import entities.User;
import io.swagger.annotations.*;
import jpa.JpaUserDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("user")
@Api
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
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
    public Response getOneUser(@PathParam("id") int id) {
        System.out.println("ID" + id);
        User user = jpaUserDao.specificUser(id);
        return Response.ok(user).build();
    }

    @GET
    @Path("/read/{id}")
    public Response readUser(@PathParam("id") int id) {
        System.out.println("ID" + id);
        User user = jpaUserDao.read(id);
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

    @PUT
    @Path("update/user/{id}")
    @Produces("application/json")
    @Transactional
    public Response updateUser(@PathParam("id") int id, User user){
        User u = jpaUserDao.read(id);
        u.setLastName(user.getLastName());
        u.setFirstName(user.getFirstName());
        jpaUserDao.update(u);
        return Response.ok(u).build();
    }

    @DELETE
    @Path("deleteUserById/user/{id}")
    @Produces("application/json")
    @Transactional
    public Response deleteUser(@PathParam("id") int id){
        User user = jpaUserDao.read(id);
        jpaUserDao.delete(user);
        return Response.ok(user).build();
    }

}
