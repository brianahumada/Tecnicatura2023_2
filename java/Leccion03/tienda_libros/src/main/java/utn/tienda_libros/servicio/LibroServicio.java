package utn.tienda_libros.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.tienda_libros.modelo.Libro;
import utn.tienda_libros.repositorio.LibroRepositorio;

import java.util.List;

@Service
public class LibroServicio implements ILibroServicio{
    //servicio de clase necesario
    @Autowired
    private LibroRepositorio libroRepositorio;
    @Override
    public List<Libro> listarLibros() {
        return libroRepositorio.findAll();//regresa todos los libros de la tabla de bases de datos
    }

    @Override
    public Libro buscarLibroPorId(Integer idLibro) {
        Libro libro = libroRepositorio.findById(idLibro).orElse(null);//si el id no existe devuelve un null con el metodo orElse = null
        return libro;
    }

    @Override
    public void guardarLibro(Libro libro) {
        libroRepositorio.save(libro);//guarda el libro automatico

    }

    @Override
    public void eliminarLibro(Libro libro) {
        libroRepositorio.delete(libro);
    }
}
