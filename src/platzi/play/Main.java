package platzi.play;

// Importa clases de aplicación
import platzi.play.contenido.Pelicula;
import platzi.play.plataforma.Plataforma;
import platzi.play.plataforma.Usuario;
import platzi.play.util.ScannerUtils;

import java.util.List;

public class Main {
    private static final String NOMBRE_PLATAFORMA = "Platzi Play";
    private static final String VERSION = "1.0.0";

    // Constantes para opciones
    private static final int AGREGAR = 1;
    private static final int MOSTRAR = 2;
    private static final int BUSCAR_POR_TITULO = 3;
    private static final int BUSCAR_POR_GENERO = 4;
    private static final int ELIMINAR = 5;
    private static final int SALIR = 6;

    public static void main(String[] args) {
        // Plataforma
        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA, VERSION);
        plataforma.mostrarInfo();

        cargarPeliculas(plataforma);

        System.out.println("Más de " + plataforma.getDuracionTotal() + " minutos de películas!!! \n");

        while (true) {
            int opcionElegida = ScannerUtils.capturarNumero("""
                    Ingrese una opción:
                    1. Agregar contenido
                    2. Mostrar todo
                    3. Buscar por título
                    4. Buscar por género
                    5. Eliminar
                    6. Salir
                    """);

            switch (opcionElegida){
                case AGREGAR -> {
                    System.out.println("---------------------------- \n");

                    System.out.println("Datos de la película");

                    String titulo = ScannerUtils.capturarTexto("Título");
                    String genero = ScannerUtils.capturarTexto("Genero");
                    int duracion = ScannerUtils.capturarNumero("Duración");
                    double calificacion = ScannerUtils.capturarDecimal("Calificación");

                    Pelicula pelicula = new Pelicula(titulo, duracion, genero, calificacion);

                    // Añade pelicula a plataforma
                    plataforma.agregar(pelicula);
                    System.out.println("Número de elementos en la plataforma: " + plataforma.getContenido().size());
                }
                case MOSTRAR -> {
                    List<String> titulos = plataforma.getTitulos();
                    titulos.forEach(System.out::println);
                }
                case BUSCAR_POR_TITULO -> {
                    String nombreBuscado = ScannerUtils.capturarTexto("Nombre del contenido a buscar: ");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombreBuscado);

                    if (pelicula != null) {
                        System.out.println(pelicula.obtenerFichaTecnica());
                    } else {
                        System.out.println(nombreBuscado + " no existe dentro de la plataforma " + plataforma.getNombre());
                    }
                }
                case BUSCAR_POR_GENERO -> {
                    String generoBuscado = ScannerUtils.capturarTexto("Nombre del genero a buscar: ");
                    List<Pelicula> contenidoPorGenero = plataforma.buscarPorGenero(generoBuscado);

                    System.out.println("Se encontraron " + contenidoPorGenero.size() + " películas del género " + generoBuscado + "\n");

                    contenidoPorGenero.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica()));
                }
                case ELIMINAR -> {
                    String nombreEliminar = ScannerUtils.capturarTexto("Nombre del contenido a eliminar: ");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombreEliminar);

                    if (pelicula != null) {
                        plataforma.eliminar(pelicula);
                    } else {
                        System.out.println(nombreEliminar + " no existe dentro de la plataforma " + plataforma.getNombre());
                    }
                }
                case SALIR -> System.exit(0);
                default -> System.out.println("Opción inválida, opción elegida: " + opcionElegida);
            }
        }
    }

    private static void cargarPeliculas(Plataforma plataforma) {
        plataforma.agregar(new Pelicula("Shrek", 90, "Animada"));
        plataforma.agregar(new Pelicula("Inception", 148, "Ciencia Ficción"));
        plataforma.agregar(new Pelicula("Titanic", 195, "Drama", 4.6));
        plataforma.agregar(new Pelicula("John Wick", 101, "Acción"));
        plataforma.agregar(new Pelicula("El Conjuro", 112, "Terror", 3.0));
        plataforma.agregar(new Pelicula("Coco", 105, "Animada", 4.7));
        plataforma.agregar(new Pelicula("Interstellar", 169, "Ciencia Ficción", 5));
        plataforma.agregar(new Pelicula("Joker", 122, "Drama"));
        plataforma.agregar(new Pelicula("Toy Story", 81, "Animada", 4.5));
        plataforma.agregar(new Pelicula("Avengers: Endgame", 181, "Acción", 3.9));
    }
}
