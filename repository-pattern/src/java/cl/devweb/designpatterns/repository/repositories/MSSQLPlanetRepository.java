package cl.devweb.designpatterns.repository.repositories;

import java.util.ArrayList;
import java.util.List;

import cl.devweb.designpatterns.repository.interfaces.IPlanetRepository;
import cl.devweb.designpatterns.repository.types.Planet;

public class MSSQLPlanetRepository implements IPlanetRepository {

	   //region IPlanetRepository Members

       public List<Planet> getPlanets()  {
           // Simulate returning the list of data from the database.
           List<Planet> planetList = new ArrayList<Planet>();

           // SqlConnection code would actually go here, this is to keep things simple.
           planetList.add(new Planet(1, "Mercury", false));
           planetList.add(new Planet(2, "Venus", true));
           planetList.add(new Planet(3, "Earth", true));
           planetList.add(new Planet(4, "Mars", true));
           planetList.add(new Planet(5, "Jupiter", false));
           planetList.add(new Planet(6, "Saturn", false));
           planetList.add(new Planet(7, "Uranus", false));
           planetList.add(new Planet(8, "Neptune", false));
           planetList.add(new Planet(9, "Pluto", false));

           return planetList;
       }

       public List<Planet> getStars() {
           // Simulate returning the list of data from the database.
           List<Planet> planetList = new ArrayList<Planet>();

           // SqlConnection code would actually go here, this is to keep things simple.
           planetList.add(new Planet(1, "Sun", false));

           return planetList;
       }

       //endregion

}
