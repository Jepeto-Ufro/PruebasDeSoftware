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