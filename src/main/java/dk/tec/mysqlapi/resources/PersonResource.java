package dk.tec.mysqlapi.resources;

import dk.tec.mysqlapi.dataservice.PersonDataService;
import dk.tec.mysqlapi.models.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
public class PersonResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        PersonDataService dataService = new PersonDataService();
        return dataService.getAllPersons();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{persId}")
    public Person getSinglePerson(@PathParam("persId") int persId) {
        PersonDataService dataService = new PersonDataService();
        return dataService.getSinglePerson(persId);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public int addPerson(Person pers) {
        PersonDataService dataService = new PersonDataService();
        return dataService.addPerson(pers);
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{persId}")
    public int updatePerson(@PathParam("persId") int persId,Person pers) {
        PersonDataService dataService = new PersonDataService();
        return dataService.updatePerson(persId, pers);
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{persId}")
    public int deletePerson(@PathParam("persId") int persId) {
        PersonDataService dataService = new PersonDataService();
        return dataService.deletePerson(persId);
    }
}