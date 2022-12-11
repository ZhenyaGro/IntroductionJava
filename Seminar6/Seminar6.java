package Seminar6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seminar6 {
  // Текст задания в файле "task.txt"
  public static void main(String[] args) {
    List<Laptop> laptops = new ArrayList<>();
    String[] props = new String[5];
    try {
      File file = new File("./Seminar6/laptops.txt");
      FileReader fr = new FileReader(file);
      BufferedReader reader = new BufferedReader(fr);
      String line;
      while (true) {
        // System.out.println(line);
        line = reader.readLine();
        if (line != null) {
          props = line.split(", ");
          laptops.add(new Laptop(props[0], Integer.parseInt(props[1]), Integer.parseInt(props[2]), props[3], props[4]));
        } else
          break;
      }
      reader.close();
      System.out.println(laptops);
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
        System.out.println("Список ноутбуков");
        for (Laptop laptop : laptops)
          System.out.println(laptop);
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
