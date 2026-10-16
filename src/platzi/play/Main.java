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
        }


        // Plataforma
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA, VERSION);

        System.out.println(plataforma.getNombre() + " v" + plataforma.getVersion());

        String nombre = ScannerUtils.capturarTexto("Escribe tu nombre");

        System.out.println("Bienvenido " + nombre);

        System.out.println("---------------------------- \n");

        System.out.println("Datos de la película");

        String titulo = ScannerUtils.capturarTexto("Título");
        String genero = ScannerUtils.capturarTexto("Genero");
        int duracion = ScannerUtils.capturarNumero("Duración");
        double calificacion = ScannerUtils.capturarDecimal("Calificación");

        Pelicula pelicula = new Pelicula(titulo, duracion, genero, calificacion);

        Pelicula pelicula1 = new Pelicula("Matrix", 120, "Cyberpunk", 4.7);

        // Añade pelicula a plataforma
        plataforma.agregar(pelicula);
        plataforma.agregar(pelicula1);
        System.out.println("Número de elementos en la plataforma: " + plataforma.getContenido().size());

        plataforma.eliminar(pelicula1);

        plataforma.mostrarTitulos();
        //System.out.println(pelicula.obtenerFichaTecnica());

        Usuario usuario = new Usuario("Juan", "juan@example.com");

        // Getters y setters
        pelicula.setDisponible(true);

        // Info de usuario
        System.out.println("El usuario " + usuario.getNombre() + " tiene registro con fecha " + usuario.getFechaRegistro());

        // Ver película
        usuario.ver(pelicula);

        // Casting implicito
        /*long duracionLong = pelicula.duracion;
        System.out.println("Duración long: " + duracionLong);*/

        // Casting explicito
        /*int calificacionInt = (int) pelicula.calificacion;
        System.out.println("Calificación int: " + calificacionInt);*/
    }
}
