package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {

    }

    private static Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int shift) {
        int random = 3 + (int) (Math.random() * 30);
        String date = LocalDate.now().plusDays(random).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        String[] cities = {"Москва", "Красноярск", "Вологда", "Саратов", "Омск", "Челябинск", "Владивосток", "Мурманск"};
        int n = (int) Math.floor(Math.random() * cities.length);
        String city = cities[n];
        return city;
    }

    public static String generateName(String locale) {
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
            return user;
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }
}