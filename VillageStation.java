import java.util.Random;

public class VillageStation extends Station
{
    Random random = new Random();

    public VillageStation(String name, int x, int y)
    {
        super(name, x, y);
    }

    @Override
    public void generate_passengers()
    {
        if (passengers>0) {
            resetPassengers();
        }
        passengers += random.nextInt((150) + 1); // min 0 max 150
    }
}
