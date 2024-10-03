package Documentacion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
@autor: Jorge David Torrico Copali
@codigo sis: 202200286
 * Clase que representa un usuario con un nombre, contraseña y su lista de tareas.
 */
public class Usuario {

    private String nombreUsuario;
    private String password;
    private String archivoUsuarios;
    private ListaDeTareas listaDeTareas;

    /**
     * Constructor de la clase Usuario.
     * 
     * @param nombre Nombre del usuario.
     * @param contraseña Contraseña del usuario.
     */
    public Usuario(String nombre, String contraseña) {
        this.nombreUsuario = nombre;
        this.password = contraseña;
        this.archivoUsuarios = "usuarios.txt";
        this.listaDeTareas = new ListaDeTareas(nombre);
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombreUsuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return Contraseña del usuario.
     */
    public String getContraseña() {
        return password;
    }

    /**
     * Obtiene la lista de tareas del usuario.
     * 
     * @return Lista de tareas del usuario.
     */
    public ListaDeTareas getListaDeTareas() {
        return listaDeTareas;
    }

    /**
     * Guarda la información del usuario en un archivo.
     */
    public void guardarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoUsuarios, true))) {
            bw.write(nombreUsuario + "," + password);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    /**
     * Carga la lista de usuarios desde un archivo.
     * 
     * @return Lista de usuarios.
     */
    public static List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        File archivo = new File("usuarios.txt");
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de usuarios: " + e.getMessage());
            }
            return usuarios;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    usuarios.add(new Usuario(partes[0], partes[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
        return usuarios;
    }
}
