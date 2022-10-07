package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena,
            String nombre, String apellidos, String email, String direccion, int telefono, double saldo, boolean premium);

    public String pedir(String username);

    public String modificar(String username, String nuevaContrasena,
            String nuevoNombre, String nuevosApellidos, String nuevoEmail,String nuevoDireccion, int nuevoTelefono, 
            double nuevoSaldo, boolean nuevoPremium);

    public String verCopias(String username);

    public String devolverPeliculas(String username, Map<Integer, Integer> copias);

    public String eliminar(String username);

}
