package cl.repositorypatterntest.types;

public class Planet {

	public int PlanetId;
	public String Name;
	public boolean IsTerraform;

	public Planet() {
	}

	public Planet(int planetId, String name, boolean isTerraform) {
		PlanetId = planetId;
		Name = name;
		IsTerraform = isTerraform;
	}

}
