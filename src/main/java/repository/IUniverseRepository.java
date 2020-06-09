package repository;
import model.Planet;
import model.PlanetSystem;
import java.util.ArrayList;

public interface IUniverseRepository {
    PlanetSystem getPlanetSystem(String planetSystemName);
    ArrayList<PlanetSystem> getPlanetSystems();
    Planet getPlanet(String planetSystemName, String planet);
    ArrayList<Planet> getPlanets(String planetSystemName);
}
