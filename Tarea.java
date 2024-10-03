package Documentacion;

import java.time.LocalDate;

/**
@autor: Jorge David Torrico Copali 
@codigo sis: 202200286
 * Clase que representa una tarea con un nombre, fecha, prioridad y estado de completada.
 */
public class Tarea {

    private String nombreTarea;
    private LocalDate fechaTarea;
    private String prioridadTarea;
    private boolean estadoCompletada;

    /**
     * Constructor de la clase Tarea.
     * 
     * @param nombre Nombre de la tarea.
     * @param fecha Fecha de la tarea.
     * @param prioridad Prioridad de la tarea (alta, media, baja).
     */
    public Tarea(String nombre, LocalDate fecha, String prioridad) {
        this.nombreTarea = nombre;
        this.fechaTarea = fecha;
        this.prioridadTarea = prioridad;
        this.estadoCompletada = false;
    }

    /**
     * Obtiene el nombre de la tarea.
     * 
     * @return Nombre de la tarea.
     */
    public String getNombre() {
        return nombreTarea;
    }

    /**
     * Establece el nombre de la tarea.
     * 
     * @param nombre Nuevo nombre de la tarea.
     */
    public void setNombre(String nombre) {
        this.nombreTarea = nombre;
    }

    /**
     * Obtiene la fecha de la tarea.
     * 
     * @return Fecha de la tarea.
     */
    public LocalDate getFecha() {
        return fechaTarea;
    }

    /**
     * Establece la fecha de la tarea.
     * 
     * @param fecha Nueva fecha de la tarea.
     */
    public void setFecha(LocalDate fecha) {
        this.fechaTarea = fecha;
    }

    /**
     * Obtiene la prioridad de la tarea.
     * 
     * @return Prioridad de la tarea.
     */
    public String getPrioridad() {
        return prioridadTarea;
    }

    /**
     * Establece la prioridad de la tarea.
     * 
     * @param prioridad Nueva prioridad de la tarea.
     */
    public void setPrioridad(String prioridad) {
        this.prioridadTarea = prioridad;
    }

    /**
     * Verifica si la tarea está completada.
     * 
     * @return {@code true} si la tarea está completada, de lo contrario {@code false}.
     */
    public boolean isCompletada() {
        return estadoCompletada;
    }

    /**
     * Establece el estado de completada de la tarea.
     * 
     * @param completada Nuevo estado de la tarea.
     */
    public void setCompletada(boolean completada) {
        this.estadoCompletada = completada;
    }

    /**
     * Retorna una representación en cadena de la tarea.
     * 
     * @return Representación de la tarea como cadena.
     */
    @Override
    public String toString() {
        return "          # " + nombreTarea + "  " + "   [ FECHA: " + fechaTarea + " ]   " + "   [ PRIORIDAD "
                + prioridadTarea + "]   " + "   [ TAREA" + (estadoCompletada ? " COMPLETADA" : " NO COMPLETADA")
                + "]   ";
    }
}
