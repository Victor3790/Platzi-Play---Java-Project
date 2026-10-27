package platzi.play.contenido;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula {
    private String titulo;
    private String descripcion;
    private int duracion;
    private Genero genero;
    private LocalDate fechaEstreno;
    private double calificacion;
    private boolean disponible;
    private Idioma idioma;

    public Pelicula(String titulo, int duracion, Genero genero, Idioma idioma) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.fechaEstreno = LocalDate.now();
    }

    public Pelicula(String titulo, int duracion, Genero genero, double calificacion, Idioma idioma) {
        this(titulo, duracion, genero, idioma);
        this.calificar(calificacion);
    }

    public void reproducir() {
        System.out.println("Reproduciendo " + titulo);
    }

    public String obtenerFichaTecnica() {
        return titulo + " (" + fechaEstreno.getYear() + ") \n" +
                "Genero: " + genero + " \n" +
                "Calificacion: " + calificacion + " \n ";
    }

    public void calificar(double calificacion) {
        if (calificacion >= 0 && calificacion <= 5) {
            this.calificacion = calificacion;
        }
    }

    public boolean esPopular() {
        return calificacion >= 4;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
