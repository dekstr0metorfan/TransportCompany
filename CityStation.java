import java.util.Random;

public class CityStation extends Station
{
    Random random = new Random();
    
    public CityStation(String name, int x, int y)
    {
        super(name, x, y);
    }
    
    @Override
    public void generate_passengers(StationGraph graph)
    {
        int number_of_passengers = (int)random.nextGaussian() * 5000 + 500;
        
        for (int i = 0; i < number_of_passengers; i++)
        {
            this.passengers.add(new Passenger(graph.stations.get(this)));
        }
    }
}
