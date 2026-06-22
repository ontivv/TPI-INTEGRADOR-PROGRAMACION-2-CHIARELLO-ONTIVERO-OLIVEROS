package entities;

import java.util.List;
import java.util.Scanner;

import exceptions.ValidacionEntradaException;
import service.CategoriaService;
import entities.Categoria;

public class Main {
    public static void main(String[] args) {
        CategoriaService categoriaService = new CategoriaService();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== SISTEMA DE GESTIÓN ALIMENTICIA ===");

        while (continuar) {
            System.out.println("\n--- SUBMENÚ DE CATEGORÍAS ---");
            System.out.println("1. Registrar nueva categoría (Teclado)");
            System.out.println("2. Listar todas las categorías");
            System.out.println("3. Salir del programa");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();
            scanner.nextLine(); // Limpieza crucial del buffer del scanner para evitar saltos de línea molestos

            switch (opcion) {
                case "1":
                    System.out.print("\nIngrese el nombre de la categoría: ");
                    String nombre = scanner.nextLine(); // Sigue igual

                    System.out.print("Ingrese la descripción: ");
                    String descripcion = scanner.nextLine(); // Sigue igual

                    try {
                        categoriaService.registrarCategoria(nombre, descripcion);
                        System.out.println("¡Categoría registrada con éxito!"); // Agregué un mensajito de éxito visual
                    } catch (ValidacionEntradaException e) {
                        System.err.println("\n[ERROR DE VALIDACIÓN]: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.println("\n--- LISTADO DE CATEGORÍAS EN MEMORIA/BD ---");
                    List<Categoria> lista = categoriaService.listarCategorias();

                    if (lista.isEmpty()) {
                        System.out.println("No hay categorías registradas en el sistema.");
                    } else {
                        for (Categoria cat : lista) {
                            System.out.println("ID: " + cat.getId() + " | Nombre: " + cat.getNombre() + " | Descripción: " + cat.getDescripcion());
                        }
                    }
                    break;

                case "3":
                    System.out.println("Saliendo de la sección de pruebas...");
                    continuar = false;
                    break;

                default:
                    // Si el usuario ingresa "4", "Hola", "abc" o aprieta Enter sin querer, cae acá de forma segura
                    System.out.println("Opción inválida. Intente nuevamente con '1', '2' o '3'.");
            }
        }
        scanner.close();
    }
}
