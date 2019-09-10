package cl.devweb.designpatterns.repository.types;

public class Planet {

	public int planetId;
	public String name;
	public boolean isTerraform;

	public Planet() {
	}

	public Planet(int planetId, String name, boolean isTerraform) {
		this.planetId = planetId;
		this.name = name;
		this.isTerraform = isTerraform;
	}

}
