package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

  Svatky svatky = new Svatky();

  /**
   * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
   */
  @Test
  void kdyMaSvatek() {
    assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
    assertNull(svatky.kdyMaSvatek("Eva"));
  }

  /**
   * Testuje metodu {@link Svatky#jeVSeznamu(String)}
   */
  @Test
  void jeVSeznamu() {
    assertTrue(svatky.jeVSeznamu("Nataša"));
    assertFalse(svatky.jeVSeznamu("Petra"));
  }

  /**
   * Testuje metodu {@link Svatky#getPocetJmen()}
   */
  @Test
  void getPocetJmen() {
    assertEquals(37, svatky.getPocetJmen());
  }

  /**
   * Testuje metodu {@link Svatky#getSeznamJmen()}
   */
  @Test
  void getSeznamJmen() {
    assertNotNull(svatky.getSeznamJmen());
    assertEquals(37, svatky.getPocetJmen());
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
   */
  @Test
  void pridatSvatekDenMesicInt() {
    Svatky svatky = new Svatky();

    svatky.pridatSvatek("Petra", 1, 5);

    assertTrue(svatky.jeVSeznamu("Petra"));
    assertEquals(MonthDay.of(5,1), svatky.kdyMaSvatek("Petra"));

  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
   */
  @Test
  void pridatSvatekDenMesicMonth() {
    Svatky svatky = new Svatky();

    svatky.pridatSvatek("Petra", 1, Month.of(5));

    assertTrue(svatky.jeVSeznamu("Petra"));
    assertEquals(MonthDay.of(5,1), svatky.kdyMaSvatek("Petra"));

  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
   */
  @Test
  void prridatSvatekMonthDay() {
    Svatky svatky = new Svatky();

    svatky.pridatSvatek("Petra",MonthDay.of(5,1) );

    assertTrue(svatky.jeVSeznamu("Petra"));
    assertEquals(MonthDay.of(5,1), svatky.kdyMaSvatek("Petra"));


  }

  /**
   * Testuje metodu {@link Svatky#smazatSvatek(String)}
   */
  @Test
  void smazatSvatek() {
    Svatky svatky = new Svatky();
    svatky.smazatSvatek("Zikmund");
    assertFalse(svatky.jeVSeznamu("Zikmund"));
  }
}
