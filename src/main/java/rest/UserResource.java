package rest;

import entities.user.UserEntity;
import io.swagger.annotations.*;
import jpa.user.JpaUserDao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Qualifier;
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
@Named("userResource")
@Default
public class UserResource {

    @Inject
    JpaUserDao jpaUserDao;


    @GET
    @Path("/all")
    @Transactional
    public Response getResources() {
        List<UserEntity> all = jpaUserDao.findAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/specificUserByQuery/{id}")
    public Response getOneUser(@PathParam("id") int id) {
        System.out.println("ID" + id);
        UserEntity user = jpaUserDao.specificUser(id);
        return Response.ok(user).build();
    }

    @GET
    @Path("/readByCRUD/{id}")
    public Response readUser(@PathParam("id") int id) {
        System.out.println("ID" + id);
        UserEntity user = jpaUserDao.read(id);
        return Response.ok(user).build();
    }

    @POST
    @Path("/createUser")
    @Produces("application/json")
    @Transactional
    public UserEntity createUser(UserEntity user) {
        UserEntity u = new UserEntity();
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        jpaUserDao.create(u);
        return u;
    }

    @PUT
    @Path("update/user/{id}")
    @Produces("application/json")
    @Transactional
    public Response updateUser(@PathParam("id") int id, UserEntity user){
        UserEntity u = jpaUserDao.read(id);
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
        UserEntity user = jpaUserDao.read(id);
        jpaUserDao.delete(user);
        return Response.ok(user).build();
    }

}
