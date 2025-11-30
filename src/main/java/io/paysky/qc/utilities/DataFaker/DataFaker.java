package io.paysky.qc.utilities.DataFaker;

import net.datafaker.Faker;

public class DataFaker {

    private final Faker faker;
    public DataFaker() {
        faker = new Faker();
    }
    public String egyMobileNumber(){
        return new String[]{"010", "011", "012", "015"}[faker.random().nextInt(4)]
                + faker.number().digits(8);
    }

    public String fullName(){return faker.name().fullName();}
    public String JobPosition(){return faker.job().position();}
    public String adress(){return faker.address().fullAddress();}
    public String name(){return faker.name().firstName();}
    public String badgeName(){
        String badgematerial = faker.commerce().material();
        String badgeProductName = faker.commerce().productName();
        return badgematerial + ' ' + badgeProductName;
    }

    public String generateEmail(String fullName) {
        String[] nameParts = fullName.split(" ");
        String username = nameParts[0].toLowerCase() + "." + nameParts[nameParts.length - 1].toLowerCase();
        return username + "@example.com";
    }

    public String createNewPIN(){StringBuilder pin = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            // Generate the first digit without any checks
            if (i == 0) {
                pin.append(faker.number().numberBetween(0, 10));
                continue;
            }
            // For subsequent digits, ensure they are not sequential
            int nextDigit;
            do {
                nextDigit = faker.number().numberBetween(0, 10);
            } while (isSequential(pin.charAt(i - 1) - '0', nextDigit));

            pin.append(nextDigit);
        }
        return pin.toString();
    }

    private static boolean isSequential(int prevDigit, int nextDigit) {
        return Math.abs(prevDigit - nextDigit) == 1;
    }
   public String generateEGInvalidMobileNumber(){
       return faker.number().digits(11);
    }

    public String buisnessName() {
        String businessName= faker.company().name();

        // Remove special characters using regex, allowing only letters, numbers, and spaces
        businessName = businessName.replaceAll("[^a-zA-Z0-9 ]", "");

        return businessName;}

    public String email() {
        // Generate a random username and domain name
        String username = faker.name().firstName() + "." + faker.name().lastName();
        String domain = faker.internet().domainName();
        // Combine username and domain with "@" symbol
        return username + "@" + domain;
    }

    public String RandomNumber() {
        int randomNumber = faker.number().numberBetween(0, 101);
        String randomNumberAsString = String.valueOf(randomNumber);

        return  randomNumberAsString;
    }

    public String egyNationalID() {
        // Provided Egyptian National ID regex (adjust as needed)
        String pattern = "([2-3]{1})([0-9]{2})(0[1-9]|1[012])(0[1-9]|[1-2][0-9]|3[0-1])(0[1-4]|[1-2][1-9]|3[1-5]|88)[0-9]{3}([0-9]{1})[0-9]{1}";
        String id = faker.regexify(pattern);
        return id;
    }
}


