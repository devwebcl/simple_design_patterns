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

	public List<Planet> GetPlanets() {
		return _repository.GetPlanets();
	}

	public List<Planet> GetStars() {
		return _repository.GetStars();
	}

	public List<Planet> GetTerraformPlanets() {
		// Return the list of filtered data from the database.
		List<Planet> planetList = _repository.GetPlanets();

		/*
		 * var results = from p in planetList
		 * where p.IsTerraform == true
		 * select p;
		 */

		List<Planet> results = planetList.stream().filter(p -> p.IsTerraform == true).collect(Collectors.toList());

		return results;
	}

}
