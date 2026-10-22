package platzi.play.plataforma;

import platzi.play.contenido.Pelicula;

import java.util.ArrayList;
import java.util.Comparator;
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
        return contenido.stream()
                .filter(pelicula -> pelicula.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Pelicula> buscarPorGenero(String genero){
        return contenido.stream()
                .filter(pelicula -> pelicula.getGenero().equalsIgnoreCase(genero))
                .toList();
    }

    public List<String> getTitulos(){
        return contenido.stream()
                .map(Pelicula::getTitulo)
                .toList();
    }

    public int getDuracionTotal(){
        return contenido.stream()
                .mapToInt(Pelicula::getDuracion)
                .sum();
    }

    public List<Pelicula> getPopulares(int cantidad){
        return contenido.stream()
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Pelicula> getMasPopulares(){
        return contenido.stream()
                .filter(pelicula -> pelicula.getCalificacion() >= 4.0)
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .toList();
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
