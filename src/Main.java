import javax.swing.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Set<String> porteros;
    private static Set<String> defensa;
    private static Set<String> medios;
    private static Set<String> delanteros;

    public static void main(String[] args) {
        porteros = new HashSet<>();
        medios = new HashSet<>();
        defensa = new HashSet<>();
        delanteros = new HashSet<>();

        JOptionPane.showMessageDialog(null, "Vamos a añadir todos los jugadores disponibles en el mercado de invierno");
        solicitarJugadores();
    }

    public static void solicitarJugadores(){
        int seguir;
        do {
            boolean w = false;
            do {
                try {
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador");
                    Pattern p = Pattern.compile("^[A-Z][a-z]{1,}$");
                    Matcher m = p.matcher(nombre);
                    if (!m.matches()) {
                        throw new Exception("El nombre es incorrecto, debe de estar escrito la primera mayuscula y sin espacios");
                    }
                    String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del jugador ");
                    Matcher mat = p.matcher(apellido);
                    if (!mat.matches()) {
                        throw new Exception("El apellido es incorrecto, debe de estar escrito la primera mayuscula y sin espacios");
                    }
                    String nombreCompleto = nombre + " " + apellido;
                    w = true;
                    solicitarRol(nombreCompleto);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            } while (!w);
            seguir = JOptionPane.showConfirmDialog(null ,"Quieres continuar añadiendo jugadores?", "Continuar", JOptionPane.YES_NO_OPTION);
        }  while (seguir == JOptionPane.YES_OPTION);
    }

    public static void solicitarRol(String nombreCompleto){
        String opcion = JOptionPane.showInputDialog(null, "Ingrese el rol del jugador: " +nombreCompleto+"\n" +
                "a) Portero\n" +
                "b) Defensa\n" +
                "c) Medio\n" +
                "d) Delantero\n" +
                "(Debes de introducir la letra en minuscula)"
        );

        switch(opcion){
            case "a" :
                porteros.add(nombreCompleto);
                break;
            case "b" :
                defensa.add(nombreCompleto);
                break;
            case "c" :
                medios.add(nombreCompleto);
                break;
            case "d" :
                delanteros.add(nombreCompleto);
                break;
            default:
                JOptionPane.showMessageDialog(null, "La opcion es incorrecto");
                break;

        }

    }
    public static void solicitarMenu(){
        String opcion;
        do {
            opcion=JOptionPane.showInputDialog(null, "I----MENU----\n" +
                    "a) Dar de alta jugador\n" +
                    "b) Dar de baja jugador\n" +
                    "c) Modificar jugador\n" +
                    "e) Salir\n" +
                    "(La respuesta debe de ser la letra en minuscula)");

        }while (opcion.equals("e"));
    }
}