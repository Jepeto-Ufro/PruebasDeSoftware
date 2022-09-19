## Descripción

If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in. Additionally, if the number is negative, return 0 (for languages that do have them).

Note: If the number is a multiple of both 3 and 5, only count it once.
## Mi solución

```js
public class Solution {

  public int solution(int numero) {
    int contador = 0;
    
    for(int i=0; i<numero;i++){
      if(i % 3 == 0|| i % 5 == 0){
        contador += i;
      }
    }
    
    return contador;
  }
}
```

## Test


```js
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
      assertEquals(23, new Solution().solution(10));
    }
    
}
```
