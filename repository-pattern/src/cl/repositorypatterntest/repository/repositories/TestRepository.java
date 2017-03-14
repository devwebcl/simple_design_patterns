package cl.repositorypatterntest.repository.repositories;

import java.util.ArrayList;
import java.util.List;

import cl.repositorypatterntest.repository.interfaces.IPlanetRepository;
import cl.repositorypatterntest.types.Planet;

public class TestRepository implements IPlanetRepository {

	// region IPlanetRepository Members

	public List<Planet> GetPlanets() {
		// Simulate returning the list of data from the database.
		List<Planet> planetList = new ArrayList<Planet>();

		planetList.add(new Planet(1, "Earth", true));
		planetList.add(new Planet(2, "Test Planet", true));

		return planetList;
	}

	public List<Planet> GetStars() {
		// Simulate returning the list of data from the database.
		List<Planet> planetList = new ArrayList<Planet>();

		planetList.add(new Planet(1, "None", false));

		return planetList;
	}

	// endregion

}
