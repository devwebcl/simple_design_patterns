package cl.repositorypatterntest;

import java.util.List;

import cl.repositorypatterntest.business.PlanetBusiness;
import cl.repositorypatterntest.repository.interfaces.IPlanetRepository;
import cl.repositorypatterntest.repository.repositories.MSSQLPlanetRepository;
import cl.repositorypatterntest.repository.repositories.OracleRepository;
import cl.repositorypatterntest.repository.repositories.TestRepository;
import cl.repositorypatterntest.types.Planet;

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
          TestPlanets(planetBusiness);

          // Load planets from the Oracle repository.
          planetBusiness = new PlanetBusiness(new OracleRepository());
          TestPlanets(planetBusiness);

          // Load planets from the Test repository.
          planetBusiness = new PlanetBusiness(new TestRepository());
          TestPlanets(planetBusiness);

          /*  // Load planets from the default repository as specified in the web.config. Allows for changing the repository at run-time, without changing code!
          //TBC: similar to load values from a properties/yaml file with Spring. removing it for now...
          Type obj = Type.GetType(ConfigurationManager.AppSettings["DefaultRepository"]);
          ConstructorInfo constructor = obj.GetConstructor(new Type[] { });
          IPlanetRepository defaultRepository = (IPlanetRepository)constructor.Invoke(null);

          planetBusiness = new PlanetBusiness(defaultRepository);
          TestPlanets(planetBusiness);*/

          //Console.ReadKey();
      }

      private static void TestPlanets(PlanetBusiness planetBusiness) {
          // Basic driver class to test our planet business class and display output.
          System.out.println();
          System.out.println("Planets:");
          System.out.println();

          List<Planet> planetList = planetBusiness.GetPlanets();
          for (Planet planet : planetList) {
        	  System.out.println(planet.PlanetId + ". " + planet.Name);
          }

          System.out.println();
          System.out.println("Terraformable Planets:");
          System.out.println();

          planetList = planetBusiness.GetTerraformPlanets();
          for (Planet planet : planetList) {
        	  System.out.println(planet.PlanetId + ". " + planet.Name);
          }
      }

}
