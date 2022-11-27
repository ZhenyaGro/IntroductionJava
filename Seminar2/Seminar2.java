package Seminar2;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class Seminar2 {
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

  }

  public static void task1() {
    /*
     * 1.Дана строка sql-запроса "select * from students where ".
     * Сформируйте часть WHERE этого запроса, используя StringBuilder.
     * Данные для фильтрации приведены ниже в виде json строки.
     * Если значение null, то параметр не должен попадать в запрос.
     * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
     * "city":"Moscow", "age":"null"}
     */

    String inputParametrs = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
    StringBuilder query = new StringBuilder("SELECT *\nFROM students\nWHERE ");

    String replacementChars = "[\"{},]";
    String[] parsedString = inputParametrs.replaceAll(replacementChars, "").split(" ");

    String[] parametrs = new String[2];
    for (int i = 0; i < parsedString.length; i++) {
      parametrs = parsedString[i].split(":");

      if (!parametrs[1].equals("null")) {
        if (i != 0)
          query.append(" AND ");
        query.append(parametrs[0] + " = \"" + parametrs[1] + "\"");
      }
    }

    System.out.println("Итоговый запрос:\n" + query);

  }

  public static void task2() {
    /*
     * 2.Реализуйте алгоритм сортировки пузырьком числового массива, результат после
     * каждой итерации запишите в лог-файл.
     */
    int arraySize = 10;
    int[] arr = new int[arraySize];
    for (int i = 0; i < arraySize; i++) {
      arr[i] = 0 + (int) (Math.random() * 10);
    }

    System.out.print("Исходный массив: ");
    printArray(arr);

    try {
      FileWriter sortLog = new FileWriter("./Seminar2/sortLog.log");

      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length - 1 - i; j++) {
          if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }

          for (int k = 0; k < arr.length; k++) {
            if (k == arr.length - 1)
              sortLog.write(Integer.toString(arr[k]) + "\n");
            else
              sortLog.write(Integer.toString(arr[k]) + ", ");
          }
        }
      }
      sortLog.close();
    } catch (IOException e) {
      System.out.println("Ошибка");
      e.printStackTrace();
    }

    System.out.print("\nИтоговый массив: ");
    printArray(arr);
  }

  static void printArray(int[] array) {
    System.out.print("[");
    for (int i = 0; i < array.length; i++) {
      if (i == array.length - 1)
        System.out.print(array[i] + "]");
      else
        System.out.print(array[i] + ", ");
    }
  }

}
