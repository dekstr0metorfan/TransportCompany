import java.util.ArrayList;
import java.util.List;

public abstract class Station
{
    String name;
    int[] location = new int[2]; //location of the station on a grid in km
    List<Passenger> passengers; //list of passengers on the station

    public Station(String name, int x, int y)
    {
        this.name = name;
        this.location[0] = x;
        this.location[1] = y;
        this.passengers = new ArrayList<>();
    }

    public abstract void generate_passengers(StationGraph graph);
}