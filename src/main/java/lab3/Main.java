package lab3;


import lab3.hierarchies_animals.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Mammals> MAMMALS_LIST = new ArrayList<>(List.of(
            new CommonHedgehog(),
            new Lynx(),
            new Manul()
    ));

    private static final List<Predatory> PREDATORY_LIST = new ArrayList<>(List.of(
            new Lynx(),
            new Manul()
    ));

    private static final List<Hedgehogs> HEDGEHOGS_LIST = new ArrayList<>(List.of(
            new CommonHedgehog()
    ));

    private static final List<? super Mammals> firstCollection = new ArrayList<>();
    private static final List<? super Feline> secondCollection = new ArrayList<>();
    private static final List<? super Predatory> thirdCollection = new ArrayList<>();


    private static void segregate(
            List<? extends Mammals> mammals,
            List<? super Mammals> firstCollection,
            List<? super Manul> secondCollection,
            List<? super Predatory> thirdCollection
    ) {
        mammals.forEach(item -> {
            if (item instanceof CommonHedgehog) {
                firstCollection.add(item);
            }

            if (item instanceof Lynx) {
                thirdCollection.add((Lynx) (item));
            }

            if (item instanceof Manul) {
                secondCollection.add((Manul) (item));
            }
        });
    }


    public static void main(String[] args) {
        segregate(
                MAMMALS_LIST,
                firstCollection,
                secondCollection,
                thirdCollection
        );

        segregate(PREDATORY_LIST,
                firstCollection,
                secondCollection,
                thirdCollection
        );

        segregate(HEDGEHOGS_LIST,
                firstCollection,
                secondCollection,
                thirdCollection
        );
    }
}
