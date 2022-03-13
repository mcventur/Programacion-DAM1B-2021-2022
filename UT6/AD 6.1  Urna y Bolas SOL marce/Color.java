import java.util.Random;

public enum Color {
    BLANCO, NEGRO;

    public Color getColorAleatorio() {
        Random aleatorio = new Random();
        return Color.values()[aleatorio.nextInt(Color.values().length)];
    }
}
