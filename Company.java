import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Company
{
	private double budget;
	private StationGraph station_graph;
	private List<Train> trains;
	
	public Company()
	{
		this.budget = 0;
		this.station_graph = new StationGraph();
		this.trains = new ArrayList<>();
		
		CityStation A = new CityStation("A",0, 0);
		CityStation B = new CityStation("B", 800, 100);
		CityStation C = new CityStation("C", 350, 400);
		VillageStation D = new VillageStation("D", 200, 200);
		VillageStation E = new VillageStation("E", 400, 200);
		VillageStation F = new VillageStation("F", 600, 150);
		
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
	
	public void simulation(int max_day, double cost_mod, double revenue_mod) throws IOException
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
				budget += train.transit(cost_mod, revenue_mod);
			}
			
			fw.append(day + "," + budget + "\n");
			
			if (budget <= 0)
				break;
		}
		
		fw.close();
	}
}
