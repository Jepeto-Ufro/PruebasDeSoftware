## Descripción
A format for expressing an ordered list of integers is to use a comma separated list of either

* individual integers
* or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'. The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers. For example "12,13,15-17"
Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.

# Example:
```js
Solution.rangeExtraction(new int[] {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20})
# returns "-10--8,-6,-3-1,3-5,7-11,14,15,17-20"
```

## Mi solución

```js
import java.util.*;

class Solution {
    public static String rangeExtraction(int[] arr) {
      List<String> lista = new ArrayList<>();
      int contador = 0;
      for (int i=0; i < arr.length;){
        contador = 0;
        String inicio = String.valueOf(arr[i]);
        while(i != arr.length -1 && arr[i + 1 ] - arr[i] == 1){
          contador++;
          i++;
        }
        if(contador > 0) {
          if(contador > 1) inicio += "-" + (Integer.parseInt(inicio) + contador);
          else i--;
        }
        lista.add(inicio);
        i++;
      }
        return String.join(",", lista);
    }
}
```

## Test


```js
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SolutionTest {
    @Test
    public void test_BasicTests() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", Solution.rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18,19,20}));
				
        assertEquals("-3--1,2,10,15,16,18-20", Solution.rangeExtraction(new int[] {-3,-2,-1,2,10,15,16,18,19,20}));
    }
}
```
