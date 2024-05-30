public class Village extends Station
{
    public Village(String name, int distance)
    {
        super(name, distance);
        this.passengers = calculate_passengers(0, 200);
    }
}
