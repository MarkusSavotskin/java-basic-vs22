package Week9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ex20  {

    public interface Sensor {
        boolean isOn();  // returns true if the sensor is on
        void on();       // switches the sensor on
        void off();      // switches the sensor off
        int measure();   // returns the sensor reading if the sensor is on
        // if the sensor is off, it throws an IllegalStateException
    }

    private static class ConstantSensor implements Sensor {

        private int number;

        public ConstantSensor(int number) {
            this.number = number;
        }

        @Override
        public boolean isOn() {
            return true;
        }

        @Override
        public void on() {

        }

        @Override
        public void off() {

        }

        @Override
        public int measure() {
            return this.number;
        }
    }

    private static class Thermometer implements Sensor {

        private boolean isOn = true;

        @Override
        public boolean isOn() {
            return this.isOn;
        }

        @Override
        public void on() {
            this.isOn = true;
        }

        @Override
        public void off() {
            this.isOn = false;
        }

        @Override
        public int measure() {
            if (this.isOn()) {
                return new Random().nextInt(30 + 30) - 30;
            } else {
                throw new IllegalArgumentException("The thermometer is off");
            }
        }

    }

    private static class AverageSensor implements Sensor {

        private ArrayList<Sensor> sensors = new ArrayList<>();
        private boolean isOn = true;
        private List<Integer> measurements = new ArrayList<>();

        public void addSensor(Sensor additional) {
            this.sensors.add(additional);
        }

        @Override
        public boolean isOn() {
            int i = 0;
            for (Sensor sensor: sensors) {
                if (!sensor.isOn()) {
                    this.isOn = false;
                    i++;
                }
            }

            if (i == 0) {
                this.isOn = true;
            }
            return this.isOn;
        }

        @Override
        public void on() {
            for (Sensor sensor: sensors) {
                sensor.on();
            }
            isOn = true;
        }

        @Override
        public void off() {
            for (Sensor sensor: sensors) {
                sensor.off();
            }
            isOn = false;
        }

        @Override
        public int measure() {
            int sum = 0;
            int number;
            for (Sensor sensor: this.sensors) {
                number = sensor.measure();
                sum = sum + number;
            }

            number = Math.round(sum / this.sensors.size());
            this.measurements.add(number);
            return number;
        }

        public List<Integer> readings() {
            return this.measurements;
        }
    }

    public static void main(String[] args) {
        Sensor kumpula = new Thermometer();
        Sensor kaisaniemi = new Thermometer();
        Sensor helsinkiVantaa = new Thermometer();

        AverageSensor helsinkiArea = new AverageSensor();
        helsinkiArea.addSensor(kumpula);
        helsinkiArea.addSensor(kaisaniemi);
        helsinkiArea.addSensor(helsinkiVantaa);

        helsinkiArea.on();
        System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
        System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");
        System.out.println("the temperature in Helsinki area is "+helsinkiArea.measure() + " degrees");

        System.out.println("readings: "+helsinkiArea.readings());
    }
}
