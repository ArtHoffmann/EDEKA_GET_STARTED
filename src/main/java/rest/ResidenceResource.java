package rest;

import entities.residence.ResidenceEntity;
import entities.user.UserEntity;
import io.swagger.annotations.Api;
import jpa.residence.JpaResidenceDao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("residence")
@Api
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Named("residenceResource")
public class ResidenceResource {


    @Inject
    JpaResidenceDao jpaResidenceDao;

    @GET
    @Path("/all")
    public Response getResidenceResources() {
        List<ResidenceEntity> residence = jpaResidenceDao.findAll();
        return Response.ok(residence).build();
    }

    @GET
    @Path("/specificResidence/{id}")
    public Response getResidenceById(@PathParam("id") int id) {
        ResidenceEntity residence = jpaResidenceDao.read(id);
        return Response.ok(residence).build();
    }

    @POST
    @Path("/createResidenceWithNewUser}")
    public Response createResidenceWithNewUser(ResidenceEntity residenceEntity) {
        ResidenceEntity residenceEntity1 = jpaResidenceDao.createResidenceWithNewUser(residenceEntity);
        return Response.ok(residenceEntity1).build();
    }

    @PUT
    @Path("/editExistingResidenceForUser/{id}")
    public Response editExistingResidenceForUser(@PathParam("id") int id, ResidenceEntity res){
        return Response.ok(jpaResidenceDao.editExistingResidenceForUser(id, res)).build();
    }

    @DELETE
    @Path("/deleteExistingResidenceForUser/{id}")
    public Response deleteExistingResidenceForUser(@PathParam("id") int id) {
        return Response.ok(jpaResidenceDao.deleteExistingResidenceForUser(id)).build();
    }

}
