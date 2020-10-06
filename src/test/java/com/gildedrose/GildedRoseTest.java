package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {
  static final String AGED_BRIE = "Aged Brie";
  static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
  static final String BASIC_ITEM = "Basic item";

  /******************************
  * TESTS SUR LA VALEUR QUALITY * // remplacer quality <= 0 ? car < 0, reste < 0
  ******************************/

  @Test
  // La quality des items basiques diminue de 1 / quality > 0, sellIn > 0
  void basicItemQualityDecrementBy1() {
    final int quality = 50;
    final int sellIn = 2;
    final Item[] items = new Item[] {new Item(BASIC_ITEM, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality - 1));
  }

  @Test
  // La quality des items basiques ne peut être inférieure à 0 (elle reste 0) / quality < 0, sellIn > 0
  void basicItemQualityNonZero1() {
    final int quality = 0;
    final int sellIn = 2;
    final Item[] items = new Item[] {new Item(BASIC_ITEM, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(0));
  }

  @Test
  // La quality des items basiques diminue de 2 / quality > 0, sellIn < 0
  void basicItemQualityDecrementBy2() {
    final int quality = 50;
    final int sellIn = 0;
    final Item[] items = new Item[] {new Item(BASIC_ITEM, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality - 2));
  }

  @Test
  // La quality des items basiques ne peut être inférieure à 0 (elle reste 0) / quality < 0, sellIn < 0
  void basicItemQualityNonZero2() {
    final int quality = 0;
    final int sellIn = 0;
    final Item[] items = new Item[] {new Item(BASIC_ITEM, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(0));
  }


  @Test
  // La quality de Sulfuras ne change pas / quality > 0, sellIn > 0
  void sulfurasQualityInchanged1() {
    final int quality = 80;
    final int sellIn = 1000;
    // doit être 80 selon les specs mais n'est pas vérifié dans le code

    final Item[] items = new Item[] {new Item(SULFURAS, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality));
  }

  @Test
  // La quality de Sulfuras ne change pas / quality < 0, sellIn > 0
  void sulfurasQualityInchanged2() {
    final int quality = 80;
    final int sellIn = 1000;
    // doit être 80 selon les specs mais n'est pas vérifié dans le code

    final Item[] items = new Item[] {new Item(SULFURAS, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality));
  }

  @Test
  // La quality de Sulfuras ne change pas / quality > 0, sellIn < 0
  void sulfurasQualityInchanged3() {
    final int quality = 80;
    final int sellIn = 1000;
    // doit être 80 selon les specs mais n'est pas vérifié dans le code

    final Item[] items = new Item[] {new Item(SULFURAS, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality));
  }

  @Test
  // La quality de Sulfuras ne change pas / quality < 0, sellIn < 0
  void sulfurasQualityInchanged4() {
    final int quality = 80;
    final int sellIn = 1000;
    // doit être 80 selon les specs mais n'est pas vérifié dans le code

    final Item[] items = new Item[] {new Item(SULFURAS, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality));
  }


  @Test
  // La quality de Aged Brie augmente de 1 / quality > 0, sellIn > 0
  void agedBrieQualityIncrementBy1P1() {
    final int quality = 0;
    final int sellIn = 1;
    final Item[] items = new Item[] {new Item(AGED_BRIE, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality + 1));
  }

  @Test
  // La quality de Aged Brie augmente de 1 / quality < 0, sellIn > 0
  void agedBrieQualityIncrementBy1P2() {
    final int quality = -1;
    final int sellIn = 1;
    final Item[] items = new Item[] {new Item(AGED_BRIE, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality + 1));
  }

  @Test
  // La quality de Aged Brie augmente de 2 / quality > 0, sellIn < 0
  void agedBrieQualityIncrementBy2P1() {
    final int quality = 1;
    final int sellIn = 0;
    final Item[] items = new Item[] {new Item(AGED_BRIE, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality + 2));
  }

  @Test
  // La quality de Aged Brie augmente de 2 / quality < 0, sellIn < 0
  void agedBrieQualityIncrementBy2P2() {
    final int quality = -1;
    final int sellIn = 0;
    final Item[] items = new Item[] {new Item(AGED_BRIE, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality + 2));
  }

  @Test
  // La quality de Aged Brie ne peut dépasser 50 / quality = 49, sellIn < 0
  void agedBrieQualityMax50P1() {
    final int quality = 49;
    final int sellIn = 0;
    final Item[] items = new Item[] {new Item(AGED_BRIE, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(50));
  }

  @Test
  // La quality de Aged Brie ne peut dépasser 50 / quality = 50, sellIn > 0
  void agedBrieQualityMax50P2() {
    final int quality = 50;
    final int sellIn = 1;
    final Item[] items = new Item[] {new Item(AGED_BRIE, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(50));
  }


  @Test
  // La quality de Backstage passes augmente de 3 / quality > 0, 0 < sellIn <= 5
  void backstagePassesQualityIncrementBy3P1() {
    final int quality = 1;
    final int sellIn = 5;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality + 3));
  }

  @Test
  // La quality de Backstage passes augmente de 3 / quality < 0, 0 < sellIn <= 5
  void backstagePassesQualityIncrementBy3P2() {
    final int quality = -1;
    final int sellIn = 5;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality + 3));
  }

  @Test
  // La quality de Backstage ne peut dépasser 50 / quality = 49, 0 < sellIn <= 5
  void backstagePassesQualityMax50P1() {
    final int quality = 49;
    final int sellIn = 5;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(50));
  }

  @Test
  // La quality de Backstage passes augmente de 2 / quality > 0, 6 <= sellIn <= 10
  void backstagePassesQualityIncrementBy2P1() {
    final int quality = 1;
    final int sellIn = 6;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality + 2));
  }

  @Test
  // La quality de Backstage passes augmente de 2 / quality < 0, 6 <= sellIn <= 10
  void backstagePassesQualityIncrementBy2P2() {
    final int quality = -1;
    final int sellIn = 6;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality + 2));
  }

  @Test
  // La quality de Backstage passes ne peut dépasser 50 / quality = 49, 6 <= sellIn <= 10
  void backstagePassesQualityMax50P2() {
    final int quality = 49;
    final int sellIn = 6;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(50));
  }

  @Test
  // La quality de Backstage passes augmente de 1 / quality > 0, sellIn >= 11
  void backstagePassesQualityIncrementBy1P1() {
    final int quality = 1;
    final int sellIn = 11;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality + 1));
  }

  @Test
  // La quality de Backstage passes augmente de 1 / quality < 0, sellIn >= 11
  void backstagePassesQualityIncrementBy1P2() {
    final int quality = -1;
    final int sellIn = 11;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(quality + 1));
  }

  @Test
  // La quality de Backstage passes ne peut dépasser 50 / quality = 50, sellIn >= 11
  void backstagePassesQualityMax50P3() {
    final int quality = 50;
    final int sellIn = 11;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(50));
  }

  @Test
  // La quality de Backstage passes tombe à 0 quand sellIn = 0 / quality > 0, sellIn <= 0
  void backstagePassesQualityIs0P1() {
    final int quality = 10;
    final int sellIn = 0;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertThat(app.items[0].quality, is(0));
  }

  @Test
  // La quality de Backstage passes tombe à 0 quand sellIn = 0 / quality < 0, sellIn <= 0
  void backstagePassesQualityIs0P2() {
    final int quality = -10;
    final int sellIn = 0;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertThat(app.items[0].quality, is(0));
  }



  /*****************************
  * TESTS SUR LA VALEUR SELLIN *
  *****************************/

  @Test
  // Le sellIn des items basiques diminue de 1 / quality > 0, sellIn > 0
  void basicItemSellInDecrementBy1P1() {
    final int quality = 50;
    final int sellIn = 2;
    final Item[] items = new Item[] {new Item(BASIC_ITEM, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }

  @Test
  // Le sellIn des items basiques diminue de 1 / quality < 0, sellIn > 0
  void basicItemSellInDecrementBy1P2() {
    final int quality = 0;
    final int sellIn = 2;
    final Item[] items = new Item[] {new Item(BASIC_ITEM, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }

  @Test
  // Le sellIn des items basiques diminue de 1 / quality > 0, sellIn < 0
  void basicItemSellInDecrementBy1P3() {
    final int quality = 50;
    final int sellIn = 2;
    final Item[] items = new Item[] {new Item(BASIC_ITEM, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }

  @Test
  // Le sellIn des items basiques diminue de 1 / quality < 0, sellIn < 0
  void basicItemSellInDecrementBy1P4() {
    final int quality = 0;
    final int sellIn = 2;
    final Item[] items = new Item[] {new Item(BASIC_ITEM, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }


  @Test
  // Le sellIn de Sulfuras ne change pas / quality > 0, sellIn > 0
  void sulfurasSellInInchanged1() {
    final int quality = 80;
    final int sellIn = 1000;
    // doit être 80 selon les specs mais n'est pas vérifié dans le code

    final Item[] items = new Item[] {new Item(SULFURAS, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn));
  }

  @Test
  // Le sellIn de Sulfuras ne change pas / quality < 0, sellIn > 0
  void sulfurasSellInInchanged2() {
    final int quality = 80;
    final int sellIn = -1000;
    // doit être 80 selon les specs mais n'est pas vérifié dans le code

    final Item[] items = new Item[] {new Item(SULFURAS, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn));
  }

  @Test
  // Le sellIn de Sulfuras ne change pas / quality > 0, sellIn < 0
  void sulfurasSellInInchanged3() {
    final int quality = -80;
    final int sellIn = 1000;
    // doit être 80 selon les specs mais n'est pas vérifié dans le code

    final Item[] items = new Item[] {new Item(SULFURAS, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn));
  }

  @Test
  // Le sellIn de Sulfuras ne change pas / quality < 0, sellIn < 0
  void sulfurasSellInInchanged4() {
    final int quality = -80;
    final int sellIn = -1000;
    // doit être 80 selon les specs mais n'est pas vérifié dans le code

    final Item[] items = new Item[] {new Item(SULFURAS, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn));
  }


  @Test
  // Le sellIn de Aged Brie diminue de 1 / quality > 0, sellIn > 0
  void agedBrieSellInDecrementBy1P1() {
    final int quality = 1;
    final int sellIn = 1;
    final Item[] items = new Item[] {new Item(AGED_BRIE, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }

  @Test
  // Le sellIn de Aged Brie diminue de 1 / quality < 0, sellIn > 0
  void agedBrieSellInDecrementBy1P2() {
    final int quality = -1;
    final int sellIn = 1;
    final Item[] items = new Item[] {new Item(AGED_BRIE, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }

  @Test
  // Le sellIn de Aged Brie diminue de 1 / quality > 0, sellIn < 0
  void agedBrieSellInDecrementBy1P3() {
    final int quality = 1;
    final int sellIn = 0;
    final Item[] items = new Item[] {new Item(AGED_BRIE, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }

  @Test
  // Le sellIn de Aged Brie diminue de 1 / quality < 0, sellIn < 0
  void agedBrieSellInDecrementBy1P4() {
    final int quality = -1;
    final int sellIn = 0;
    final Item[] items = new Item[] {new Item(AGED_BRIE, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }


  @Test
  // Le sellIn de Backstage passes diminue de 1 / quality > 0, sellIn > 0
  void backstagePassesSellInDecrementBy1P1() {
    final int quality = 1;
    final int sellIn = 1;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }

  @Test
  // Le sellIn de Backstage passes diminue de 1 / quality < 0, sellIn > 0
  void backstagePassesSellInDecrementBy1P2() {
    final int quality = -1;
    final int sellIn = 1;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }

  @Test
  // Le sellIn de Backstage passes diminue de 1 / quality > 0, sellIn < 0
  void backstagePassesSellInDecrementBy1P3() {
    final int quality = 1;
    final int sellIn = 0;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }

  @Test
  // Le sellIn de Backstage passes diminue de 1 / quality < 0, sellIn < 0
  void backstagePassesSellInDecrementBy1P4() {
    final int quality = -1;
    final int sellIn = 0;
    final Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }



  /*
  @Test //échec car non implémenté
  // La quality de Sulfuras doit être 80
  void sulfurasQuality80() {
    final int quality = 42;
    final int sellIn = 1000;
    final Item[] items = new Item[] {new Item(SULFURAS, sellIn, quality)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].quality, is(80));
  }
  */

  /*
  @Test
  // Après 1 jour, le sellIn des items Conjured (comme tous les items) diminue de 1
  void conjuredellInDecrement1() {
    final int quality = 0;
    final int sellIn = 2;
    final Item[] items = new Item[] {new Item("Conjured Mana Cake", sellIn, quality)};

    final GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertThat(app.items[0].sellIn, is(sellIn - 1));
  }
  */
}




/*
Certains tests unitaires ne vont pas passer, on expliquera pourquoi ?
Modifier le code updateQuality() (après l'ex 2) pour que tous passent



Nous avons récemment signé un partenariat avec un fournisseur de produit invoqué ("Conjured").
Cela nécessite une mise à jour de notre système :
- les éléments "Conjured" voient leur qualité se dégrader de deux fois plus vite que les objets normaux.
tems[i].name.startsWith("Conjured")
Tout peut être conjured, comportement des items ?

on peut instancier un item Sulfuras avec une qualité autre que 80 ?

qualité de Aged Brie augmente toujours de 1 même après date de péremption ?

tableau Yann dans le rapport
*/
