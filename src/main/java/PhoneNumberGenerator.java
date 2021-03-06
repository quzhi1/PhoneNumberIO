import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by zhiqu on 7/1/16.
 */
public class PhoneNumberGenerator {

    private final static ArrayList<Character> illegalChars
        = new ArrayList<Character>(Arrays.asList('(', ')', '*', '^', '#', '-', '_', '+'));
    private final static Random randomGenerator = new Random();
    private final static int numOfPhones = 100;

    public PhoneNumberGenerator() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < numOfPhones; i++) {
            System.out.println(constructPhoneNum());
        }
    }

    private static int randomDigit() {
        return randomGenerator.nextInt(10);
    }

    private static boolean randomBoolean() {
        return randomGenerator.nextBoolean();
    }

    private static char randomIllegalChar() {
        return illegalChars.get(randomGenerator.nextInt(illegalChars.size()));
    }

    private static String constructPhoneNum() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(randomIllegalChar());
        for (int i = 0; i < 13; i++) {
            if (randomDigit() > 3) {
                stringBuilder.append(randomDigit());
            } else {
                stringBuilder.append(randomIllegalChar());
            }
        }
        return stringBuilder.toString();
    }
}
