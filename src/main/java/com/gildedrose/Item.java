package com.gildedrose;

public class Item {

  public String name;

  public int sellIn; // le nombre de jours restant pour vendre l'article

  public int quality; // dénote combien l'article est précieux

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

   @Override
   public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}
