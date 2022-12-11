package Seminar6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Seminar6 {
  public static class Laptop {
    private String manufacturer, os, color;
    private int ram;
    private int hdDiscSpace;

    public Laptop(String manufacturer, int ram, int hdDiscSpace, String os, String color) {
      this.manufacturer = manufacturer;
      this.ram = ram;
      this.hdDiscSpace = hdDiscSpace;
      this.os = os;
      this.color = color;
    }

    public Object getProperty(String propNum) {
      switch (propNum) {
        case "1":
          return this.manufacturer;

        case "2":
          return this.ram;

        case "3":
          return this.hdDiscSpace;

        case "4":
          return this.os;

        case "5":
          return this.color;

        default:
          return "Нет характеристики";
      }
    }

    @Override
    public String toString() {
      return String.format(
          "%s ноутбук %s на операционной системе %s с %dГб оперативной памяти и %dГб дискового пространства",
          this.color,
          this.manufacturer, this.os, this.ram, this.hdDiscSpace);
    }
  }
  // Текст задания в файле "task.txt"

  public static void main(String[] args) {
    try {
      File file = new File("./Seminar6/laptops.txt");
      FileReader fr = new FileReader(file);
      BufferedReader reader = new BufferedReader(fr);
      String line = reader.readLine();
      // String properties[] = new String[5];

      Laptop testLaptop = new Laptop("Apple", 10, 10, "lne", "tes");
      System.out.println(testLaptop);
      List<Laptop> laptops = new ArrayList<>();

      while (line != null) {
        System.out.println(line);
        line = reader.readLine();
        // laptops.add(line.split(", "));
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
