package cl.repositorypatterntest.business;

import java.util.List;
import java.util.stream.Collectors;

import cl.repositorypatterntest.repository.interfaces.IPlanetRepository;
import cl.repositorypatterntest.types.Planet;

// business layer

public class PlanetBusiness {

	IPlanetRepository _repository;

	public PlanetBusiness(IPlanetRepository repository) {
		_repository = repository;
	}

	public List<Planet> getPlanets() {
		return _repository.getPlanets();
	}

	public List<Planet> getStars() {
		return _repository.getStars();
	}

	public List<Planet> getTerraformPlanets() {
		// Return the list of filtered data from the database.
		List<Planet> planetList = _repository.getPlanets();

		/*
		 * var results = from p in planetList
		 * where p.IsTerraform == true
		 * select p;
		 */

		List<Planet> results = planetList.stream().filter(p -> p.isTerraform == true).collect(Collectors.toList());

		return results;
	}

}
