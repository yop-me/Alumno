import java.util.Scanner;

public class Alumno {
    private String nombre;
    private int[] calificaciones;

    public Alumno(String nombre, int[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public double calcularPromedio() {
        int sum = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            sum += calificaciones[i];
        }
        return (double) sum / calificaciones.length;
    }

    public char obtenerCalificacionFinal(double promedio) {
        char calificacion;
        if (promedio <= 50) { // Si el promedio es menor o igual que 50, automaticamente se promediara como F
            calificacion = 'F';
        } else if (promedio <= 60) { // si la calificacion es menor o igual que 60, entonces sube a E
            calificacion = 'E';
        } else if (promedio <= 70) { // pasa lo mismo con D, C y B
            calificacion = 'D';
        } else if (promedio <= 80) {
            calificacion = 'C';
        } else if (promedio <= 90) {
            calificacion = 'B';
        } else {
            calificacion = 'A'; // Para este punto ya se especifico en el metodo lo que pasara con los numeros
        }                       // ingresados <=50 = F,<=60 = E, <=70 = D, <=80 = C, <=90 = B, y si por ejemplo
        return calificacion; // el numero oscila en un rango distinto a los dichos, que es 91 a 100, se califica como A.
    }

    public void resultados() { //en este metodo se encuentra el formato en el que se mostraran los datos ingresados
        System.out.println("Nombre del estudiante: " + nombre); // del alumno, con su promedio final
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificacion " + (i + 1) + ": " + calificaciones[i]);
        }
        double promedio = calcularPromedio();
        char calificacionFinal = obtenerCalificacionFinal(promedio);
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificacion: " + calificacionFinal);
    }

    public static void main(String[] args) {  //inicio del metodo principal
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: "); //aqui se pide que el usuario ingrese el nombre
        String nombre = scanner.nextLine();                     // del alumno a promediar

        int[] calificaciones = new int[5];
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.print("Ingrese la calificacion " + (i + 1) + ": "); // aqui se ingresan las calificaciones
            calificaciones[i] = scanner.nextInt();
        }

        Alumno alumno = new Alumno(nombre, calificaciones);
        alumno.resultados(); //aqui se muestran los resultados

        scanner.close(); //se le da cierre al objeto Scanner
    }
}
