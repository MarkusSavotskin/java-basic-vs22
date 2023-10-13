package Week8;

public class Ex11 {

    public interface ToBeStored {
        double weight();
    }

    private static class Book implements ToBeStored {

        private String writer;
        private String name;
        private double weight;

        public Book(String writer, String name, double weight) {
            this.writer = writer;
            this.name = name;
            this.weight = weight;
        }

        public String toString() {
            return this.writer + ": " + this.name;
        }

        @Override
        public double weight() {
            return this.weight;
        }
    }

    private static class CD implements ToBeStored {
        private String artist;
        private String title;
        private int publishingYear;

        public CD(String artist, String title, int publishingYear) {
            this.artist = artist;
            this.title = title;
            this.publishingYear = publishingYear;
        }

        public String toString() {
            return this.artist + ": " + this.title + " (" + this.publishingYear + ")";
        }

        @Override
        public double weight() {
            return 0;
        }
    }

    private static class Box implements ToBeStored {

        private double currentWeight = 0;
        private double maxWeight;
        private int amountOfItems = 0;

        public Box(double maxWeight) {
            this.maxWeight = maxWeight;
        }

        public void add(CD cd) {
            if (this.currentWeight + cd.weight() <= this.maxWeight) {
                this.currentWeight = this.currentWeight + cd.weight();
                this.amountOfItems++;
            }
        }

        public void add(Book book) {
            if (this.currentWeight + book.weight() <= this.maxWeight) {
                this.currentWeight = this.currentWeight + book.weight();
                this.amountOfItems++;
            }
        }

        public String toString() {
            return "Box: " + this.amountOfItems + " things, total weight " + this.currentWeight + " kg";
        }


        @Override
        public double weight() {
            return this.currentWeight;
        }
    }

    public static void main(String[] args) {
        Box box = new Box(10);

        box.add(new Book("Fedor Dostojevski", "Crime and Punishment", 2));
        box.add(new Book("Robert Martin", "Clean Code", 1));
        box.add(new Book("Kent Beck", "Test Driven Development", 0.7));

        box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        box.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        box.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));

        System.out.println(box);
    }
}
