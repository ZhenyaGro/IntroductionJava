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
    int listSize = 10;
    LinkedList<Integer> elements = createList(listSize);
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
    int queueSize = 10;
    LinkedList<Integer> queue = createList(queueSize);
    System.out.println("Начальная очередь: " + queue);

    System.out.println(
        "Выберите действие:\n1 - Добавить элемент\n2 - Удалить первый элемент\n3 - Показать первый элемент\n4 - Выход");

    Scanner str = new Scanner(System.in);
    String choosenAction = str.next();

    switch (choosenAction) {
      case "1":
        enqueue(queue);
        System.out.println("Очередь измена: " + queue);
        break;

      case "2":
        int removedEl = dequeue(queue);
        System.out.println("Удален первый элемент = " + removedEl + "\nТекущая очередь: " + queue);
        break;

      case "3":
        int firstEl = first(queue);
        System.out.println("Первый элемент очереди = " + firstEl);
        break;

      case "4":
        break;

      default:
        System.out.println("Некорректный ввод");
        break;
    }
    str.close();
  }

  public static LinkedList<Integer> createList(int size) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      list.add(i);
    }

    return list;
  }

  public static LinkedList<Integer> reverceList(LinkedList<Integer> list) {
    LinkedList<Integer> revercedList = new LinkedList<>();

    int length = list.size();
    for (int i = length; i > 0; i--) {
      revercedList.add((Integer) list.listIterator(i).previous());
    }

    return revercedList;
  }

  // enqueue() - помещает элемент в конец очереди
  public static void enqueue(LinkedList<Integer> list) {
    System.out.print("Добавление элемента в конец очереди.\nВведите элемент: ");
    Scanner str = new Scanner(System.in);
    try {
      int element = str.nextInt();
      list.add(element);
    } catch (Exception err) {
      System.out.println("Некорректный ввод.\nОшибка: " + err + "\nОчередь не была изменена");
    }
    str.close();
  }

  // dequeue() - возвращает первый элемент из очереди и удаляет его
  public static int dequeue(LinkedList<Integer> list) {
    if (list.size() > 0)
      return list.removeFirst();
    System.out.println("В очереди нет элементов");
    return -1;
  }

  // first() - возвращает первый элемент из очереди, не удаляя
  public static int first(LinkedList<Integer> list) {
    if (list.size() > 0)
      return list.getFirst();
    System.out.println("В очереди нет элементов");
    return -1;
  }
}
