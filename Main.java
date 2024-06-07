import java.util.*;
//klasa firmy??? - dobry pomysł
//statystyki generowac dzien po dniu, wrzucic je do excela, prezentowac wykresy
//jak zmieniajac parametry startowe ten wykres bedzie sie ksztaltowal
//za dwa tygodnie prezentacja - jakie efekty uzyskalismy przy jakich warunkach
//przygotowac wstepne statystyki zeby pdoac je do tego programu
//inne excele miec przygotowane
//na prezentacje mamy 10 min
//dokumentacja na za dwa tygodnie
//ladny pdf, strona tytulowa, spis tresci
//o czym jest nasz program - zalozenia, sa pociagi, stacje, grafy, pasazerowie itp opisujemy
//opis samego kodu
//trzeba w opisie kodu pokryc 5 pkt z eportalu (definicje klas, hermetyzacja itp)
//hermetyzacja - co to jest, jak sie to stosuje, przyklad na naszej klasie i po co ja zastosowalismy
//dziedziczenie - wybieramy fragment ze stacja (stacja wioskowa i miejska), trzeba napisac ze to dziedziczenie
//kompozycja, agregacja - tak samo
//polimorfizm - mamy dziedziczenie, mamy klase abstrakcyjna, gdzies mamy liste ktora zawiera w sobie te
//klasy abstrakcyjne i gdzies ta lista jest zapelniana (lista stacji) przechowujemy tam rozne implementacje
//klasy abstrakcyjnej
//potem trzeba pokazac miejsce w ktorym ta lista jest uzywana
//zakonczyc doku slowem zakonczenia, wnioskami (np. jakie parametry trzeba dac zeby byl jakis wymagany efekt)
//wrzucic na eportal, za tydzien sa nieobowiazkowe konsultacje
//diagram sekwencji klas obiektow maszyna stanow - pokazac za tydzien
public class Main
{
    public static void main(String[] args)
    {
        double budget = 0;
        
        
        StationGraph station_graph = new StationGraph();
        
        CityStation A = new CityStation("A",0, 0);
        VillageStation B = new VillageStation("B", 200, 200);
        
        station_graph.add_station(A);
        station_graph.add_station(B);
        station_graph.add_route(A, B);
        

        ArrayList<Train> trains = new ArrayList<>();
        trains.add(new Train(A, B));
        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the max simulation time [days]: ");
        int max_day = scanner.nextInt();
        
        System.out.print("Enter the revenue modifier: ");
        double revenue_mod = scanner.nextDouble();

        System.out.print("Enter the cost modifier: ");
        double cost_mod = scanner.nextDouble();

        for (int day = 1; day <= max_day; day++)
        {
            System.out.println("Simulation day: " + day);

            for (Station station : station_graph.stations.keySet())
            {
                station.generate_passengers(station_graph); //caly graf czy lista???
            }

            for (Train train : trains)
            {
                budget += train.transit(cost_mod, revenue_mod);
            }
            
            System.out.println("People on station A: " + A.passengers.size());
            System.out.println("People on station B: " + B.passengers.size());
            System.out.println("Budget at the end of day: " + budget + "\n");
        }

        System.out.println("Total company profit: " + budget);
    }
}