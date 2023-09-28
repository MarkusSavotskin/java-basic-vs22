package Week4;

public class Ex75 {

    public static class DecreasingCounter {
        private int value;   // object variable that remembers the value of the counter
        private int startingValue;

        public DecreasingCounter(int valueAtStart) {
            this.value = valueAtStart;
            this.startingValue = valueAtStart;
        }

        public void printValue() {
            System.out.println("value: " + this.value);
        }

        public void decrease() {
            this.value--;
        }

        public void reset() {
            this.value = 0;
        }

        public void setInitial() {
            this.value = startingValue;
        }
    }

    public static void main(String[] args) {
        DecreasingCounter counter = new DecreasingCounter(100);

        counter.printValue();

        counter.decrease();
        counter.printValue();

        counter.decrease();
        counter.printValue();

        counter.reset();
        counter.printValue();

        counter.setInitial();
        counter.printValue();
    }
}
