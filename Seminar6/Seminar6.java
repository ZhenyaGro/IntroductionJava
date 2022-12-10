package Seminar6;

import Seminar6.Laptop;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;;

public class Seminar6 {
  // Текст задания в файле "task.txt"

  public static void main(String[] args) {
    try {
      File file = new File("./Seminar6/laptops.txt");
      FileReader fr = new FileReader(file);
      BufferedReader reader = new BufferedReader(fr);
      String line = reader.readLine();

      Laptop[] laptops = new Laptop[5];

      int count = 0;
      while (line != null) {
        System.out.println(line);
        line = reader.readLine();
        String[] properties = line.split(", ");
        // laptop.append?
      }
      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.print("\nМеню\n1 - Вывести список ноутбуков\n");

    Scanner str = new Scanner(System.in);
    String choosenTask = str.next();

    switch (choosenTask) {
      case "1":
        // task1();
        break;

      case "2":
        // task2();
        break;

      default:
        System.out.println("Некорректный ввод");
        break;
    }
    str.close();
  }
}
