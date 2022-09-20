public class Vowels {

    public static int getCount(String str) {
        int contador = 0;

        for(int i=0;i<str.length();i++){
            char letra = str.charAt(i);
            if(letra == 'a'|| letra == 'e'|| letra == 'i'|| letra == 'o'|| letra == 'u'){
                contador++;
            }
        }
        return contador;
    }

}