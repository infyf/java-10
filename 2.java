import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Лістинг коду 1: Перевірити, чи містить потік елемент із заданим значенням певного поля.
        List<FoodDelivery> foodDeliveries1 = List.of(
                new FoodDelivery("bread"),
                new FoodDelivery("apple"),
                new FoodDelivery("pizza")
        );

        String targetFoodItem1 = "pizza";
        List<FoodDelivery> filteredList1 = foodDeliveries1.stream()
                .filter(delivery -> delivery.getFoodItem().equals(targetFoodItem1))
                .collect(Collectors.toList());

        // Виведемо результат
        System.out.println("Filtered List 1:");
        if(filteredList1.isEmpty()) {
            System.out.println("No items found.");
        } else {
            filteredList1.forEach(System.out::println);
        }

        // Лістинг коду 2: Фільтрувати елементи за полем-рядком, щоб включити лише ті, що починаються з певної літери.
        List<FoodDelivery> foodDeliveries2 = List.of(
                new FoodDelivery("bread"),
                new FoodDelivery("apple"),
                new FoodDelivery("pizza")
        );

        // Приклад фільтрації за першою літерою поля foodItem
        char targetLetter = 'b';
        List<FoodDelivery> filteredList2 = foodDeliveries2.stream()
                .filter(delivery -> delivery.getFoodItem().charAt(0) == targetLetter)
                .collect(Collectors.toList());

        System.out.println("\nFiltered List 2:");
        filteredList2.forEach(System.out::println);

        // Лістинг коду 3: Фільтрувати елементи на основі заданого діапазону для певного поля.
        List<FoodDelivery> foodDeliveries3 = List.of(
                new FoodDelivery("bread"),
                new FoodDelivery("saladdddd"),
                new FoodDelivery("pizza")
        );

        // Приклад фільтрації за довжиною поля foodItem
        int minFoodItemLength = 5;
        int maxFoodItemLength = 7;
        List<FoodDelivery> filteredList3 = foodDeliveries3.stream()
                .filter(delivery -> delivery.getFoodItem().length() >= minFoodItemLength &&
                        delivery.getFoodItem().length() <= maxFoodItemLength)
                .collect(Collectors.toList());

        // Виведемо результат
        System.out.println("\nFiltered List 3:");
        filteredList3.forEach(System.out::println);

        // Лістинг коду 4: Фільтрувати елементи з використанням композиції предикатів.
        List<FoodDelivery> foodDeliveries4 = List.of(
                new FoodDelivery("bread"),
                new FoodDelivery("apple"),
                new FoodDelivery("hamburge")
        );

        Predicate<FoodDelivery> startsWithH = delivery -> delivery.getFoodItem().startsWith("h");
        Predicate<FoodDelivery> foodItemLengthGreaterThan3 = delivery -> delivery.getFoodItem().length() > 3;

        List<FoodDelivery> filteredList4 = foodDeliveries4.stream()
                .filter(startsWithH.and(foodItemLengthGreaterThan3))
                .collect(Collectors.toList());

        // Виведемо результат
        System.out.println("\nFiltered List 4:");
        if(filteredList4.isEmpty()) {
            System.out.println("No items found.");
        } else {
            filteredList4.forEach(System.out::println);
        }
    }
}

class FoodDelivery {
    private String foodItem;

    public FoodDelivery(String foodItem) {
        this.foodItem = foodItem;
    }

    public String getFoodItem() {
        return foodItem;
    }

    @Override
    public String toString() {
        return "FoodDelivery [foodItem=" + foodItem + "]";
    }
}
Лістинг коду: 2 частина завдання 
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class FoodDelivery {
    private String name;
    private int rating;

    public FoodDelivery(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "FoodDelivery{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<FoodDelivery> foodDeliveries = List.of(
                new FoodDelivery("хліб", 5),
                new FoodDelivery("яблуко", 3),
                new FoodDelivery("піца", 8)
        );

        // a) Знайти елемент з максимальним значенням за певним числовим полем
        FoodDelivery maxDelivery = foodDeliveries.stream()
                .max(Comparator.comparingInt(FoodDelivery::getRating))
                .orElse(null);
        System.out.println("Максимально оцінена доставка їжі:");
        System.out.println("Ім'я: " + maxDelivery.getName());
        System.out.println("Рейтинг: " + maxDelivery.getRating());

        // b) Сортувати потік елементів за певним полем у зворотньому порядку з використанням власного компаратора
        Comparator<FoodDelivery> ratingComparator = Comparator.comparingInt(FoodDelivery::getRating).reversed();
        List<FoodDelivery> sortedByRating = foodDeliveries.stream()
                .sorted(ratingComparator)
                .collect(Collectors.toList());
        System.out.println("\nВідсортовано за оцінкою в зворотньому порядку:");
        for (FoodDelivery delivery : sortedByRating) {
            System.out.println("Ім'я: " + delivery.getName() + ", Рейтинг: " + delivery.getRating());
        }

        // c) Сортувати потік елементів за двома полями
        Comparator<FoodDelivery> nameAndRatingComparator = Comparator.comparing(FoodDelivery::getName)
                .thenComparing(Comparator.comparingInt(FoodDelivery::getRating));
        List<FoodDelivery> sortedByNameAndRating = foodDeliveries.stream()
                .sorted(nameAndRatingComparator)
                .collect(Collectors.toList());
        System.out.println("\nВідсортовано за іменем та оцінкою:");
        for (FoodDelivery delivery : sortedByNameAndRating) {
            System.out.println("Ім'я: " + delivery.getName() + ", Рейтинг: " + delivery.getRating());
        }
    }
}
Лістинг коду: 3 частина завдання 
import java.util.List;
import java.util.stream.Collectors;

class FoodDelivery {
    private String name;
    private int rating;

    public FoodDelivery(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "FoodDelivery{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    public int getNameLength() {
        return name.length();
    }

    public int getRatingSquared() {
        return rating * rating;
    }
}

public class Main {
    public static void main(String[] args) {
        List<FoodDelivery> foodDeliveries = List.of(
                new FoodDelivery("роли", 5),
                new FoodDelivery("сушші", 3),
                new FoodDelivery("салат", 8)
        );

        // a) Перетворити об’єкти у рядки (включити всі поля в рядок).
        List<String> strings = foodDeliveries.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        System.out.println("Рядки:");
        strings.forEach(System.out::println);
        System.out.println();

        // b) Перетворити потік об’єктів на потік значень довжини поля-рядка кожного об’єкта.
        List<Integer> nameLengths = foodDeliveries.stream()
                .map(FoodDelivery::getNameLength)
                .collect(Collectors.toList());

        System.out.println("Довжина імен:");
        nameLengths.forEach(System.out::println);
        System.out.println();

        // c) Для кожного об’єкту в потоці звести у квадрат значення певного числового поля.
        List<Integer> ratingSquared = foodDeliveries.stream()
                .map(FoodDelivery::getRatingSquared)
                .collect(Collectors.toList());

        System.out.println("Квадрати рейтингів:");
        ratingSquared.forEach(System.out::println);
    }
}
