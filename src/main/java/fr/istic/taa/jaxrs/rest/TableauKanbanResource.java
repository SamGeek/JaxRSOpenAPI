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
import fr.istic.taa.jaxrs.domain.TableauKanban;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/tableaukanban")
@Produces({ "application/json", "application/xml" })
public class TableauKanbanResource {

	private AbstractJpaDao<Long, TableauKanban> tableauKanbanDao = new AbstractJpaDao<Long, TableauKanban>(){};

	@GET
	@Path("/{tableaukanbanID}")
	public TableauKanban getTableauKanbanById(@PathParam("tableaukanbanID") Long tableaukanbanID) {
		tableauKanbanDao.setClazz(TableauKanban.class);
		return tableauKanbanDao.findOne(tableaukanbanID);
	}

	@POST
	@Consumes("application/json")
	public Response addTableauKanban(
			@Parameter(required = true) TableauKanban tableauKanban) {
		
		tableauKanbanDao.save(tableauKanban);

		return Response.ok().entity("SUCCESS").build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response modifyTableauKanban( TableauKanban tableauKanban) {
	
		tableauKanbanDao.update(tableauKanban);

		return Response.ok().entity("SUCCESS").build();
	}
	

	@DELETE
	@Path("/{tableaukanbanID}")
	@Consumes("application/json")
	public Response deleteTableauKanban(@PathParam("tableaukanbanID") Long tableaukanbanID) {
		tableauKanbanDao.setClazz(TableauKanban.class);
		tableauKanbanDao.deleteById(tableaukanbanID);

		return Response.ok().entity("SUCCESS").build();
	}
}