import java.util.List;
import java.util.Random;

public class Passenger
{
	private final Station destination;
	
	public Passenger(List<Station> available_stations)
	{
		Random rand = new Random();
		
		this.destination = available_stations.get(rand.nextInt(available_stations.size()));
	}
	
	public Station get_destination()
	{
		return this.destination;
	}
}