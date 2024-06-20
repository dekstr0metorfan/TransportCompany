import java.util.List;
import java.util.Random;

/**
 * This class is responsible for managing the passenger object
 */
public class Passenger
{
	/**
	 * Passenger's destination
	 */
	private final Station destination;

	/**
	 * Constructs a new Passenger object
	 * @param available_stations stations that are available for passenger
	 */
	public Passenger(List<Station> available_stations)
	{
		Random rand = new Random();
		
		this.destination = available_stations.get(rand.nextInt(available_stations.size()));
	}

	/**
	 * Returns the destination station
	 * @return the destination station
	 */
	public Station get_destination()
	{
		return this.destination;
	}
}