package lab3;


import lab3.hierarchies_animals.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final List<Mammals> MAMMALS_LIST = new ArrayList<>(List.of(
            new CommonHedgehog(),
            new Lynx(),
            new Manul()
    ));

    private static final List<Hedgehogs> HEDGEHOGS_LIST = Collections.emptyList();
    private static final List<Feline> FELINE_LIST = Collections.emptyList();
    private static final List<Predatory> PREDATORY_LIST = Collections.emptyList();

    private static void segregate(
            List<? extends Mammals> mammals,
            List<CommonHedgehog> collection1,
            List<Predatory> collection2,
            List<Predatory> collection3
    ) {
        Logger.getLogger("MyTag").log(Level.INFO, "firstSegregate");
        mammals.forEach(item -> {
            Class<? extends Mammals> itemClass = item.getClass();
            int cnt = 0;
            if (Hedgehogs.class.isAssignableFrom(itemClass) ) {
                //add
                cnt++;
            }

            if (Insectivores.class.isAssignableFrom(itemClass) ) {
                if(cnt > 0) {
                    ///
                } else {

                }
            }

            if (Chordal.class.isAssignableFrom(itemClass)) {
                if(cnt > 0) {
                    ///
                } else {

                }
            }


            if (Feline.class.isAssignableFrom(itemClass) ||
                    Manul.class.isAssignableFrom(itemClass) ||
                    Predatory.class.isAssignableFrom(itemClass)) {

            }
        });
    }


    public static void main(String[] args) {
    }
}
