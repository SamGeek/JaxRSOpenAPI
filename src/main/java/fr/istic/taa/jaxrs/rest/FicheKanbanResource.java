package fr.istic.taa.jaxrs.rest;

import java.util.List;

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
import fr.istic.taa.jaxrs.domain.FicheKanban;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/section")
@Produces({ "application/json", "application/xml" })
public class FicheKanbanResource {

	private AbstractJpaDao<Long, FicheKanban> fichekanbanDao = new AbstractJpaDao<Long, FicheKanban>(){};
	
	@GET
	@Path("/getAll")
	@Consumes("application/json")
	public List<FicheKanban> getAllFichesKanban() {
		fichekanbanDao.setClazz(FicheKanban.class);
		return fichekanbanDao.findAll();
	}

	@GET
	@Path("/{fichekanbanId}")
	public FicheKanban getKanbanById(@PathParam("fichekanbanId") Long fichekanbanId) {		
		fichekanbanDao.setClazz(FicheKanban.class);
		return fichekanbanDao.findOne(fichekanbanId);
	}

	@POST
	@Consumes("application/json")
	public Response addKanban(
			@Parameter(description = "FicheKanban object that needs to be added to the dataStore", required = true) FicheKanban fichekanban) {
		
		fichekanbanDao.save(fichekanban);

		return Response.ok().entity("SUCCESS").build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response modifyCollaborateur( FicheKanban ficheKanban) {
	
		fichekanbanDao.update(ficheKanban);

		return Response.ok().entity("SUCCESS").build();
	}
	

	@DELETE
	@Path("/{fichekanbanId}")
	@Consumes("application/json")
	public Response deleteCollaborateur(@PathParam("fichekanbanId") Long fichekanbanId) {
		fichekanbanDao.setClazz(FicheKanban.class);
		fichekanbanDao.deleteById(fichekanbanId);

		return Response.ok().entity("SUCCESS").build();
	}
	
	
}