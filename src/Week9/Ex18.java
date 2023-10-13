package Week9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex18 {

    public interface Thing {
        int getVolume();
    }

    private static class Item implements Thing, Comparable<Thing> {

        private String name;
        private int volume;

        public Item(String name, int volume) {
            this.name = name;
            this.volume = volume;
        }

        public String getName() {
            return this.name;
        }

        public int getItemVolume() {
            return this.volume;
        }

        public String toString() {
            return this.name + " (" + this.volume + " dm^3)";

        }

        @Override
        public int getVolume() {
            return getItemVolume();
        }

        @Override
        public int compareTo(Thing item) {
            return this.getVolume() - item.getVolume();
        }
    }

    private static class Box implements Thing {

        private int maximumCapacity;
        private ArrayList<Thing> things = new ArrayList<>();

        public Box(int maximumCapacity) {
            this.maximumCapacity = maximumCapacity;
        }


        @Override
        public int getVolume() {
            int currentVolume = 0;
            for (Thing thing: things) {
                currentVolume = currentVolume + thing.getVolume();
            }
            return currentVolume;
        }

        public boolean addThing(Thing thing) {
            if ((this.getVolume() + thing.getVolume()) <= this.maximumCapacity) {
                this.things.add(thing);
                return true;
            } else {
                return false;
            }
        }

        public String toString() {
            return "things in the box: " + this.getVolume() + "dm^3";
        }
    }

    private static class Packer {

        private int boxesVolume;
        private ArrayList<Box> boxes = new ArrayList<>();

        public Packer(int boxesVolume) {
            this.boxesVolume = boxesVolume;
        }

        public List<Box> packThings(List<Thing> things) {
            Box box = new Box(this.boxesVolume);
            for (Thing thing: things) {
                if (!box.addThing(thing)) {
                    this.boxes.add(box);
                    box = new Box(this.boxesVolume);
                    box.addThing(thing);
                }
            }
            boxes.add(box);
            return this.boxes;
        }
    }

    public static void main(String[] args) {
        // the things we want to pack
        List<Thing> things = new ArrayList<Thing>();
        things.add(new Item("passport", 2));
        things.add(new Item("toothbrush", 1));
        things.add(new Item("book", 4));
        things.add(new Item("circular saw", 8));

        // we create a packer which uses boxes whose valume is 10
        Packer packer = new Packer(10);

        // we ask our packer to pack things into boxes
        List<Box> boxes = packer.packThings( things );

        System.out.println("number of boxes: "+boxes.size());

        for (Box box : boxes) {
            System.out.println("  things in the box: "+box.getVolume()+" dm^3");
        }
    }
}
