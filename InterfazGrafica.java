package metodos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @autor: Jorge David Torrico Copali
 * @codigo sis: 202200286
 *         Clase que maneja la interfaz gráfica de usuario para la gestión de
 *         tareas.
 *         Proporciona funcionalidad para iniciar sesión, registrar usuarios, y
 *         gestionar tareas
 *         (agregar, modificar, eliminar, completar, e imprimir la lista de
 *         tareas).
 */

public class InterfazGrafica {

    private JFrame ventanaPrincipal;
    private JList<Tarea> listaTareas;
    private DefaultListModel<Tarea> modeloTareas;
    private ListaDeTareas tareasUsuario;
    private JTextField campoUsuario;
    private JTextField campoContraseña;

    private int anchoCampoLogin = 9;
    private int anchoCampoTarea = 9;

    /**
     * Constructor de la clase InterfazGrafica. Inicializa la ventana principal con
     * un formulario de inicio de sesión y los componentes necesarios.
     */

    public InterfazGrafica() {
        ventanaPrincipal = new JFrame("Lista De Tareas");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(400, 100);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.getContentPane().setBackground(new Color(240, 240, 240));

        modeloTareas = new DefaultListModel<>();
        listaTareas = new JList<>(modeloTareas);
        listaTareas.setBackground(new Color(255, 211, 151));
        listaTareas.setForeground(new Color(80, 80, 80));

        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(new Color(255, 150, 80));
        campoUsuario = new JTextField(anchoCampoLogin);
        campoContraseña = new JTextField(anchoCampoLogin);
        JButton btnIniciarSesion = new JButton("Iniciar Sesión");
        JButton btnRegistrar = new JButton("Registrar");

        btnIniciarSesion.setBackground(new Color(102, 200, 100));
        btnIniciarSesion.setForeground(Color.WHITE);
        btnRegistrar.setBackground(new Color(90, 160, 255));
        btnRegistrar.setForeground(Color.WHITE);

        panelLogin.add(new JLabel("Usuario:"));
        panelLogin.add(campoUsuario);
        panelLogin.add(new JLabel("Contraseña:"));
        panelLogin.add(campoContraseña);
        panelLogin.add(btnIniciarSesion);
        panelLogin.add(btnRegistrar);
        ventanaPrincipal.add(panelLogin);

        btnIniciarSesion.addActionListener(e -> iniciarSesion());
        btnRegistrar.addActionListener(e -> registrarUsuario());

        ventanaPrincipal.setVisible(true);
    }

    /**
     * Método que gestiona el inicio de sesión del usuario. Verifica las
     * credenciales
     * ingresadas y, si son válidas, carga la lista de tareas del usuario.
     */
    private void iniciarSesion() {
        String usuario = campoUsuario.getText();
        String contraseña = campoContraseña.getText();
        List<Usuario> usuarios = Usuario.cargarUsuarios();

        for (Usuario user : usuarios) {
            if (user.getNombre().equals(usuario) && user.getContraseña().equals(contraseña)) {
                tareasUsuario = user.getListaDeTareas();
                mostrarListaDeTareas();
                return;
            }
        }
        JOptionPane.showMessageDialog(ventanaPrincipal, "Usuario o contraseña incorrectos.");
    }

    /**
     * Registra un nuevo usuario con el nombre de usuario y contraseña ingresados.
     * Si el registro es exitoso, se muestra la lista de tareas vacía para el nuevo
     * usuario.
     */

    private void registrarUsuario() {
        String usuario = campoUsuario.getText();
        String contraseña = campoContraseña.getText();

        if (!usuario.isEmpty() && !contraseña.isEmpty()) {
            Usuario nuevoUsuario = new Usuario(usuario, contraseña);
            nuevoUsuario.guardarUsuarios();
            tareasUsuario = nuevoUsuario.getListaDeTareas();
            mostrarListaDeTareas();
        } else {
            JOptionPane.showMessageDialog(ventanaPrincipal, "Por favor ingrese usuario y contraseña.");
        }
    }

