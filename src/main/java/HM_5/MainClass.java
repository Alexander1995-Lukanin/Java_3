package HM_5;



public class MainClass {
    public static void main(String[] args)  {
        Race race = new Race(new Road(60), new Tunnel(10, 2), new Road(40));
        race.raceCars();
    }
}
