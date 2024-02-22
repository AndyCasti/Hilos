import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;

public class ChatServicioCliente {
    public static void main(String[] args) {
        // Crear un hilo para la reproducción de la canción
        Thread songThread = new Thread(() -> {
            try {
                // Obtener un clip de sonido
                Clip clip = AudioSystem.getClip();

                // Obtener una fuente de audio desde un archivo
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        new File("C:\\Users\\felip\\Downloads\\AplicacionesMoviles\\actividad hilos\\recursos\\cancion2.wav")
                );

                // Abrir el clip con la fuente de audio
                clip.open(inputStream);

                // Reproducir el clip
                clip.start();

                // Esperar hasta que el clip termine de reproducirse
                while (clip.isRunning()) {
                    Thread.sleep(1000); // Esperar 1 segundo
                }

                // Cerrar el clip cuando haya terminado de reproducirse
                clip.close();
            } catch (Exception e) {
                System.out.println("Error al reproducir la canción:");
                e.printStackTrace();
            }
        });

        // Crear un hilo para el chat de servicio al cliente
        Thread chatThread = new Thread(() -> {
            // Aquí va el código del chat de servicio al cliente
            Scanner scanner = new Scanner(System.in);
            // Solicitar el nombre del usuario
            System.out.println("¡Bienvenido al chat de servicio al cliente!");
            System.out.print("Por favor, proporcione su nombre: ");
            String nombre = scanner.nextLine();

            // Mostrar mensaje de bienvenida personalizado
            System.out.println("Hola, " + nombre + "! ¿En qué puedo ayudarte hoy?");
            System.out.println("1. Consulta de productos");
            System.out.println("2. Información de envío");
            System.out.println("3. Soporte técnico");
            System.out.println("4. Otro");
            System.out.print("Por favor, seleccione una opción (1-4): ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            // Realizar acciones basadas en la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.println("Entiendo que estás interesado en nuestros productos.");
                    System.out.println("¿Puedes proporcionarme más detalles sobre lo que estás buscando?");
                    break;
                case 2:
                    System.out.println("¿Tienes algún número de seguimiento o referencia de envío?");
                    break;
                case 3:
                    System.out.println("Por favor, describe el problema técnico que estás experimentando.");
                    break;
                default:
                    System.out.println("¿En qué puedo ayudarte hoy?");
                    break;
            }

            // Leer la consulta adicional del usuario
            String consulta;
            do {
                System.out.print(nombre + ": ");
                consulta = scanner.nextLine();
                // Simular una respuesta detallada del representante del servicio al cliente
                System.out.println("Representante: Gracias por tu pregunta. Estoy revisando tu consulta.");
                System.out.println("Por favor, espere mientras busco una solución.");
                System.out.println("Si necesitas ayuda adicional, no dudes en preguntar.");
            } while (!consulta.equalsIgnoreCase("salir"));

            // Cerrar el Scanner
            scanner.close();

            // Mostrar mensaje de despedida
            System.out.println("Gracias por chatear con nosotros. ¡Que tengas un buen día!");
        });

        // Iniciar ambos hilos
        songThread.start();
        chatThread.start();
    }
}

