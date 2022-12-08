package Seminar5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Seminar5 {
  public static void main(String[] args) {
    System.out.print("Выбор задания (1 - 2): ");
    Scanner str = new Scanner(System.in);
    String choosenTask = str.next();

    switch (choosenTask) {
      case "1":
        task1();
        break;

      case "2":
        task2();
        break;

      default:
        System.out.println("Некорректный ввод");
        break;
    }
    str.close();
  }

  public static void task1() {
    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
    // человек может иметь несколько телефонов.
    Map<String, String> phoneBook = new HashMap<>();
    phoneBook.putIfAbsent("79213242685", "Иванов Иван Иванович");
    phoneBook.putIfAbsent("79227557737", "Петров Петр Петрович");
    phoneBook.putIfAbsent("79356335565", "Иванов Иван Иванович");
    phoneBook.putIfAbsent("79335566358", "Васильев Василий Васильевич");

    for (String number : phoneBook.keySet()) {
      System.out.println(String.format("Телефон %s принадлежит контакту: %s", number, phoneBook.get(number)));
    }
  }

  public static void task2() {
    /*
     * Пусть дан список сотрудников:
     * 
     * Иван Иванов
     * Светлана Петрова
     * Кристина Белова
     * Анна Мусина
     * Анна Крутова
     * Иван Юрин
     * Петр Лыков
     * Павел Чернов
     * Петр Чернышов
     * Мария Федорова
     * Марина Светлова
     * Мария Савина
     * Мария Рыкова
     * Марина Лугова
     * Анна Владимирова
     * Иван Мечников
     * Петр Петин
     * Иван Ежов
     * 
     * Написать программу, которая найдет и выведет повторяющиеся имена с
     * количеством повторений. Отсортировать по убыванию популярности.
     */
    String[] people = new String[] { "Иван Иванов", "Светлана Петрова", "Кристина Белова",
        "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
        "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова",
        "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов" };

    Map<String, Integer> names = new HashMap<>();
    for (String person : people) {
      String name = person.split(" ")[0];
      if (!names.containsKey(name))
        names.put(name, 1);
      else
        names.put(name, names.get(name) + 1);
    }

    names.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(person -> System.out.println("Имя \"" + person.getKey() + "\" встречается " +
            person.getValue() + " раз"));
  }
}
