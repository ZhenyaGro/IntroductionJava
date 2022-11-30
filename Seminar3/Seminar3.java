package Seminar3;

import java.util.Arrays;
import java.util.Scanner;

public class Seminar3 {
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
  }

  public static void task1() {
    // Реализовать алгоритм сортировки слиянием
    int size = 10;
    int[] numbers = createArray(size);
    System.out.print("Исходный массив: ");
    System.out.println(Arrays.toString(numbers));

    int[] result = mergeSort(numbers);
    System.out.print("Отсортированный массив: ");
    System.out.println(Arrays.toString(result));
  }

  public static void task2() {
    // Пусть дан произвольный список целых чисел, удалить из него четные числа
    int size = 10;
    int[] numbers = createArray(size);
    System.out.print("Исходный массив: ");
    System.out.println(Arrays.toString(numbers));

  }

  public static void task3() {
    // Задан целочисленный список ArrayList. Найти минимальное, максимальное и
    // среднее из этого списка.

  }

  static int[] createArray(int arraySize) {
    int[] array = new int[arraySize];
    for (int i = 0; i < arraySize; i++) {
      array[i] = 0 + (int) (Math.random() * 10);
    }

    return array;
  }

  public static int[] mergeSort(int[] array) {
    int[] buffer1 = Arrays.copyOf(array, array.length);
    int[] buffer2 = new int[array.length];
    int[] result = mergesortInner(buffer1, buffer2, 0, array.length);
    return result;
  }

  public static int[] mergesortInner(int[] buffer1, int[] buffer2,
      int startIndex, int endIndex) {
    if (startIndex >= endIndex - 1) {
      return buffer1;
    }

    int middle = startIndex + (endIndex - startIndex) / 2;
    int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
    int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

    int index1 = startIndex;
    int index2 = middle;
    int destIndex = startIndex;
    int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
    while (index1 < middle && index2 < endIndex) {
      result[destIndex++] = sorted1[index1] < sorted2[index2]
          ? sorted1[index1++]
          : sorted2[index2++];
    }
    while (index1 < middle) {
      result[destIndex++] = sorted1[index1++];
    }
    while (index2 < endIndex) {
      result[destIndex++] = sorted2[index2++];
    }
    return result;
  }
}
