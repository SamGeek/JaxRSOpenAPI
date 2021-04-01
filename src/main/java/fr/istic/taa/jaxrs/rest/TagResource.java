package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/tag")
@Produces({ "application/json", "application/xml" })
public class TagResource {

	private AbstractJpaDao<Long, Tag> tagDao = new AbstractJpaDao<Long, Tag>(){};

	@GET
	@Path("/{tagID}")
	public Tag getPetById(@PathParam("tagID") Long tagID) {	
		tagDao.setClazz(Tag.class);
		return tagDao.findOne(tagID);
	}

	@POST
	@Consumes("application/json")
	public Response addPet(
			@Parameter( required = true) Tag tag) {
		
		tagDao.save(tag);

		return Response.ok().entity("SUCCESS").build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response modifyTag( Tag tag) {
	
		tagDao.update(tag);

		return Response.ok().entity("SUCCESS").build();
	}
	

	@DELETE
	@Path("/{tagID}")
	@Consumes("application/json")
	public Response deleteTag(@PathParam("tagID") Long tagID) {
		tagDao.setClazz(Tag.class);
		tagDao.deleteById(tagID);

		return Response.ok().entity("SUCCESS").build();
	}
	
}