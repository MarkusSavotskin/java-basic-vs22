package Week7;

import java.util.ArrayList;

public class Ex4 {

    private static class Thing {
        private String name;
        private int weight;

        public Thing(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return this.name;
        }

        public int getWeight() {
            return this.weight;
        }

        public String toString() {
            return this.name + " (" + this.weight + " kg)";
        }
    }

    private static class Suitcase {
        private ArrayList<Thing> things = new ArrayList<>();
        private int maxWeight;
        private int currentWeight;

        public Suitcase(int maxWeight) {
            this.maxWeight = maxWeight;
        }

        public void addThing(Thing thing) {
            if (this.currentWeight + thing.weight <= this.maxWeight) {
                things.add(thing);
                this.currentWeight = this.currentWeight + thing.weight;
            }
        }

        public String toString() {
            if (this.things.size() == 0) {
                return "Empty (" + currentWeight + " kg)";
            } else if (this.things.size() == 1) {
                return this.things.size() + " thing (" + currentWeight + " kg)";
            } else {
                return this.things.size() + " things (" + currentWeight + " kg)";
            }
        }

        public void printThings() {
            for (Thing thing : things) {
                System.out.println(thing.toString());
            }
        }

        public int totalWeight() {
            return this.currentWeight;
        }

        public Thing heaviestThing() {
            if (this.things.isEmpty()) {
                return null;
            } else {
                Thing heaviest = new Thing("-", 0);
                for (Thing thing : things) {
                    if (thing.weight > heaviest.weight) {
                        heaviest = thing;
                    }
                }
                return heaviest;
            }
        }
    }

    private static class Container {
        private ArrayList<Suitcase> suitcases = new ArrayList<>();
        private int maxWeight;
        private int currentWeight;

        public Container(int maxWeight) {
            this.maxWeight = maxWeight;
        }

        public void addSuitcase(Suitcase suitcase) {
            if (this.currentWeight + suitcase.currentWeight <= this.maxWeight) {
                suitcases.add(suitcase);
                this.currentWeight = this.currentWeight + suitcase.currentWeight;
            }
        }

        public String toString() {
            if (this.suitcases.size() == 0) {
                return "Empty (" + currentWeight + " kg)";
            } else if (this.suitcases.size() == 1) {
                return this.suitcases.size() + " suitcase (" + currentWeight + " kg)";
            } else {
                return this.suitcases.size() + " suitcases (" + currentWeight + " kg)";
            }
        }

        public void printThings() {
            for (Suitcase suitcase : suitcases) {
                suitcase.printThings();
            }
        }
    }
    public static void addSuitcasesFullOfBricks(Container container) {
        for (int i = 1; i <= 100; i++) {
            Suitcase suitcase = new Suitcase(100);
            suitcase.addThing(new Thing("Brick", i));
            container.addSuitcase(suitcase);
        }
    }
    public static void main(String[] args) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
}
