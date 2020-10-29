package com.gildedrose;

class GildedRose {
  static final String AGED_BRIE = "Aged Brie";
  static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  static final int QUALITY_MAX_VALUE = 50;
  static final int BACKSTAGE_PASSES_SELLIN_LIMIT2 = 10;
  static final int BACKSTAGE_PASSES_SELLIN_LIMIT3 = 5;

  transient Item[] items;

  GildedRose(Item[] itemsList) {
    this.items = itemsList;
  }

  private void incrementQuality(Item item, int n) {
    if (item.quality + n <= QUALITY_MAX_VALUE) {
      item.quality += n;
    } else {
      item.quality = QUALITY_MAX_VALUE;
    }
  }

  private void decrementQuality(Item item, int n) {
    if (!item.name.equals(SULFURAS) && (item.quality > 0)) {
      item.quality -= n;
    }
  }

  private void decrementSellIn(Item item) {
    if (!item.name.equals(SULFURAS)) {
      item.sellIn -= 1;
    }
  }

  // changements sur la qualité de tous les items pour 1 jour
  public void updateQuality() {
    for (Item item : items) {
    // parcours de tous les items
      decrementSellIn(item);

      if (item.name.equals(AGED_BRIE)) {
        // si c'est l'item "Aged Brie" ou l'item "Backstage passes"
        if (item.sellIn < 0) {
          incrementQuality(item, 2);
        } else {
          incrementQuality(item, 1);
        }
      } else if (item.name.equals(BACKSTAGE_PASSES)) {
        if (item.sellIn < 0) {
          item.quality = 0;
        } else if (item.sellIn < BACKSTAGE_PASSES_SELLIN_LIMIT3) {
          incrementQuality(item, 3);
        } else if (item.sellIn < BACKSTAGE_PASSES_SELLIN_LIMIT2) {
          incrementQuality(item, 2);
        } else {
          incrementQuality(item, 1);
        }
      } else {
        // si ce n'est ni l'item "Aged Brie" ni l'item "Backstage passes"
        if (item.sellIn < 0) {
          decrementQuality(item, 2);
        } else {
          decrementQuality(item, 1);
        }
      }
    }
  }
}
