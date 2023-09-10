package constants;

import com.github.javafaker.Faker;

public class Constants {
    static Faker faker = new Faker();

    public static class Credentials {
        public static String BASE_URL = "https://openweathermap.org/";
        public static String API_URL = "https://openweathermap.org/data/2.5/find";
        public static String APPID = "439d4b804bc8187953eb36d2a8c26a02";
    }

    public static class Values {
        public static String CITY_WITH_ONE_RESULT_LIST = "Pinsk";
        public static String CITY_WITH_MANY_RESULTS_LIST = "London";
        public static String CITY_WITH_FAKE_RESULTS_LIST = "China";

    }

    public static class Xpath {
        public static String BASE_SEARCH_DROPDOWN_XPATH = "//ul [@class='search-dropdown-menu']/li";
    }

    public static class ValuesForCreatingAccount {

        public static String NAME_OF_USER = faker.name().username();
        public static String EMAIL_OF_USER = faker.internet().emailAddress();
        public static String PASSWORD = faker.internet().password();
    }

}
