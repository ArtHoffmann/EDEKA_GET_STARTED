package rest;

import entities.residence.ResidenceEntity;
import io.swagger.annotations.Api;
import jpa.residence.JpaResidenceDao;

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

}