    /**
     * Muestra la interfaz de la lista de tareas, donde el usuario puede gestionar
     * sus tareas (añadir, modificar, eliminar, completar e imprimir).
     */

    private void mostrarListaDeTareas() {
        ventanaPrincipal.getContentPane().removeAll();
        ventanaPrincipal.setSize(650, 450);
        JButton btnAñadir = new JButton("AÑADIR TAREA");
        JButton btnFinalizar = new JButton("FINALIZAR");
        JButton btnCompletar = new JButton("COMPLETAR TAREA");
        JButton btnEliminar = new JButton("ELIMINAR TAREA");
        JButton btnModificar = new JButton("MODIFICAR TAREA");
        JButton btnImprimir = new JButton("IMPRIMIR LISTA");

        btnAñadir.setBackground(new Color(110, 220, 80));
        btnAñadir.setForeground(Color.WHITE);
        btnCompletar.setBackground(new Color(110, 220, 80));
        btnCompletar.setForeground(Color.WHITE);
        btnEliminar.setBackground(new Color(240, 200, 140));
        btnEliminar.setForeground(Color.WHITE);
        btnModificar.setBackground(new Color(240, 200, 140));
        btnModificar.setForeground(Color.WHITE);
        btnImprimir.setBackground(new Color(240, 200, 140));
        btnImprimir.setForeground(Color.WHITE);
        btnFinalizar.setBackground(new Color(255, 83, 84));
        btnFinalizar.setForeground(Color.WHITE);

        btnAñadir.addActionListener(e -> añadirTarea());
        btnCompletar.addActionListener(e -> completarTarea());
        btnEliminar.addActionListener(e -> eliminarTarea());
        btnModificar.addActionListener(e -> modificarTarea());
        btnImprimir.addActionListener(e -> imprimirLista());
        btnFinalizar.addActionListener(e -> finalizarPrograma());

        modeloTareas.clear();
        for (Tarea tarea : tareasUsuario.getTareas()) {
            modeloTareas.addElement(tarea);
        }

        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(255, 167, 53));
        panelSuperior.add(btnAñadir);
        panelSuperior.add(btnFinalizar);

        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.add(new JScrollPane(listaTareas), BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(255, 167, 53));
        panelInferior.add(btnCompletar);
        panelInferior.add(btnEliminar);
        panelInferior.add(btnModificar);
        panelInferior.add(btnImprimir);

        ventanaPrincipal.add(panelSuperior, BorderLayout.NORTH);
        ventanaPrincipal.add(panelCentral, BorderLayout.CENTER);
        ventanaPrincipal.add(panelInferior, BorderLayout.SOUTH);

