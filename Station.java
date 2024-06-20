import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class is responsible for creating Station object.
 * CityStation and VillageStation classes inherit from this class.
 */
public abstract class Station
{
    /**
     * Location of the station on a grid in kilometers
     */
    int[] location = new int[2];
    /**
     * List of passengers on the station
     */
    List<Passenger> passengers;

    /**
     * Constructs the Station object
     * @param x position on the X axis
     * @param y position on the Y axis
     */
    public Station(int x, int y)
    {
        this.location[0] = x;
        this.location[1] = y;
        this.passengers = new ArrayList<>();
    }

    /**
     * Abstract method responsible for generating passengers on the station
     * @param graph StationGraph with stations and their connections to other stations
     */
    public abstract void generate_passengers(StationGraph graph);
}