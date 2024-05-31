import java.util.Random;

public class VillageStation extends Station
{
    Random random = new Random();
    
    public VillageStation(String name, int x, int y)
    {
        super(name, x, y);
    }
    
    @Override
    public void calculate_passengers(int min, int max)
    {
        passengers += random.nextInt((max-min)+1) + min;
    }
}
