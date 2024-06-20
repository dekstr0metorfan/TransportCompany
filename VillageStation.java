import java.util.Random;

/**
 * VillageStation inherits from Station.
 * This class is responsible for managing VillageStation object.
 */
public class VillageStation extends Station
{
    Random random = new Random();

    /**
     * Constructs the VillageStation object
     * @param x position on the X axis
     * @param y position on the Y axis
     */
    public VillageStation(int x, int y)
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
        int number_of_passengers = random.nextInt((900) + 100);
        
        for (int i = 0; i < number_of_passengers; i++)
        {
            this.passengers.add(new Passenger(graph.stations.get(this)));
        }
    }
}
