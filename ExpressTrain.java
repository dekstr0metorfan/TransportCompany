public class ExpressTrain extends Train
{
	public ExpressTrain(CityStation start_station, CityStation end_station)
	{
		super(start_station, end_station);
		this.capacity = 800;
		this.speed = 150;
		this.cost = 20;
		this.revenue = 0.1;
	}
}
