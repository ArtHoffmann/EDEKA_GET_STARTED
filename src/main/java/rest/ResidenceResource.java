package rest;

import entities.residence.ResidenceEntity;
import io.swagger.annotations.Api;
import jpa.residence.JpaResidenceDao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Qualifier;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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


    @Inject JpaResidenceDao jpaResidenceDao;

    @GET
    @Path("/all")
    public Response getResidenceResources() {
        List<ResidenceEntity> residence = jpaResidenceDao.findAll();
        return Response.ok(residence).build();
    }
}
