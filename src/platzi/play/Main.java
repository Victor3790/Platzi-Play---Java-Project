package platzi.play;

// Importa clases de aplicación
import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

public class Main {
    public static final String NOMBRE_PLATAFORMA = "Platzi Play";
    public static final String VERSION = "1.0.0";

    public static void main(String[] args) {

        // 1. Agregar contenido
        // 2. Mostrar todo
        // 3. Buscar por título
        // 4. Eliminar
        // 5. Salir

        while (true) {
            int opcionElegida = ScannerUtils.capturarNumero("""
                    Ingrese una opción:
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por título
                    4. Eliminar
                    5. Salir
                    """);

            System.out.println("Opción elegida: " + opcionElegida);

            if (opcionElegida == 5) {
                System.exit(0);
            }
        }
    }
}
