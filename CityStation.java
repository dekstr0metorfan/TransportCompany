import java.util.Random;

public class CityStation extends Station
{
    Random random = new Random();
    
    public CityStation(String name, int x, int y)
    {
        super(name, x, y);
    }
    
    @Override
    public void generate_passengers()
    {
        passengers += random.nextInt((250-50)+1) + 50; // min 50 max 250
    }
}
