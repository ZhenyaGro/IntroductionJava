package Seminar4;

import java.util.LinkedList;
import java.util.Scanner;

public class Seminar4 {
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
    // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который
    // вернет “перевернутый” список.
    int size = 10;
    LinkedList<Integer> elements = createList(size);
    System.out.println("Исходный список: " + elements);
    LinkedList<Integer> revercedElements = reverceList(elements);
    System.out.println("Перевернутый список: " + revercedElements);
  }

  public static void task2() {
    /*
     * Реализуйте очередь с помощью LinkedList со следующими методами:
     * - enqueue() - помещает элемент в конец очереди,
     * - dequeue() - возвращает первый элемент из очереди и удаляет его,
     * - first() - возвращает первый элемент из очереди, не удаляя.
     */

  }

  public static LinkedList<Integer> createList(int size) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      list.add(i);
    }

    return list;
  }

  public static LinkedList<Integer> reverceList(LinkedList list) {
    LinkedList<Integer> revercedList = new LinkedList<>();

    int length = list.size();
    for (int i = length; i > 0; i--) {
      revercedList.add((Integer) list.listIterator(i).previous());
    }

    return revercedList;
  }
}
