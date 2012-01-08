package classes;

import static org.junit.Assert.*;
import org.junit.Test;

public class GeomTest {

  @Test
  public void hypotenuseTest() {
    double x = 0.0, y = 0.0, h = Math.sqrt(0.0);
    assertEquals(Geom.hypot(x, y), h, 0.0);

    x = 1.0; y = 0.0; h = Math.sqrt(1.0);
    assertEquals(Geom.hypot(x, y), h, 0.0);

    x = 0.0; y = 1.0; h = Math.sqrt(1.0);
    assertEquals(Geom.hypot(x, y), h, 0.0);

    x = 1.0; y = 1.0; h = Math.sqrt(2.0);
    assertEquals(Geom.hypot(x, y), h, 0.0);
  }

}
