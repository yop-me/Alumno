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
        if (promedio <= 50) {
            calificacion = 'F';
        } else if (promedio <= 60) {
            calificacion = 'E';
        } else if (promedio <= 70) {
            calificacion = 'D';
        } else if (promedio <= 80) {
            calificacion = 'C';
        } else if (promedio <= 90) {
            calificacion = 'B';
        } else {
            calificacion = 'A';
        }
        return calificacion;
    }

    public void resultados() {
        System.out.println("Nombre del estudiante: " + nombre);
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificacion " + (i + 1) + ": " + calificaciones[i]);
        }
        double promedio = calcularPromedio();
        char calificacionFinal = obtenerCalificacionFinal(promedio);
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificacion: " + calificacionFinal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        int[] calificaciones = new int[5];
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.print("Ingrese la calificacion " + (i + 1) + ": ");
            calificaciones[i] = scanner.nextInt();
        }

        Alumno alumno = new Alumno(nombre, calificaciones);
        alumno.resultados();

        scanner.close();
    }
}
