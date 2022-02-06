package at.htl.boundary;

import at.htl.entity.Fruit;
import at.htl.repository.FruitRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class FruitResource {

    @Inject
    FruitRepository fruitRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> getFruits() {
        return fruitRepository.listAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> getFruitsBySeason(@QueryParam("season") String season) {
        return fruitRepository.findBySeason(season);
    }
}
