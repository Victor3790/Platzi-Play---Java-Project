package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private String nombre;
    private String version;
    private List<Pelicula> contenido;

    public Plataforma(String nombre, String version){
        this.nombre = nombre;
        this.version = version;
        this.contenido = new ArrayList<>();
    }

    public void mostrarInfo(){
        System.out.println(this.getNombre() + " v" + this.getVersion());
    }

    public void agregar(Pelicula elemento){
        this.contenido.add(elemento);
    }

    public void eliminar(Pelicula elemento){
        this.contenido.remove(elemento);
    }

    public Pelicula buscarPorTitulo(String titulo){
        for (Pelicula pelicula : contenido) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return pelicula;
            }
        }

        return null;
    }

    public void mostrarTitulos(){
        contenido.forEach(pelicula -> System.out.println(pelicula.getTitulo()));
    }

    public String getNombre() {
        return nombre;
    }

    public String getVersion() {
        return version;
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }
}
