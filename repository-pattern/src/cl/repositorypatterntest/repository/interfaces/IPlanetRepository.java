package cl.repositorypatterntest.repository.interfaces;

import java.util.List;

import cl.repositorypatterntest.types.Planet;

public interface IPlanetRepository {

	List<Planet> getPlanets();

	List<Planet> getStars();
}
