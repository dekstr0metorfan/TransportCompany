import java.util.*;

/**
 * This class is responsible for managing StationGraph object.
 */
public class StationGraph
{
	/**
	 * HashMap that assigns to each station connections to other stations (routes)
	 */
	public Map<Station, List<Station>> stations;

	/**
	 * Constructs a new StationGraph object
	 */
	public StationGraph()
	{
		stations = new HashMap<>();
	}

	/**
	 * The method responsible for adding new stations to the graph
	 * @param station station to be added
	 */
	public void add_station(Station station)
	{
		stations.put(station, new ArrayList<>());
	}

	/**
	 * The method responsible for adding new route to the graph
	 * @param from starting station
	 * @param to finish station
	 */
	public void add_route(Station from, Station to)
	{
		stations.get(from).add(to);
		stations.get(to).add(from);
	}
}