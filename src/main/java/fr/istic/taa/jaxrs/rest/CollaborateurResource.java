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
import fr.istic.taa.jaxrs.domain.Collaborateur;

@Path("/collaborateur")
@Produces({ "application/json", "application/xml" })
public class CollaborateurResource {

	private AbstractJpaDao<Long, Collaborateur> collaborateurDao = new AbstractJpaDao<Long, Collaborateur>(){};
	

	@GET
	@Path("/{collaborateurId}")
	@Consumes("application/json")
	public Collaborateur getCollaborateurById(@PathParam("collaborateurId") Long collaborateurId) {
		collaborateurDao.setClazz(Collaborateur.class);
		return collaborateurDao.findOne(collaborateurId);
	}

	@POST
	@Consumes("application/json")
	public Response addCollaborateur( Collaborateur collab) {
	
		collaborateurDao.save(collab);

		return Response.ok().entity("SUCCESS").build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response modifyCollaborateur( Collaborateur collab) {
	
		collaborateurDao.update(collab);

		return Response.ok().entity("SUCCESS").build();
	}
	

	@DELETE
	@Path("/{collaborateurId}")
	@Consumes("application/json")
	public Response deleteCollaborateur(@PathParam("collaborateurId") Long collaborateurId) {
		collaborateurDao.setClazz(Collaborateur.class);
		collaborateurDao.deleteById(collaborateurId);

		return Response.ok().entity("SUCCESS").build();
	}
	
	
	
}