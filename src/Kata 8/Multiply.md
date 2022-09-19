## Descripción

This code does not execute properly. Try to figure out why.

## Mi solución

```js
public class Multiply {
    public static Double multiply(Double a, Double b) {
        return a * b;
    }
}
```

## Test


```js
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testSomething() {
      double a = 2;
      double b = 4;
      assertEquals(b, Multiply.multiply(a,a));
    }
}
```
