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
        int number_of_passengers = random.nextInt((250-50)+1) + 50; // min 50 max 250
        
        for (int i = 0; i < number_of_passengers; i++)
        {
            this.passengers.add(new Passenger(graph.stations.get(this)));
        }
    }
}
