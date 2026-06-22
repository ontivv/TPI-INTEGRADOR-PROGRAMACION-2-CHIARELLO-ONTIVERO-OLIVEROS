package dao;

import config.ConexionDB;
import entities.Categoria;
import exceptions.ValidacionEntradaException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public void crear(Categoria categoria) {
        String sql = "INSERT INTO categoria (nombre, descripcion) VALUES (?, ?)";

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, categoria.getNombre());
            pstmt.setString(2, categoria.getDescripcion());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    categoria.setId(rs.getLong(1));
                }
            }
            System.out.println("Categoría guardada exitosamente en la base de datos.");

        } catch (SQLException e) {
            System.err.println("Error al guardar la categoría en BD: " + e.getMessage());
        }
    }

    public List<Categoria> obtenerTodas() {
        List<Categoria> listaCategorias = new ArrayList<>();

        String sql = "SELECT * FROM categoria WHERE eliminado = false";

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Long id = rs.getLong("id");
                boolean eliminado = rs.getBoolean("eliminado");

                Timestamp ts = rs.getTimestamp("createAt");
                LocalDateTime createAt = (ts != null) ? ts.toLocalDateTime() : null;

                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");

                try {
                    Categoria categoria = new Categoria(id, eliminado, createAt, nombre, descripcion);
                    listaCategorias.add(categoria); // Lo metemos en la Colección
                } catch (ValidacionEntradaException e) {
                    System.err.println("Error de validación al cargar la categoría ID " + id + ": " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las categorías: " + e.getMessage());
        }

        return listaCategorias;
    }
}
