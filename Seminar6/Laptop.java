package Seminar6;

public class Laptop {
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
        "%s ноутбук %s на операционной системе %s с %dГб оперативной памяти и %dГб дискового пространства", this.color,
        this.manufacturer, this.os, this.ram, this.hdDiscSpace);
  }
}
