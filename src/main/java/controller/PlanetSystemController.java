package controller;

import io.javalin.http.Context;
import repository.IUniverseRepository;

public class PlanetSystemController {
    private IUniverseRepository universityRepository;

    public PlanetSystemController(IUniverseRepository universeRepository) {
        this.universityRepository = universeRepository;
    }

    public void getAllPlanetSystems(Context context) {
        context.json(universityRepository.getPlanetSystems());
    }

    public void getPlanetSystem(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        context.json(universityRepository.getPlanetSystem(planetSystemName));
    }

}
