package cl.devweb.designpatterns.repository.interfaces;

import java.util.List;

import cl.devweb.designpatterns.repository.types.Planet;

public interface IPlanetRepository {

	List<Planet> getPlanets();

	List<Planet> getStars();
}
