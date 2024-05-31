import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double budget = 0;
        //int number_of_trains = 0;

        System.out.println("Podaj liczbe dni, dla ktorych ma sie wykonac symulacja: ");
        int day = scanner.nextInt();
        System.out.println("Podaj jaka ma byc cena biletu: ");
        int revenue = scanner.nextInt();

        CityStation CityA = new CityStation("CityA", 0);
        CityStation CityB = new CityStation("CityB", 200);

        Train train1 = new Train("A1", 2, 100);
        Train train2 = new Train("A2", 3, 120);

        for(int i = 0; i < day; i++)
        {
            System.out.println("Numer przejazdu: " + i);
            budget += Train.transit(train1, CityA, CityB, revenue);
            System.out.println("Pasazerowie w miescie A:" + CityA.passengers);
            System.out.println("Budzet po tym przejezdzie:" + budget);
        }

        System.out.println("W trakcie trwania symulacji osiagnieto profit: " + budget);
    }
}