package usuarios;

import utilidades.EntradaUtils;


import java.util.List;
import java.util.Scanner;

import principal.SistemaTareas;
import tareas.Tarea;

public class Administrador extends Usuario 
{
	private SistemaTareas sistema;
    private Scanner scanner;
    
    public Administrador(String nombre, String email, String password, SistemaTareas sistema, Scanner scanner) 
    {
        super(nombre, email, "Administrador", password);
        this.sistema = sistema;
        this.scanner = scanner;
    }
    
    public Tarea crearTarea(String titulo, String descripcion, String fechaLimite) {
        return new Tarea(titulo, descripcion, fechaLimite);
    }
    
    public void asignarTarea(Tarea tarea, Empleado empleado) {
        tarea.setUsuarioAsignado(empleado);
        empleado.agregarTarea(tarea);
    }
    
    public void listarUsuarios(List<Usuario> usuarios) {
        listarUsuarios(usuarios, false);
    }
    
    public void listarUsuarios(List<Usuario> usuarios, boolean mostrarPasswords) {
        for (Usuario usuario : usuarios) {
            usuario.mostrarInfo(mostrarPasswords);
            System.out.println("-------------------");
        }
    }
    
    public void listarTareas(List<Tarea> tareas) {
        for (Tarea tarea : tareas) {
            tarea.mostrarDetalles();
            System.out.println("-------------------");
        }
    }
    
    public boolean mostrarMenu() 
    {
	    System.out.println("\n=== MENÚ ADMINISTRADOR ===");
	    System.out.println("1. Crear tarea");
	    System.out.println("2. Asignar tarea");
	    System.out.println("3. Listar tareas");
	    System.out.println("4. Eliminar tarea");
	    System.out.println("5. Listar empleados");
	    System.out.println("6. Agregar nuevo empleado");
	    System.out.println("7. Eliminar empleado");
	    System.out.println("8. Eliminar orden");
	    System.out.println("9. Ver mi información");
	    System.out.println("10. Cerrar sesión");
	    System.out.print("Seleccione opción: ");
	    
	    int opcion = EntradaUtils.leerEntero(scanner);
	    
	    switch (opcion) {
	        case 1:
	            crearTarea(admin);
	            System.out.println("\nPresione Enter para continuar...");
	            scanner.nextLine();
	            return false;
	        case 2:
	            asignarTarea(admin);
	            System.out.println("\nPresione Enter para continuar...");
	            scanner.nextLine();
	            return false;
	        case 3:
	            sistema.listarTareas();
	            System.out.println("\nPresione Enter para continuar...");
	            scanner.nextLine();
	            return false;
	        case 4:
	            eliminarTarea();
	            System.out.println("\nPresione Enter para continuar...");
	            scanner.nextLine();
	            return false;
	        case 5:
	            listarEmpleados();
	            System.out.println("\nPresione Enter para continuar...");
	            scanner.nextLine();
	            return false;
	        case 6:
	            agregarNuevoEmpleado();
	            System.out.println("\nPresione Enter para continuar...");
	            scanner.nextLine();
	            return false;
	        case 7:
	            eliminarEmpleadoAdministrador();
	            System.out.println("\nPresione Enter para continuar...");
	            scanner.nextLine();
	            return false;
	        case 8:
	            eliminarOrdenAdministrador(admin);
	            System.out.println("\nPresione Enter para continuar...");
	            scanner.nextLine();
	            return false;
	        case 9:
	            admin.mostrarInfo(false);
	            System.out.println("\nPresione Enter para continuar...");
	            scanner.nextLine();
	            return false;
	        case 10:
	            sistema.setUsuarioActual(null);
	            System.out.println("Sesión cerrada correctamente.");
	            return true;
	        default:
	            System.out.println("Opción inválida");
	            System.out.println("\nPresione Enter para continuar...");
	            scanner.nextLine();
	            return false;
	    }
	}
    
    private void eliminarEmpleadoAdministrador() 
    {
	    System.out.println("\n=== ELIMINAR EMPLEADO ===");
	    
	    // Listar solo empleados (no administradores)
	    List<Empleado> empleados = sistema.getEmpleados();
	    
	    if (empleados.isEmpty()) {
	        System.out.println("No hay empleados registrados.");
	        return;
	    }
	    
	    System.out.println("Lista de empleados:");
	    for (Empleado empleado : empleados) {
	        System.out.println("ID: " + empleado.getId() + 
	                         " | Nombre: " + empleado.getNombre() + 
	                         " | Rol: " + empleado.getRol());
	    }
	    
	    System.out.print("\nID del empleado a eliminar (0 para cancelar): ");
	    int idEmpleado = EntradaUtils.leerEntero(scanner);
	    
	    if (idEmpleado == 0) {
	        System.out.println("Operación cancelada.");
	        return;
	    }
	    
	    // Verificar que sea un empleado (no administrador o sudo)
	    Usuario usuario = sistema.buscarUsuarioPorId(idEmpleado);
	    
	    if (usuario == null) {
	        System.out.println("Usuario no encontrado.");
	        return;
	    }
	    
	    // Verificar que no sea administrador o sudo
	    if (usuario instanceof Administrador || usuario instanceof Sudo) {
	        System.out.println("No tiene permisos para eliminar administradores.");
	        System.out.println("   Solo el Sudo puede eliminar administradores.");
	        return;
	    }
	    
	    if (!(usuario instanceof Empleado)) {
	        System.out.println("El usuario seleccionado no es un empleado.");
	        return;
	    }
	    
	    System.out.println("Empleado a eliminar:");
	    usuario.mostrarInfo(false);
	    
	    System.out.print("\n¿Está seguro de eliminar este empleado? (s/n): ");
	    String confirmacion = scanner.nextLine().toLowerCase();
	    
	    if (confirmacion.equals("s") || confirmacion.equals("si")) {
	        sistema.eliminarUsuario(idEmpleado);
	        System.out.println("Empleado eliminado exitosamente.");
	    } else {
	        System.out.println("Operación cancelada.");
	    }
	}
    
}
