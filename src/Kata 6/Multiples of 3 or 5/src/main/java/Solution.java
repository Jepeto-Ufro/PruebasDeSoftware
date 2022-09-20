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