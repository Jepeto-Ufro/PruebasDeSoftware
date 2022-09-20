public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int minutos = seconds / 60;
        int horas = minutos / 60;
        minutos -= horas * 60;
        return String.format("%02d:%02d:%02d", horas, minutos, seconds % 60);
    }
}
