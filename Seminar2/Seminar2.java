package Seminar2;

import java.io.File;
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
    StringBuilder query = new StringBuilder("SELECT * FROM students WHERE ");

    String replacementChars = "[\"{},]";
    String[] parsedString = inputParametrs.replaceAll(replacementChars, "").split(" ");

    String[] parametrs = new String[2];
    for (int i = 0; i < parsedString.length; i++) {
      parametrs = parsedString[i].split(":");
      System.out.println(parametrs[0] + " " + parametrs[1]);

      if (!parametrs[1].equals("null")) {
        if (i != 0)
          query.append(" AND ");
        query.append(parametrs[0] + " = \"" + parametrs[1] + "\"");
      }
      System.out.println(query + "\n");
    }

    System.out.println(query);

  }

  public static void task2() {
    /*
     * 2.Реализуйте алгоритм сортировки пузырьком числового массива, результат после
     * каждой итерации запишите в лог-файл.
     */
  }

  public static boolean isFileExists(File file) {
    return file.exists() && !file.isDirectory();
  }

}
