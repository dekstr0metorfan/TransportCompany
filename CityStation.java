import java.util.Random;

public class CityStation extends Station
{
    Random random = new Random();
    
    public CityStation(String name, int x, int y)
    {
        super(name, x, y);
    }
    
    @Override
    public void calculate_passengers(int min, int max)
    {
        passengers += random.nextInt((max-min)+1) + min;
    }
}
