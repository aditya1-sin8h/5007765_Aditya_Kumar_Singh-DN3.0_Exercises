public class FinancialForecasting {
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue; // Base case
        } else {
            // Recursive case
            return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
        }
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial investment
        double growthRate = 0.05; // 5% annual growth rate
        int years = 10; // Number of years

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("The future value of the investment is: %.2f\n", futureValue);
    }
}
