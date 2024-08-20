package tek.tdd.utility;

public class DataGenerator {

    public static String RandomEmailGenerator(String name) {

        int randomNumber = (int) (Math.random() * 10000);
        return name + randomNumber + "@gmail.com";
    }
}
