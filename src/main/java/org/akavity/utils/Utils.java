package org.akavity.utils;

import com.codeborne.selenide.ElementsCollection;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j2
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
            result = Double.parseDouble(matcher.group().replace(" ", "").replace(",", "."));
        }
        return result;
    }

    public String getRandomBirthday() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1960, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2004, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return randomBirthDate.format(formatter);
    }

    public String getFakeFullName() {
        Faker faker = new Faker();
        return faker.name().fullName();
    }

    public boolean doesListContainText(List<String> desc, String text) {
        boolean result;
        log.info("List size: " + desc.size());
        if (desc.isEmpty()) {
            log.info("List is empty");
            result = false;
        } else {
            result = desc.stream()
                    .peek(d -> log.info("Description: " + d))
                    .allMatch(description -> description.contains(text));
        }
        return result;
    }

    public boolean arePricesLowerThanPrice(ElementsCollection prices, int price, int elements) {
        sleep(1500);
        log.info("Check that the price of products is higher than a specific price");
        ElementsCollection collection = prices.first(elements);
        boolean result;
        if (collection.isEmpty()) {
            log.info("Collection is empty");
            result = false;
        } else {
            result = collection.asDynamicIterable()
                    .stream()
                    .map(el -> extractDoubleFromText(el.getText(), "\\d?[ ]?\\d+[,.]\\d{2}"))
                    .peek(p -> log.info("Element price: " + p))
                    .allMatch(p -> (p <= price));
        }
        return result;
    }

    public boolean arPricesHigherThanPrice(ElementsCollection prices, int price, int elements) {
        sleep(1500);
        log.info("Check that the price of products is higher than a specific price");
        ElementsCollection collection = prices.first(elements);
        boolean result;
        if (collection.isEmpty()) {
            log.info("Collection is empty");
            result = false;
        } else {
            result = collection.asDynamicIterable()
                    .stream()
                    .map(el -> extractDoubleFromText(el.getText(), "\\d?[ ]?\\d+[,.]\\d{2}"))
                    .peek(p -> log.info("Element price: " + p))
                    .allMatch(p -> (p >= price));
        }
        return result;
    }

    public boolean arePricesWithinLimit(ElementsCollection prices, int min, int max, int elements) {
        log.info("Check product prices \n min price: " + min + "\n max price: " + max);
        ElementsCollection collection = prices.first(elements);
        boolean result;
        if (collection.isEmpty()) {
            log.info("Collection is empty");
            result = false;
        } else {
            result = collection.asDynamicIterable()
                    .stream()
                    .map(el -> extractDoubleFromText(el.getText(), "\\d+[,]\\d{2}"))
                    .peek(p -> log.info("Element price: " + p))
                    .allMatch(p -> (p >= min && p <= max));
        }
        return result;
    }
}
