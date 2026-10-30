import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        dashboard.init();

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n===== DASHBOARD =====");
            System.out.println("1. Listar todos los widgets");
            System.out.println("2. Buscar widget por ID o nombre");
            System.out.println("3. Interactuar con un widget (índice o ID)");
            System.out.println("4. Ordenar widgets por memoria (KB)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    dashboard.listar();
                    break;
                case 2:
                    System.out.print("Ingrese ID o nombre: ");
                    dashboard.buscar(sc.nextLine().trim());
                    break;
                case 3:
                    System.out.print("Ingrese el índice o ID del widget: ");
                    dashboard.interactuar(sc.nextLine());
                    break;
                case 4:
                    dashboard.ordenarPorMemoria();
                    dashboard.listar();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}