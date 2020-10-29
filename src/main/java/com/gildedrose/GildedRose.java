package com.gildedrose;

class GildedRose {
  static final String AGED_BRIE = "Aged Brie";
  static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  static final int QUALITY_MAX_VALUE = 50;
  static final int BACKSTAGE_PASSES_SELLIN_LIMIT2 = 11;
  static final int BACKSTAGE_PASSES_SELLIN_LIMIT3 = 6;

  Item[] items;

  GildedRose(Item[] itemsList) {
    this.items = itemsList;
  }

  // changement de qualité pour chaque jour
  public void updateQuality() {
    for (Item item : items) {
    // parcours de tous les items
      if (item.name.equals(AGED_BRIE) || item.name.equals(BACKSTAGE_PASSES)) {
        // si c'est l'item "Agent Brie" ou l'item "Backstage passes"
        if (item.quality < QUALITY_MAX_VALUE) {
        // si la qualité est < 50 (elle ne peut dépasser)
          item.quality = item.quality + 1;
          // incrémente la qualité

          if (item.name.equals(BACKSTAGE_PASSES)) {
          // si c'est l'item "Backstage passes"

            // la qualité augmente de 2 quand il reste 10 jours ou moins
            if (item.sellIn < BACKSTAGE_PASSES_SELLIN_LIMIT2) {
              if (item.quality < QUALITY_MAX_VALUE) {
              // vérif si qualité peut augmenter
                item.quality = item.quality + 1;
              }
            }

            // et de 3 quand il reste 5 jours ou moins (mais la qualité tombe à 0 après le concert)
            if (item.sellIn < BACKSTAGE_PASSES_SELLIN_LIMIT3) {
              if (item.quality < QUALITY_MAX_VALUE) {
              // vérif si qualité peut augmenter
                item.quality = item.quality + 1;
              }
            }
          }
        }
      } else {
        // si ce n'est pas l'item "Agent Brie"
        // et ce n'est pas l'item "Backstage passes"
        if (item.quality > 0) {
        // si sa qualité est > 0
          if (item.name.equals(SULFURAS)) {
          } else {
            item.quality = item.quality - 1;
          }
        }
      }

      if (item.name.equals(SULFURAS)) {
      } else {
        // si ce n'est pas l'item légendaire "Sulfuras" (il ne se périme pas)
        item.sellIn = item.sellIn - 1;
        // décrémente le nombre de jours restant pour vendre l'item
      }

      if (item.sellIn < 0) {
        if (item.name.equals(AGED_BRIE)) {
          if (item.quality < QUALITY_MAX_VALUE) {
          // vérif si qualité peut augmenter
            item.quality = item.quality + 1;
            // incrémente la qualité
            // ici pour le Aged Brie périmé elle est incrémentée une 2e fois
          }
        } else {
          if (item.name.equals(BACKSTAGE_PASSES)) {
            item.quality = 0;
          } else {
            if (item.quality > 0) {
              if (item.name.equals(SULFURAS)) {
              } else {
                item.quality = item.quality - 1;
                // décrémente la qualité
              }
            }
          }
        }
      }
    }
  }
}
