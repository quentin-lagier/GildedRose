package com.gildedrose;

public class TexttestFixture {
  static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  public static void main(String[] args) {
    System.out.println("OMGHAI!");

    final Item[] items = new Item[] {
      new Item("+5 Dexterity Vest", 10, 20),
      new Item("Aged Brie", 2, 0),
      new Item("Elixir of the Mongoose", 5, 7),
      new Item(SULFURAS, 0, 80),
      new Item(SULFURAS, -1, 80),
      new Item(BACKSTAGE_PASSES, 15, 20),
      new Item(BACKSTAGE_PASSES, 10, 49),
      new Item(BACKSTAGE_PASSES, 5, 49),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", 3, 6),
    };

    final GildedRose app = new GildedRose(items);

    final int days;
    if (args.length > 0) {
      days = Integer.parseInt(args[0]) + 1;
    } else {
      days = 2;
    }

    for (int i = 0; i < days; i++) {
      System.out.println("-------- day " + i + " --------");
      System.out.println("name, sellIn, quality");
      for (Item item : items) {
        System.out.println(item);
      }
      System.out.println();
      app.updateQuality();
    }
  }
}
