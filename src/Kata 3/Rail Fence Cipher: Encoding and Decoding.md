## Descripción
Create two functions to encode and then decode a string using the Rail Fence Cipher. This cipher is used to encode a string by placing each character successively in a diagonal along a set of "rails". First start off moving diagonally and down. When you reach the bottom, reverse direction and move diagonally and up until you reach the top rail. Continue until you reach the end of the string. Each "rail" is then read left to right to derive the encoded string.

For example, the string "WEAREDISCOVEREDFLEEATONCE" could be represented in a three rail system as follows:

```js
W       E       C       R       L       T       E
  E   R   D   S   O   E   E   F   E   A   O   C  
    A       I       V       D       E       N    
```
The encoded string would be:

```js
WECRLTEERDSOEEFEAOCAIVDEN  
```
Write a function/method that takes 2 arguments, a string and the number of rails, and returns the ENCODED string.

Write a second function/method that takes 2 arguments, an encoded string and the number of rails, and returns the DECODED string.

For both encoding and decoding, assume number of rails >= 2 and that passing an empty string will return an empty string.

Note that the example above excludes the punctuation and spaces just for simplicity. There are, however, tests that include punctuation. Don't filter out punctuation as they are a part of the string.

## Mi solución

```js
import java.util.ArrayList;

public class RailFenceCipher {
    
    static String encode(String s, int n) {
      ArrayList<StringBuilder> listaSB = new ArrayList<>(n);
      for (int i = 0; i<n; i++){
        listaSB.add(new StringBuilder());
      }
      
      for (int i=0;i<s.length();i++){
        int j = i % ((n - 1) * 2);
        j = j >= n ? n - (j % n) - 2 : j % n;
        listaSB.get(j).append(s.charAt(i));
      }
      
      StringBuilder codificado = new StringBuilder();
      
      for (StringBuilder codigo : listaSB){
        codificado.append(codigo);
      }
      
      return new String(codificado);
      }
    
    static String decode(String s, int n) {
      int direccionFila = 1;
      int fila = 0;
      int index = 0;
      ArrayList<Character> caracter = new ArrayList<>(s.length());
      
      for(int i=0; i<s.length(); i++){
        caracter.add(i, null);
      }
      
      for(int i = 0; i < s.length(); i++){
        caracter.set(index,s.charAt(i));
        
        index += (n-1) * 2;
        
        if(0 < fila && fila < n - 1 ){
          int añadirIndex = index - (fila * 2);
          
          if(añadirIndex < s.length() && (i + 1 < s.length())) {
            caracter.set(añadirIndex,s.charAt(++i));
          }
        }
      
        if (index >= s.length()){
          if(fila == 0){
            direccionFila = 1;
          }else if (fila == n-1){
            direccionFila = -1;
          } 
        fila += direccionFila;
        index = fila;
        }
      }
      
      final StringBuilder decodificado = new StringBuilder();
      
      for(Character c : caracter){
        decodificado.append(c);
      }
      return new String(decodificado);
    }
}
```

## Test


```js
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

// TODO: Replace examples and use TDD development by writing your own tests

public class SolutionTest {

    @Test
    public void encodeSampleTests() {
        String[][] encodes = {{"WEAREDISCOVEREDFLEEATONCE", "WECRLTEERDSOEEFEAOCAIVDEN"},  // 3 rails
                              {"Hello, World!", "Hoo!el,Wrdl l"},    // 3 rails
                              {"Hello, World!", "H !e,Wdloollr"},    // 4 rails
                              {"", ""}                               // 3 rails (even if...)
                             };
        int[] rails = {3,3,4,3};
        for (int i=0 ; i<encodes.length ; i++) {
            assertEquals(encodes[i][1], RailFenceCipher.encode(encodes[i][0], rails[i]));
        }
    }
        
        
    @Test
    public void decodeSampleTests() {
        String[][] decodes = {{"WECRLTEERDSOEEFEAOCAIVDEN", "WEAREDISCOVEREDFLEEATONCE"},    // 3 rails
                              {"H !e,Wdloollr", "Hello, World!"},    // 4 rails
                              {"", ""}                               // 3 rails (even if...)
                             };
        int[] rails = {3,4,3};
        for (int i=0 ; i<decodes.length ; i++) {
            assertEquals(decodes[i][1], RailFenceCipher.decode(decodes[i][0], rails[i]));
        }
    }
    
    
}

```
