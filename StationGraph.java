import java.util.*;

public class StationGraph
{
	Map<Station, List<Station>> stations;
	
	public StationGraph()
	{
		stations = new HashMap<>();
	}
	
	public void add_station(Station station)
	{
		stations.put(station, new ArrayList<>());
	}
	
	public void add_route(Station from, Station to)
	{
		stations.get(from).add(to);
		stations.get(to).add(from);
	}
}