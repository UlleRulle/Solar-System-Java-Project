package controller;

import io.javalin.http.Context;
import model.Planet;
import repository.IUniverseRepository;

import java.util.ArrayList;
import java.util.Collections;

public class PlanetController {
    private IUniverseRepository universityRepository;

    public PlanetController(IUniverseRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public void getPlanets(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String sortBy = context.queryParam("sort_by");

        ArrayList<Planet> planets = universityRepository.getPlanets(planetSystemName);

        if (sortBy != null) {
            switch (sortBy) {
                case "name":
                    Collections.sort(planets);
                    break;
                case "mass":
                    planets.sort((o1, o2) -> (int) (o1.getMass() - o2.getMass()));
                    break;
                case "radius":
                    planets.sort((o1, o2) -> {
                        if (o1.getRadius() < o2.getRadius())
                            return -1;
                        else if(o1.getRadius() > o2.getRadius())
                            return 1;
                        return 0;
                    });
                    break;
            }
        }


        context.json(planets);
    }

    public void getPlanet(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String planetName = context.pathParam("planet-id");

        context.json(universityRepository.getPlanet(planetSystemName, planetName));
    }
}
