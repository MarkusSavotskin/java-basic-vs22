package Week5;

import static java.lang.Math.abs;

public class Ex87 {
    public static class Apartment {
        private int rooms;
        private int squareMeters;
        private int pricePerSquareMeter;

        public Apartment(int rooms, int squareMeters, int pricePerSquareMeter){
            this.rooms = rooms;
            this.squareMeters = squareMeters;
            this.pricePerSquareMeter = pricePerSquareMeter;
        }

        public boolean larger(Apartment apartment) {
            return squareMeters > apartment.squareMeters;
        }

        public int priceDifference(Apartment apartment) {
            return abs((pricePerSquareMeter * squareMeters) - (apartment.pricePerSquareMeter * apartment.squareMeters));
        }

        public boolean moreExpensiveThan(Apartment apartment) {
            return (pricePerSquareMeter * squareMeters) > (apartment.pricePerSquareMeter * apartment.squareMeters);
        }
    }

    public static void main(String[] args) {
        Apartment studioManhattan = new Apartment(1, 16, 5500);
        Apartment twoRoomsBrooklyn = new Apartment(2, 38, 4200);
        Apartment fourAndKitchenBronx = new Apartment(3, 78, 2500);

        System.out.println( studioManhattan.larger(twoRoomsBrooklyn) );       // false
        System.out.println( fourAndKitchenBronx.larger(twoRoomsBrooklyn) );   // true
        System.out.println();

        System.out.println( studioManhattan.priceDifference(twoRoomsBrooklyn) );        // 71600
        System.out.println( fourAndKitchenBronx.priceDifference(twoRoomsBrooklyn) );    // 35400
        System.out.println();

        System.out.println( studioManhattan.moreExpensiveThan(twoRoomsBrooklyn) );       // false
        System.out.println( fourAndKitchenBronx.moreExpensiveThan(twoRoomsBrooklyn) );   // true
    }
}
