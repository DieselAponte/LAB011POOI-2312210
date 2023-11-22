
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author diese
 */
public class Actividad01Libros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Libro> ListaLibreria = new ArrayList<>();
        ListaLibreria.add(new Libro("Cien años de soledad", new Autor("Gabriel García Márquez", ".", 'm'), 200, 400));
        ListaLibreria.add(new Libro("El señor de los anillos (Trilogía)", new Autor("J. R. R. Tolkien", ".", 'm'), 1500, 1200));
        ListaLibreria.add(new Libro("1984", new Autor("George Orwell", ".", 'm'), 500, 300));
        ListaLibreria.add(new Libro("Un mundo feliz", new Autor("Aldous Huxley", ".", 'm'), 320, 500));
        ListaLibreria.add(new Libro("Orgullo y prejuicio", new Autor("Jane Austen", ".", 'f'), 130, 700));
        ListaLibreria.add(new Libro("Crimen y castigo", new Autor("Fiódor Dostoyevski", ".", 'm'), 230, 540));
        ListaLibreria.add(new Libro("Lolita", new Autor("Vladimir Nabokov", ".", 'm'), 140, 456));
        ListaLibreria.add(new Libro("Ulises", new Autor("James Joyce", ".", 'm'), 158, 400));
        ListaLibreria.add(new Libro("Madame Bovary", new Autor("Gustave Flaubert", ".", 'm'), 120, 430));
        ListaLibreria.add(new Libro("En busca del tiempo perdido", new Autor("Marcel Proust", ".", 'm'), 345, 450));
        ListaLibreria.add(new Libro("Don Quijote de la Mancha", new Autor("Miguel de Cervantes", ".", 'm'), 340, 123));
        ListaLibreria.add(new Libro("El retrato de Dorian Gray", new Autor("Oscar Wilde", ".", 'm'), 125, 67));
        ListaLibreria.add(new Libro("El Principito", new Autor("Antoine de Saint-Exupéry", ".", 'm'), 259, 345));
        ListaLibreria.add(new Libro("El ruido y la furia", new Autor("William Faulkner", ".", 'm'), 134, 246));
        ListaLibreria.add(new Libro("Los viajes de Gulliver", new Autor("Jonathan Swif", ".", 'm'), 186, 234));
        ListaLibreria.add(new Libro("Memorias de una geisha", new Autor("Arthur Golden", ".", 'm'), 195, 234));
        ListaLibreria.add(new Libro("Los juegos del hambre", new Autor("Suzanne Collins", ".", 'f'), 181, 234));
        ListaLibreria.add(new Libro("Harry Potter y la piedra filosofal", new Autor("J. K. Rowling", "", 'f'), 650, 4000));
        ListaLibreria.add(new Libro("Los miserables", new Autor("Victor Hugo", ".", 'm'), 23, 245));
        ListaLibreria.add(new Libro("Las crónicas de Narnia", new Autor("C. S. Lewis", ".", 'm'), 456, 444));

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("** BIENVENIDOS AL SISTEMA DE GESTION DE LIBRERIA **");
            System.out.println("1-Mostrar la lista de libros");
            System.out.println("2-Agregar un libro y asignar el autor del libro");
            System.out.println("3-Eliminar un libro");
            System.out.println("4-Editar un libro");
            System.out.println("5-Buscar un libro por titulo");
            System.out.println("6-Buscar el autor dado un libro");
            System.out.println("7-Ordenar los libros por autor");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Los libros disponibles en la libreria son: ");
                    for (Libro libro : ListaLibreria) {
                        System.out.println(libro);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del libro:");
                    String nombreLibro = scanner.next();

                    System.out.println("Ingrese el nombre del autor:");
                    String nombreAutor = scanner.next();

                    System.out.println("Ingrese el email del autor:");
                    String emailAutor = scanner.next();

                    System.out.println("Ingrese el género del autor (m/f):");
                    char generoAutor = scanner.next().charAt(0);

                    System.out.println("Ingrese el precio del libro:");
                    double precioLibro = scanner.nextDouble();

                    System.out.println("Ingrese la cantidad de libros:");
                    int cantidadLibros = scanner.nextInt();

                    Autor autorNuevo = new Autor(nombreAutor, emailAutor, generoAutor);
                    Libro libroNuevo = new Libro(nombreLibro, autorNuevo, precioLibro, cantidadLibros);
                    ListaLibreria.add(libroNuevo);

                    System.out.println("Libro agregado correctamente.");
                    break;

                case 3:

                    System.out.println("Ingrese la posicion del libro a eliminar:");
                    int posicionEliminar = scanner.nextInt();

                    if (posicionEliminar >= 1 && posicionEliminar <= ListaLibreria.size()) {
                        Libro libroEliminarPorPosicion = ListaLibreria.remove(posicionEliminar - 1);
                        System.out.println("Libro eliminado correctamente: " + libroEliminarPorPosicion);
                    } else {
                        System.out.println("Posición invalida. No se encontró el libro.");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el titulo del libro a editar:");
                    String tituloEditar = scanner.next();

                    
                    Libro libroEditar = null;
                    for (Libro libro : ListaLibreria) {
                        if (libro.getNombre().equalsIgnoreCase(tituloEditar)) {
                            libroEditar = libro;
                            break;
                        }
                    }

                    
                    if (libroEditar != null) {
                        System.out.println("Ingrese el nuevo precio del libro:");
                        double nuevoPrecio = scanner.nextDouble();

                        System.out.println("Ingrese la nueva cantidad de libros:");
                        int nuevaCantidad = scanner.nextInt();

                        libroEditar.setPrecio(nuevoPrecio);
                        libroEditar.setCantidad(nuevaCantidad);

                        System.out.println("Libro editado correctamente.");
                    } else {
                        System.out.println("No se encontró el libro con el título proporcionado.");
                    }
                    break;

                case 5:

                    System.out.println("Ingrese el título del libro a buscar:");
                    String tituloBuscar = scanner.next();
                    boolean libroEncontrado = false;

                    for (Libro libro : ListaLibreria) {
                        if (libro.getNombre().equalsIgnoreCase(tituloBuscar)) {
                            System.out.println("Libro encontrado: " + libro);
                            libroEncontrado = true;
                            break;
                        }
                    }

                    if (!libroEncontrado) {
                        System.out.println("No se encontró un libro con el título proporcionado.");
                    }
                    break;

                case 6:
                    System.out.println("Ingrese el título del libro para buscar al autor:");
                    String tituloBuscarAutor = scanner.next();
                    boolean libroEncontradoParaAutor = false;

                    for (Libro libro : ListaLibreria) {
                        if (libro.getNombre().equalsIgnoreCase(tituloBuscarAutor)) {
                            System.out.println("Autor del libro '" + libro.getNombre() + "': " + libro.getAutor());
                            libroEncontradoParaAutor = true;
                            break;
                        }
                    }

                    if (!libroEncontradoParaAutor) {
                        System.out.println("No se encontró un libro con el título proporcionado.");
                    }
                    break;
                case 7:
                    
                    break;
            }
            if (opcion != 7) {
                System.out.print("¿DESEA INGRESAR OTRA OPCION? (1-SI, 0-NO): ");
                int continuar = scanner.nextInt();
                if (continuar != 1) {
                    opcion = 7;
                }
            }
        } while (opcion != 7);
    }
}
