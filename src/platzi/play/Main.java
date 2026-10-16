package platzi.play;

// Importa clases de aplicación
import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

public class Main {
    private static final String NOMBRE_PLATAFORMA = "Platzi Play";
    private static final String VERSION = "1.0.0";

    // Constantes para opciones
    private static final int AGREGAR = 1;
    private static final int SALIR = 5;

    public static void main(String[] args) {
        while (true) {
            int opcionElegida = ScannerUtils.capturarNumero("""
                    Ingrese una opción:
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por título
                    4. Eliminar
                    5. Salir
                    """);

            switch (opcionElegida){
                case AGREGAR -> {
                    // falta
                }
                case SALIR -> System.exit(0);
                default -> System.out.println("Opción elegida: " + opcionElegida);
            }
        }
    }
}
