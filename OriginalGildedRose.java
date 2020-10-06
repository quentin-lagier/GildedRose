package com.gildedrose;

class GildedRose {
  static final String AGED_BRIE = "Aged Brie";
  static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

  static final int QUALITY_MAX_VALUE = 50;
  static final int BACKSTAGE_SELLIN_LIMIT2 = 11;
  static final int BACKSTAGE_SELLIN_LIMIT3 = 6;

  Item[] items;

  GildedRose(Item[] itemsList) {
    this.items = itemsList;
  }

  // changement de qualité pour chaque jour
  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
    // parcours de tous les items
      if (!items[i].name.equals(AGED_BRIE)
          && !items[i].name.equals(BACKSTAGE_PASSES)) {
          // si ce n'est pas l'item "Agent Brie"
          // et ce n'est pas l'item "Backstage passes"
        if (items[i].quality > 0) {
        // si sa qualité est > 0
          if (!items[i].name.equals(SULFURAS)) {
          //
            items[i].quality = items[i].quality - 1;
          }
        }
      } else {
      // si c'est l'item "Agent Brie" ou l'item "Backstage passes"
        if (items[i].quality < QUALITY_MAX_VALUE) {
        // si la qualité est < 50 (elle ne peut dépasser)
          items[i].quality = items[i].quality + 1;
          // incrémente la qualité

          if (items[i].name.equals(BACKSTAGE_PASSES)) {
          // si c'est l'item "Backstage passes"

            // la qualité augmente de 2 quand il reste 10 jours ou moins
            if (items[i].sellIn < BACKSTAGE_SELLIN_LIMIT2) {
              if (items[i].quality < QUALITY_MAX_VALUE) {
              // vérif si qualité peut augmenter
                items[i].quality = items[i].quality + 1;
              }
            }

            // et de 3 quand il reste 5 jours ou moins (mais la qualité tombe à 0 après le concert)
            if (items[i].sellIn < BACKSTAGE_SELLIN_LIMIT3) {
              if (items[i].quality < QUALITY_MAX_VALUE) {
              // vérif si qualité peut augmenter
                items[i].quality = items[i].quality + 1;
              }
            }
          }
        }
      }

      if (!items[i].name.equals(SULFURAS)) {
      // si ce n'est pas l'item légendaire "Sulfuras" (il ne se périme pas)
        items[i].sellIn = items[i].sellIn - 1;
        // décrémente le nombre de jours restant pour vendre l'item
      }

      if (items[i].sellIn < 0) {
        if (!items[i].name.equals(AGED_BRIE)) {
          if (!items[i].name.equals(BACKSTAGE_PASSES)) {
            if (items[i].quality > 0) {
              if (!items[i].name.equals(SULFURAS)) {
                items[i].quality = items[i].quality - 1;
                // décrémente la qualité
              }
            }
          } else {
            items[i].quality = items[i].quality - items[i].quality;
            //items[i].quality = 0 ?
          }
        } else {
          if (items[i].quality < QUALITY_MAX_VALUE) {
          // vérif si qualité peut augmenter
            items[i].quality = items[i].quality + 1;
            // incrémente la qualité
            // ici pour le Aged Brie périmé elle est incrémentée une 2e fois
          }
        }
      }
    }
  }
}
