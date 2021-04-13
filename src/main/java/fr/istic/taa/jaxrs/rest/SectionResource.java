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
import fr.istic.taa.jaxrs.domain.FicheKanban;
import fr.istic.taa.jaxrs.domain.Section;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/section")
@Produces({ "application/json", "application/xml" })
public class SectionResource {

	private AbstractJpaDao<Long, Section> sectionDao = new AbstractJpaDao<Long, Section>(){};

	@GET
	@Path("/getAll")
	@Consumes("application/json")
	public List<Section> getAllSections() {
		sectionDao.setClazz(Section.class);
		return sectionDao.findAll();
	}
	
	@GET
	@Path("/{sectionId}")
	public Section getSectionById(@PathParam("sectionId") Long sectionId) {	
		sectionDao.setClazz(Section.class);
		return sectionDao.findOne(sectionId);
	}

	@POST
	@Consumes("application/json")
	public Response addSection(
			@Parameter(description = "Section object that needs to be added to the dataStore", required = true) Section section) {
		
		sectionDao.save(section);

		return Response.ok().entity("SUCCESS").build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response modifySection( Section section) {
	
		sectionDao.update(section);

		return Response.ok().entity("SUCCESS").build();
	}
	

	@DELETE
	@Path("/{sectionId}")
	@Consumes("application/json")
	public Response deleteSection(@PathParam("sectionId") Long sectionId) {
		sectionDao.setClazz(Section.class);
		sectionDao.deleteById(sectionId);

		return Response.ok().entity("SUCCESS").build();
	}
	
	
}