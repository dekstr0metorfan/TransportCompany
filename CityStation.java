import java.util.Random;

public class CityStation extends Station
{
    Random random = new Random();
    
    public CityStation(int x, int y)
    {
        super(x, y);
    }
    
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
