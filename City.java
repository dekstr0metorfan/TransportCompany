public class City extends Station
{
    public City(String name, int distance)
    {
        super(name, distance);
        this.passengers = calculate_passengers(200, 600);
    }
}
