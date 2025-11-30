package io.paysky.qc.utilities.sharedComponent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.Random;

import static io.paysky.qc.utilities.selenium.DriverFactory.driver;

public class SharedComponent {
    WebDriver driver;

    public static String GetRandomNumber() throws IOException {
        String TestFile = System.getProperty("user.dir")+ File.separator +"resources"+File.separator+"d.txt";
        FileReader FR = new FileReader(TestFile);
        BufferedReader BR = new BufferedReader(FR);
        String t = BR.readLine();
        FileWriter FW = new FileWriter(TestFile);
        BufferedWriter BW = new BufferedWriter(FW);
        int newNumberInt = Integer.parseInt(t);
        String newNumberValue = Integer.toString(++newNumberInt);
        BW.write(newNumberValue);
        BW.close();
        return newNumberValue;
    }

    public static String getRandomNumberString() {
        // It will generate 10 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999999);
        // this will convert any number sequence into 10 character.
        return String.format("%010d", number);
    }

    public final class DefaultPasswordGenerator {
        private final String[] charCategories = new String[] {
                "abcdefghijklmnopqrstuvwxyz",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "0123456789",
                "@#&"
        };

        public String generate(int length) {
            StringBuilder password = new StringBuilder(length);
            Random random = new Random(System.nanoTime());

            for (int i = 0; i < length; i++) {
                String charCategory = charCategories[random.nextInt(charCategories.length)];
                int position = random.nextInt(charCategory.length());
                password.append(charCategory.charAt(position));
            }

            return new String(password);
        }

        public void scrollDown(){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        }

        public  void scrollToElement(WebDriver driver, WebElement element) {   
            JavascriptExecutor js = (JavascriptExecutor) driver;   
            js.executeScript("arguments[0].scrollIntoView(true);", element);}
    }
}
