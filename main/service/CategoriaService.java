package service;

import dao.CategoriaDAO;
import entities.Categoria;
import exceptions.ValidacionEntradaException;

import java.util.List;

public class CategoriaService {

    private final CategoriaDAO categoriaDAO;

    public CategoriaService() {
        this.categoriaDAO = new CategoriaDAO();
    }

    public void registrarCategoria(String nombre, String descripcion) throws ValidacionEntradaException {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ValidacionEntradaException("El nombre de la categoría es obligatorio y no puede estar vacío.");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new ValidacionEntradaException("La descripción es obligatoria y no puede estar vacía.");
        }

        List<Categoria> categoriasExistentes = categoriaDAO.obtenerTodas();
        for (Categoria cat : categoriasExistentes) {
            if (cat.getNombre().equalsIgnoreCase(nombre.trim())) {
                throw new ValidacionEntradaException("Ya existe una categoría registrada con el nombre: '" + nombre + "'.");
            }
        }

        Categoria nuevaCategoria = new Categoria(nombre.trim(), descripcion.trim());

        categoriaDAO.crear(nuevaCategoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaDAO.obtenerTodas();
    }

}
