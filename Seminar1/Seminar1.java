package Seminar1;

import java.util.Scanner;

public class Seminar1 {

  public static void main(String[] args) {
    System.out.print("Выбор задания (1 - 3): ");
    Scanner str = new Scanner(System.in);
    String choosenTask = str.next();

    switch (choosenTask) {
      case "1":
        task1();
        break;

      case "2":
        task2();
        break;

      case "3":
        task3();
        break;

      default:
        System.out.println("Некорректный ввод");
        break;
    }
    str.close();
  }

  public static void task1() {
    // Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение
    // чисел от 1 до n)

    System.out.print("Введите n: ");
    Scanner str = new Scanner(System.in);
    int n = str.nextInt();
    str.close();
    int sum = 0;
    int factorial = 1;

    for (int i = 1; i <= n; i++) {
      sum += i;
      factorial *= i;
    }

    System.out.println("Сумма: " + sum);
    System.out.println("Факториал: " + factorial);
  }

  public static void task2() {
    // Вывести все простые числа от 1 до 1000

    int count;
    System.out.print("2" + " ");

    for (int i = 3; i < 1000; i += 2) {
      count = 0;
      for (int j = 2; j <= i / 2; j++) {
        if (i % j == 0) {
          count++;
          break;
        }
      }
      if (count == 0) {
        System.out.print(i + " ");
      }
    }
  }

  public static void task3() {
    // Реализовать простой калькулятор (операции + - / * )

    System.out.print("Введите число 1: ");
    Scanner str = new Scanner(System.in);
    int a = str.nextInt();

    System.out.print("Выберите операцию (+ | - | / | *): ");
    String operation = str.next();

    System.out.print("Введите число 2: ");
    int b = str.nextInt();

    str.close();

    double result;
    switch (operation) {
      case "+":
        result = a + b;
        System.out.printf("%d + %d = %d", a, b, result);
        break;

      case "-":
        result = a - b;
        System.out.printf("%d - %d = %d", a, b, result);
        break;

      case "/":
        result = a / b;
        System.out.printf("%d / %d = %f", a, b, result);
        break;

      case "*":
        result = a * b;
        System.out.printf("%d * %d = %d", a, b, result);
        break;

      default:
        System.out.println("Некорректный ввод");
    }

  }

}