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

    System.out.print("\nМеню\n1 - Вывести список ноутбуков\n2 - Найти ноутбук по критерию\n");

    Scanner str = new Scanner(System.in);
    String choosenTask = str.next();

    switch (choosenTask) {
      case "1":
        printLaptops(laptops);
        break;

      case "2":
        searchForLaptop(laptops);
        break;

      default:
        System.out.println("Некорректный ввод");
        break;
    }
    str.close();
  }

  static void printLaptops(List<Laptop> laptopsList) {
    System.out.println("Список ноутбуков");
    for (Laptop laptop : laptopsList)
      System.out.println(laptop);
  }

  static void searchForLaptop(List<Laptop> laptopsList) {
    System.out.println(
        "Выберите фильтр:\n1 - Производитель\n2 - Объем оперативной памяти\n3 - Объем дискового пространства\n4 - Операционная система\n5 - Цвет");
    Scanner str = new Scanner(System.in);
    String filter = str.next();

    switch (filter) {
      case "1":
        System.out.print("Введите наименование производителя: ");
        String fManufacturer = str.next();
        System.out.println("Ноутбуки соответствующие критерию: ");
        for (Laptop laptop : laptopsList) {
          if (fManufacturer.toLowerCase().equals(laptop.getProperty(filter).toString().toLowerCase()))
            System.out.println(laptop);
        }
        break;

      case "2":
        //
        break;

      case "3":
        //
        break;

      case "4":
        //
        break;

      case "5":
        //
        break;

      default:
        System.out.println("Некорректный ввод");
        break;
    }
    str.close();
  }
}
