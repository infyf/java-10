import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // ˳����� ���� 1: ���������, �� ������ ���� ������� �� ������� ��������� ������� ����.
        List<FoodDelivery> foodDeliveries1 = List.of(
                new FoodDelivery("bread"),
                new FoodDelivery("apple"),
                new FoodDelivery("pizza")
        );

        String targetFoodItem1 = "pizza";
        List<FoodDelivery> filteredList1 = foodDeliveries1.stream()
                .filter(delivery -> delivery.getFoodItem().equals(targetFoodItem1))
                .collect(Collectors.toList());

        // �������� ���������
        System.out.println("Filtered List 1:");
        if(filteredList1.isEmpty()) {
            System.out.println("No items found.");
        } else {
            filteredList1.forEach(System.out::println);
        }

        // ˳����� ���� 2: Գ��������� �������� �� �����-������, ��� �������� ���� �, �� ����������� � ����� �����.
        List<FoodDelivery> foodDeliveries2 = List.of(
                new FoodDelivery("bread"),
                new FoodDelivery("apple"),
                new FoodDelivery("pizza")
        );

        // ������� ���������� �� ������ ������ ���� foodItem
        char targetLetter = 'b';
        List<FoodDelivery> filteredList2 = foodDeliveries2.stream()
                .filter(delivery -> delivery.getFoodItem().charAt(0) == targetLetter)
                .collect(Collectors.toList());

        System.out.println("\nFiltered List 2:");
        filteredList2.forEach(System.out::println);

        // ˳����� ���� 3: Գ��������� �������� �� ����� �������� �������� ��� ������� ����.
        List<FoodDelivery> foodDeliveries3 = List.of(
                new FoodDelivery("bread"),
                new FoodDelivery("saladdddd"),
                new FoodDelivery("pizza")
        );

        // ������� ���������� �� �������� ���� foodItem
        int minFoodItemLength = 5;
        int maxFoodItemLength = 7;
        List<FoodDelivery> filteredList3 = foodDeliveries3.stream()
                .filter(delivery -> delivery.getFoodItem().length() >= minFoodItemLength &&
                        delivery.getFoodItem().length() <= maxFoodItemLength)
                .collect(Collectors.toList());

        // �������� ���������
        System.out.println("\nFiltered List 3:");
        filteredList3.forEach(System.out::println);

        // ˳����� ���� 4: Գ��������� �������� � ������������� ���������� ���������.
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

        // �������� ���������
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
˳����� ����: 2 ������� �������� 
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
                new FoodDelivery("���", 5),
                new FoodDelivery("������", 3),
                new FoodDelivery("���", 8)
        );

        // a) ������ ������� � ������������ ��������� �� ������ �������� �����
        FoodDelivery maxDelivery = foodDeliveries.stream()
                .max(Comparator.comparingInt(FoodDelivery::getRating))
                .orElse(null);
        System.out.println("����������� ������� �������� ��:");
        System.out.println("��'�: " + maxDelivery.getName());
        System.out.println("�������: " + maxDelivery.getRating());

        // b) ��������� ���� �������� �� ������ ����� � ����������� ������� � ������������� �������� �����������
        Comparator<FoodDelivery> ratingComparator = Comparator.comparingInt(FoodDelivery::getRating).reversed();
        List<FoodDelivery> sortedByRating = foodDeliveries.stream()
                .sorted(ratingComparator)
                .collect(Collectors.toList());
        System.out.println("\n³���������� �� ������� � ����������� �������:");
        for (FoodDelivery delivery : sortedByRating) {
            System.out.println("��'�: " + delivery.getName() + ", �������: " + delivery.getRating());
        }

        // c) ��������� ���� �������� �� ����� ������
        Comparator<FoodDelivery> nameAndRatingComparator = Comparator.comparing(FoodDelivery::getName)
                .thenComparing(Comparator.comparingInt(FoodDelivery::getRating));
        List<FoodDelivery> sortedByNameAndRating = foodDeliveries.stream()
                .sorted(nameAndRatingComparator)
                .collect(Collectors.toList());
        System.out.println("\n³���������� �� ������ �� �������:");
        for (FoodDelivery delivery : sortedByNameAndRating) {
            System.out.println("��'�: " + delivery.getName() + ", �������: " + delivery.getRating());
        }
    }
}
˳����� ����: 3 ������� �������� 
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
                new FoodDelivery("����", 5),
                new FoodDelivery("�����", 3),
                new FoodDelivery("�����", 8)
        );

        // a) ����������� �ᒺ��� � ����� (�������� �� ���� � �����).
        List<String> strings = foodDeliveries.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        System.out.println("�����:");
        strings.forEach(System.out::println);
        System.out.println();

        // b) ����������� ���� �ᒺ��� �� ���� ������� ������� ����-����� ������� �ᒺ���.
        List<Integer> nameLengths = foodDeliveries.stream()
                .map(FoodDelivery::getNameLength)
                .collect(Collectors.toList());

        System.out.println("������� ����:");
        nameLengths.forEach(System.out::println);
        System.out.println();

        // c) ��� ������� �ᒺ��� � ������ ������ � ������� �������� ������� ��������� ����.
        List<Integer> ratingSquared = foodDeliveries.stream()
                .map(FoodDelivery::getRatingSquared)
                .collect(Collectors.toList());

        System.out.println("�������� ��������:");
        ratingSquared.forEach(System.out::println);
    }
}
