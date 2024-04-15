package org.akavity.utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public double extractDoubleFromText(String text, String regex) {
        double result = 0.0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            result = Double.parseDouble(matcher.group().replace(",", "."));
        }
        return result;
    }

    public String getRandomBirthDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1960, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2004, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");   // применяем нужный паттерн датыStr
        // String textDate = randomBirthDate.format(formatter); вывести в нужном формате
        // LocalDate parsedDate = LocalDate.parse(text, formatter); перевести в LocalDate
        return randomBirthDate.format(formatter);
    }

    public String getFakeFullName() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
//        String firstName = faker.name().firstName();
//        String lastName = faker.name().lastName();
//        String streetAddress = faker.address().streetAddress();
        return name;
    }
}
