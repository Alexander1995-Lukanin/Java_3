package HM_5;

import HM_7.BeforeSuite;
import HM_7.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Race extends Thread {
    public static final int CARS_COUNT = 4;
    private int finishCount;
    private ArrayList<Stage> stages;
    static Thread thread;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        this.stages = new ArrayList<>(Arrays.asList(stages));

    }


    @Test(priority = 1)
    public synchronized void finish(Car car) {

        if (finishCount++ == 0) {
            System.out.printf("Победитель: %s\n", car.getName());
        } else {
            System.out.printf("%s пришел %sм\n", car.getName(), finishCount);
        }

    }
    @BeforeSuite
    public void raceCars () {
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(this, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread (cars[i]).start();

        }



    }
}