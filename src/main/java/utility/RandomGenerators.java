package utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerators {
    private static final Random random = new Random();

    public static int generateRandomNumber() {
        return random.nextInt(6) + 1;
    }

    // Generate valid first name
    public static String generateRandomFirstName() {
        Random random = new Random();
        String[] FIRST_NAMES = {"John", "Jane", "Michael", "Emily", "Chris", "Sarah"};
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        return firstName.length() <= 32 ? firstName : firstName.substring(0, 32);
    }

    // Generate valid last name
    public static String generateRandomLastName() {
        Random random = new Random();
        String[] LAST_NAMES = {"Doe", "Smith", "Johnson", "Williams", "Jones", "Brown"};
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return lastName.length() <= 32 ? lastName : lastName.substring(0, 32);
    }

    public static String generatePostalCode() {
        Random random = new Random();
        // Generate a random 5-digit postal code
        return String.format("%05d", random.nextInt(100000));
    }

    public static List<Integer> generateUniqueRandomNumbers(int count, int max) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size() < count) {
            int number = random.nextInt(max) + 1; // Ensure within range (1 to max)
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static double trimFirstCharAndConvertToDouble(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }
        // Trim the first character from the string
        String trimmedString = input.substring(1);
        // Convert the trimmed string to a double
        double value = Double.parseDouble(trimmedString);
        return value;
    }
}