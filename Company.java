import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * This class is responsible for constructing Company object
 * and running the simulation.
 */
public class Company
{
	/**
	 * Budget of the Company
	 */
	private double budget;
	/**
	 * Graph with stations and routes
	 */
	private StationGraph station_graph;
	/**
	 * List containing all trains
	 */
	private List<Train> trains;

	/**
	 * Constructs a new Company object
	 */
	public Company()
	{
		this.budget = 100000;
		this.station_graph = new StationGraph();
		this.trains = new ArrayList<>();
		
		CityStation A = new CityStation(0, 0);
		CityStation B = new CityStation(800, 100);
		CityStation C = new CityStation(350, 400);
		VillageStation D = new VillageStation(200, 200);
		VillageStation E = new VillageStation(400, 200);
		VillageStation F = new VillageStation(600, 150);
		
		station_graph.add_station(A);
		station_graph.add_station(B);
		station_graph.add_station(C);
		station_graph.add_station(D);
		station_graph.add_station(E);
		station_graph.add_station(F);
		
		station_graph.add_route(A, B);
		station_graph.add_route(A, C);
		station_graph.add_route(A, D);
		station_graph.add_route(B, C);
		station_graph.add_route(B, F);
		station_graph.add_route(C, D);
		station_graph.add_route(C, E);
		station_graph.add_route(D, E);
		station_graph.add_route(E, F);
		
		
		trains.add(new ExpressTrain(A, B));
		trains.add(new ExpressTrain(A, C));
		trains.add(new ExpressTrain(B, C));
		
		trains.add(new RegionalTrain(A, D));
		trains.add(new RegionalTrain(B, F));
		trains.add(new RegionalTrain(C, D));
		trains.add(new RegionalTrain(C, E));
		trains.add(new RegionalTrain(D, E));
		trains.add(new RegionalTrain(E, F));

    }

	/**
	 * The method responsible for carrying out the simulation
	 * @param max_day maximum number of days for which the simulation lasts
	 * @param revenue_mod revenue modifier
	 * @param cost_mod cost modifier
	 * @throws IOException if any problems related to input/output operations happens
	 */
	public void simulation(int max_day, double revenue_mod, double cost_mod) throws IOException
	{
		FileWriter fw = new FileWriter("results.csv");
		
		for (int day = 1; day <= max_day; day++)
		{
			for (Station station : this.station_graph.stations.keySet())
			{
				station.generate_passengers(this.station_graph);
			}
			
			for (Train train : this.trains)
			{
				budget += train.transit(revenue_mod, cost_mod);
			}
			
			fw.append(day + "," + budget + "\n");
			
			if (budget <= 0)
				break;
		}
		
		fw.close();
	}

}
