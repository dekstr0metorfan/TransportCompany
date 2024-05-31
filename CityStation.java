import java.util.Random;

public class CityStation extends Station
{
    Random random = new Random();
    
    public CityStation(int x, int y)
    {
        super(x, y);
    }
    
    @Override
    public void calculate_passengers(int min, int max)
    {
        passengers += random.nextInt((max-min)+1) + min;
    }
}
