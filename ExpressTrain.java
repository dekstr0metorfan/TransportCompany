public class ExpressTrain extends Train
{
	public ExpressTrain(CityStation start_station, CityStation end_station)
	{
		super(start_station, end_station);
		this.capacity = 800;
		this.speed = 150;
		this.cost = 65;
		this.revenue = 0.13;
		this.number_of_transits = (int) (24 / (this.ROUTE_DISTANCE / this.speed));
	}
}