        ventanaPrincipal.revalidate();
        ventanaPrincipal.repaint();
    }

    /**
     * Añade una nueva tarea a la lista. Muestra un formulario para ingresar los
     * detalles de la tarea, como el nombre, fecha límite y prioridad.
     */
    private void añadirTarea() {
        JTextField campoNombre = new JTextField(6);
        JTextField campoFecha = new JTextField(6);
        String[] prioridades = { "ALTA", "MEDIA", "BAJA" };
        JComboBox<String> comboPrioridad = new JComboBox<>(prioridades);

        JPanel panel = new JPanel();
        panel.add(new JLabel("NOMBRE DE TAREA:"));
        panel.add(campoNombre);
        panel.add(new JLabel("FECHA LIMITE (AÑO-MES-DIA):"));
        panel.add(campoFecha);
        panel.add(new JLabel("PRIORIDAD:"));
        panel.add(comboPrioridad);

        int option = JOptionPane.showConfirmDialog(ventanaPrincipal, panel, "AÑADIR TAREA",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nombre = campoNombre.getText();
            String fechaString = campoFecha.getText();
            String prioridad = (String) comboPrioridad.getSelectedItem();
            try {
                Tarea tarea = new Tarea(nombre, LocalDate.parse(fechaString), prioridad);
                tareasUsuario.agregarTarea(tarea);
                modeloTareas.addElement(tarea);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(ventanaPrincipal, "ERROR AL AÑADIR TAREA: " + e.getMessage());
            }
        }
    }

    /**
     * Marca la tarea seleccionada como completada y actualiza la lista de tareas.
     */
    private void completarTarea() {
        Tarea tareaSeleccionada = listaTareas.getSelectedValue();
        if (tareaSeleccionada != null) {
            tareaSeleccionada.setCompletada(true);
            modeloTareas.removeElement(tareaSeleccionada);
            modeloTareas.addElement(tareaSeleccionada);
            tareasUsuario.guardarTareas();
        } else {
            JOptionPane.showMessageDialog(ventanaPrincipal, "POR FAVOR SELECCIONE UNA TAREA PARA COMPLETAR.");
        }
    }

    /**
     * Elimina la tarea seleccionada de la lista de tareas.
     */
    private void eliminarTarea() {
        Tarea tareaSeleccionada = listaTareas.getSelectedValue();
        if (tareaSeleccionada != null) {
            tareasUsuario.eliminarTarea(tareaSeleccionada);
            modeloTareas.removeElement(tareaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(ventanaPrincipal, "POR FAVOR SELECCIONE UNA TAREA PARA ELIMINAR");
        }
    }

    /**
     * Modifica los detalles de la tarea seleccionada. Muestra un formulario para
     * cambiar
     * el nombre, fecha límite y prioridad de la tarea.
     */

    private void modificarTarea() {
        Tarea tareaSeleccionada = listaTareas.getSelectedValue();
        if (tareaSeleccionada != null) {
            JTextField campoNombre = new JTextField(anchoCampoTarea);
            campoNombre.setText(tareaSeleccionada.getNombre());
            JTextField campoFecha = new JTextField(anchoCampoTarea);
            campoFecha.setText(tareaSeleccionada.getFecha().toString());
            String[] prioridades = { "ALTA", "MEDIA", "BAJA" };
            JComboBox<String> comboPrioridad = new JComboBox<>(prioridades);
            comboPrioridad.setSelectedItem(tareaSeleccionada.getPrioridad());

            JPanel panel = new JPanel();
            panel.add(new JLabel("NUEVO NOMBRE:"));
            panel.add(campoNombre);
            panel.add(new JLabel("NUEVA FECHA (AÑO-MES-DIA):"));
            panel.add(campoFecha);
            panel.add(new JLabel("NUEVA PRIORIDAD:"));
            panel.add(comboPrioridad);

            int option = JOptionPane.showConfirmDialog(ventanaPrincipal, panel, "MODIFICAR TAREA",
                    JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String nuevoNombre = campoNombre.getText();
                String nuevaFechaString = campoFecha.getText();
                String nuevaPrioridad = (String) comboPrioridad.getSelectedItem();
                try {
                    tareaSeleccionada.setNombre(nuevoNombre);
                    tareaSeleccionada.setFecha(LocalDate.parse(nuevaFechaString));
                    tareaSeleccionada.setPrioridad(nuevaPrioridad);
                    tareasUsuario.guardarTareas();
                    modeloTareas.set(listaTareas.getSelectedIndex(), tareaSeleccionada);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(ventanaPrincipal, "ERROR AL MODIFICAR LA TAREA: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(ventanaPrincipal, "Por favor seleccione una tarea para modificar.");
        }
    }

    /**
     * Imprime la lista de tareas en un archivo de texto "lista_de_tareas.txt".
     */
    private void imprimirLista() {
        String destinoTXT = "LISTA DE TAREAS.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destinoTXT))) {
            writer.write("LISTA DE TAREAS:");
            writer.newLine();
            for (Tarea tarea : tareasUsuario.getTareas()) {
                writer.write(tarea.toString());
                writer.newLine();
            }
            JOptionPane.showMessageDialog(ventanaPrincipal, "La lista de tareas ha sido exportada a " + destinoTXT);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(ventanaPrincipal, "Error al generar el archivo de texto: " + e.getMessage());
        }
    }

    /**
     * Cierra la aplicación y guarda las tareas del usuario.
     */
    private void finalizarPrograma() {
        ventanaPrincipal.dispose();
        System.exit(0);
    }
}
