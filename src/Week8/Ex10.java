package Week8;

public class Ex10 {

    public interface NationalService {
        int getDaysLeft();

        void work();
    }

    private static class CivilService implements NationalService {
        private int daysLeft;

        public CivilService() {
            this.daysLeft = 362;
        }

        @Override
        public int getDaysLeft() {
            return this.daysLeft;
        }

        @Override
        public void work() {
            if (this.daysLeft >= 0) {
                this.daysLeft--;
            }
        }
    }

    private static class MilitaryService implements NationalService {
        private int daysLeft;

        public MilitaryService(int daysLeft) {
            this.daysLeft = daysLeft;
        }

        @Override
        public int getDaysLeft() {
            return this.daysLeft;
        }

        @Override
        public void work() {
            if (this.daysLeft >= 0) {
                this.daysLeft--;
            }
        }
    }
}
