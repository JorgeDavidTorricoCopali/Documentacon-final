package Documentacion;
import java.time.LocalDate;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
@autor: Jorge David Torrico Copali 
@codigo sis: 202200286
 * Clase que gestiona la lista de tareas personales de un usuario.
 * Permite agregar, eliminar, guardar y cargar tareas desde un archivo.
 */
public class ListaDeTareas {

    private String nombreDeUsuario;
    private List<Tarea> tareasPersonales;
    private String nombreArchivoTareas;

    /**
     * Constructor de la clase ListaDeTareas.
     * 
     * @param nombreUsuario Nombre del usuario propietario de la lista de tareas.
     */
    public ListaDeTareas(String nombreUsuario) {
        this.nombreDeUsuario = nombreUsuario;
        this.tareasPersonales = new ArrayList<>();
        this.nombreArchivoTareas = nombreUsuario + "_tareas.txt";
        cargarTareas();
    }

    /**
     * Agrega una nueva tarea a la lista.
     * 
     * @param tarea Tarea a agregar.
     */
    public void agregarTarea(Tarea tarea) {
        tareasPersonales.add(tarea);
        guardarTareas();
    }

    /**
     * Elimina una tarea de la lista.
     * 
     * @param tarea Tarea a eliminar.
     */
    public void eliminarTarea(Tarea tarea) {
        tareasPersonales.remove(tarea);
        guardarTareas();
    }

    /**
     * Retorna la lista de tareas.
     * 
     * @return Lista de tareas personales.
     */
    public List<Tarea> getTareas() {
        return tareasPersonales;
    }

    /**
     * Guarda las tareas en un archivo.
     */
    public void guardarTareas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoTareas))) {
            for (Tarea tarea : tareasPersonales) {
                bw.write(tarea.getNombre() + "," + tarea.getFecha() + "," + tarea.getPrioridad() + "," + tarea.isCompletada());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar tareas: " + e.getMessage());
        }
    }

    /**
     * Carga las tareas desde el archivo asociado al usuario.
     */
    private void cargarTareas() {
        File archivo = new File(nombreArchivoTareas);
        if (!archivo.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String nombre = partes[0];
                    LocalDate fecha = LocalDate.parse(partes[1]);
                    String prioridad = partes[2];
                    boolean completada = Boolean.parseBoolean(partes[3]);
                    Tarea tarea = new Tarea(nombre, fecha, prioridad);
                    tarea.setCompletada(completada);
                    tareasPersonales.add(tarea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar tareas: " + e.getMessage());
        }
    }
}
