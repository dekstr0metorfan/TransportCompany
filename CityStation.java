import java.util.Random;

/**
 * CityStation inherits from Station.
 * This class is responsible for managing CityStation object.
 */
public class CityStation extends Station
{
    Random random = new Random();

    /**
     * Constructs the CityStation object
     * @param x position on the X axis
     * @param y position on the Y axis
     */
    public CityStation(int x, int y)
    {
        super(x, y);
    }

    /**
     * Method responsible for generating passengers on the station
     * @param graph StationGraph with stations and their connections to other stations
     */
    @Override
    public void generate_passengers(StationGraph graph)
    {
        int number_of_passengers = (int)((random.nextGaussian() + 1) * 2500 + 500);
        
        for (int i = 0; i < number_of_passengers; i++)
        {
            this.passengers.add(new Passenger(graph.stations.get(this)));
        }
    }
}
