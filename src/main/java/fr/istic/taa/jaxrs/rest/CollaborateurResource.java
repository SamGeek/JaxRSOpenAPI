package fr.istic.taa.jaxrs.rest;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.Collaborateur;
import fr.istic.taa.jaxrs.domain.CollaborateurInterne;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/collaborateur")
@Produces({ "application/json", "application/xml" })
public class CollaborateurResource {

	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();

	@GET
	@Path("/{collaborateurId}")
	public Collaborateur getPetById(@PathParam("collaborateurId") Long collaborateurId) {
		// return the collaborator identified by the provided Id
		//we should check in the database with the provided id
		String query = "SELECT c from Collaborateur as c WHERE c.id= :id";

		//gerer les cas ou aucun utilisateur ne corresponds a l'ID renseigné
		
		return manager.createQuery(query, Collaborateur.class).setParameter("id", collaborateurId).getSingleResult();
	}

	@POST
	@Consumes("application/json")
	public Response addPet(
			@Parameter(description = "Collaborateur object that needs to be added to the dataStore", required = true) CollaborateurInterne collab) {
		// add collab provided in param
		tx.begin();
		
		try {
			manager.persist(collab);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		return Response.ok().entity("SUCCESS").build();
	}
}