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
        System.out.println("Podaj jaki ma byc przychod na kilometr przejazdu pociagu: ");
        int revenue = scanner.nextInt();

        Station A = new Station("A", 200, 0);
        Station B = new Station("B", 300, 100);

        Train train1 = new Train("A1", 2, 100);
        Train train2 = new Train("A2", 2, 120);

        for(int i = 0; i < day; i++)
        {
            budget += Train.transit(train1, A, B, revenue);
            budget += Train.transit(train2, B, A, revenue);
        }

        System.out.println("W trakcie trwania symulacji osiagnieto profit: " + budget);
    }
}