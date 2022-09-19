## Descripción
Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

* HH = hours, padded to 2 digits, range: 00 - 99
* MM = minutes, padded to 2 digits, range: 00 - 59
* SS = seconds, padded to 2 digits, range: 00 - 59
The maximum time never exceeds 359999 (99:59:59)

You can find some examples in the test fixtures.
## Mi solución

```js
public class HumanReadableTime {
  public static String makeReadable(int seconds) {
    int minutos = seconds / 60;
    int horas = minutos / 60;
    minutos -= horas * 60;
    return String.format("%02d:%02d:%02d", horas, minutos, seconds % 60);
  }
}
```

## Test


```js
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {
  @Test
  public void Tests() {
    assertEquals("makeReadable(0)", "00:00:00", HumanReadableTime.makeReadable(0));
    assertEquals("makeReadable(5)", "00:00:05", HumanReadableTime.makeReadable(5));
    assertEquals("makeReadable(60)", "00:01:00", HumanReadableTime.makeReadable(60));
    assertEquals("makeReadable(86399)", "23:59:59", HumanReadableTime.makeReadable(86399));
    assertEquals("makeReadable(359999)", "99:59:59", HumanReadableTime.makeReadable(359999));
  }
}
```
