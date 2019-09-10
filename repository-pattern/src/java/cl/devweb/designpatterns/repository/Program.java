package cl.devweb.designpatterns.repository;

import java.util.List;

import cl.devweb.designpatterns.repository.business.PlanetBusiness;
import cl.devweb.designpatterns.repository.interfaces.IPlanetRepository;
import cl.devweb.designpatterns.repository.repositories.MSSQLPlanetRepository;
import cl.devweb.designpatterns.repository.repositories.OracleRepository;
import cl.devweb.designpatterns.repository.repositories.TestRepository;
import cl.devweb.designpatterns.repository.types.Planet;

/**
 * Java example from:
 * http://www.primaryobjects.com/2009/08/13/implementing-the-repository-design-pattern-in-c-asp-net/
 *
 * Another popular Java example is:
 * https://thinkinginobjects.com/2012/08/26/dont-use-dao-use-repository/
 *
 *
 * @author German
 *
 */

public class Program {

	  public static void main(String[] args) {

          // Load planets from the MSSQL repository.
          PlanetBusiness planetBusiness = new PlanetBusiness(new MSSQLPlanetRepository());
          testPlanets(planetBusiness);

          // Load planets from the Oracle repository.
          planetBusiness = new PlanetBusiness(new OracleRepository());
          testPlanets(planetBusiness);

          // Load planets from the Test repository.
          planetBusiness = new PlanetBusiness(new TestRepository());
          testPlanets(planetBusiness);

          /*  // Load planets from the default repository as specified in the web.config. Allows for changing the repository at run-time, without changing code!
          //TBC: similar to load values from a properties/yaml file with Spring. removing it for now...
          Type obj = Type.GetType(ConfigurationManager.AppSettings["DefaultRepository"]);
          ConstructorInfo constructor = obj.GetConstructor(new Type[] { });
          IPlanetRepository defaultRepository = (IPlanetRepository)constructor.Invoke(null);

          planetBusiness = new PlanetBusiness(defaultRepository);
          TestPlanets(planetBusiness);*/

          //Console.ReadKey();
      }

      private static void testPlanets(PlanetBusiness planetBusiness) {
          // Basic driver class to test our planet business class and display output.
          System.out.println();
          System.out.println("Planets:");
          System.out.println();

          List<Planet> planetList = planetBusiness.getPlanets();
          for (Planet planet : planetList) {
        	  System.out.println(planet.planetId + ". " + planet.name);
          }

          System.out.println();
          System.out.println("Terraformable Planets:");
          System.out.println();

          planetList = planetBusiness.getTerraformPlanets();
          for (Planet planet : planetList) {
        	  System.out.println(planet.planetId + ". " + planet.name);
          }
      }

}
