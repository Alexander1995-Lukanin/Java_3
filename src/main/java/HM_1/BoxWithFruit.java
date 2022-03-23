package HM_1;


import java.util.ArrayList;
import java.util.stream.Collectors;

public class BoxWithFruit<T  extends Fruit> {
    private ArrayList fruitsBox = new ArrayList();
    float weightBox;

    void getWeight(T typeFruit) {
        for (int i = 0; i < fruitsBox.size(); i++) {
            if (typeFruit instanceof Apple) {
                weightBox = 1.0f * fruitsBox.size();
            } else weightBox = 1.5f * fruitsBox.size();
        }
        System.out.println(weightBox);
    }

    void putFruit(T typeFruit) {
        fruitsBox.add(typeFruit);
        System.out.println(fruitsBox.toString());
    }

    boolean compare(BoxWithFruit<T> boxWithFruit1, BoxWithFruit<T> boxWithFruit2) {
        return (boxWithFruit1.getWeightBox() == boxWithFruit2.getWeightBox());
    }

    void pourOverTheFruit(BoxWithFruit<T> boxPourOverTheFruit) {
        fruitsBox = (ArrayList<T>) boxPourOverTheFruit.getFruitsBox().stream().collect(Collectors.toList());
        System.out.println(fruitsBox);
    }

    public float getWeightBox() {
        return weightBox;
    }

    public ArrayList getFruitsBox() {
        return fruitsBox;
    }
}




