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