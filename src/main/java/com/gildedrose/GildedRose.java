package com.gildedrose;

class GildedRose {
  static final String AGED_BRIE = "Aged Brie";
  static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  static final int QUALITY_MAX_VALUE = 50;
  static final int BACKSTAGE_PASSES_SELLIN_LIMIT2 = 11;
  static final int BACKSTAGE_PASSES_SELLIN_LIMIT3 = 6;

  transient Item[] items;

  GildedRose(Item[] itemsList) {
    this.items = itemsList;
  }

  private void incrementQuality(Item item) {
    if (item.quality < QUALITY_MAX_VALUE) {
      item.quality = item.quality + 1;
    }
  }

  private void decrementQuality(Item item) {
    if (!item.name.equals(SULFURAS) && (item.quality > 0)) {
      item.quality = item.quality - 1;
    }
  }

  private void decrementSellIn(Item item) {
    if (!item.name.equals(SULFURAS)) {
      item.sellIn = item.sellIn - 1;
    }
  }

  // changement de qualité pour chaque jour
  public void updateQuality() {
    for (Item item : items) {
    // parcours de tous les items
      if (item.name.equals(AGED_BRIE)) {
        // si c'est l'item "Agent Brie" ou l'item "Backstage passes"
        incrementQuality(item);

      } else if (item.name.equals(BACKSTAGE_PASSES)) {
        // si c'est l'item "Backstage passes"
        incrementQuality(item);

        // la qualité augmente de 2 quand il reste 10 jours ou moins
        if (item.sellIn < BACKSTAGE_PASSES_SELLIN_LIMIT2) {
          incrementQuality(item);
        }

        // et de 3 quand il reste 5 jours ou moins (mais la qualité tombe à 0 après le concert)
        if (item.sellIn < BACKSTAGE_PASSES_SELLIN_LIMIT3) {
          incrementQuality(item);
        }
      } else {
        // si ce n'est ni l'item "Agent Brie" ni l'item "Backstage passes"
        decrementQuality(item);
      }

      decrementSellIn(item);

      if (item.sellIn < 0) {
        if (item.name.equals(AGED_BRIE)) {
          incrementQuality(item);
          // ici pour le Aged Brie périmé elle est incrémentée une 2e fois
        } else {
          if (item.name.equals(BACKSTAGE_PASSES)) {
            item.quality = 0;
          } else {
            decrementQuality(item);
          }
        }
      }
    }
  }
}
