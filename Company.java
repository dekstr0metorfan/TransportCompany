import java.util.*;

public class Company
{
	double budget;
	StationGraph station_graph;
	List<Train> trains;
	
	public Company()
	{
		this.budget = 0;
		this.station_graph = new StationGraph();
		this.trains = new ArrayList<>();
		
		CityStation A = new CityStation("A",0, 0);
		VillageStation B = new VillageStation("B", 200, 200);
		
		station_graph.add_station(A);
		station_graph.add_station(B);
		station_graph.add_route(A, B);
		
		trains.add(new Train(A, B));
	}
	
	public void simulation(int max_day, double cost_mod, double revenue_mod)
	{
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
		}
	}
}
