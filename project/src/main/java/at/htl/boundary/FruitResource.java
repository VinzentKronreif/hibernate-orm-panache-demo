package at.htl.boundary;

import at.htl.entity.Fruit;
import at.htl.repository.FruitRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api")
public class FruitResource {

    @Inject
    FruitRepository fruitRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> getFruits(@QueryParam("season") String season) {
        if (season != null) {
            return fruitRepository.findBySeason(season);
        }
        return fruitRepository.listAll();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newFruit(Fruit fruit) {
        fruit.id = null;
        fruitRepository.persist(fruit);
        return Response.status(Response.Status.CREATED).entity(fruit).build();
    }
}
