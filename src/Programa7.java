import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> resultados = new ArrayList<>();

        System.out.println("Calculadora de Areas y Perimetros de Figuras Geometricas");
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\nSeleccione una Figura:");
                System.out.println("1. Círculo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Triángulo");
                System.out.println("4. Rectángulo");
                System.out.println("5. Pentágono");

                int figura = scanner.nextInt();

                System.out.println("\nOperaciones disponibles:");
                System.out.print("\nSeleccione una operación (1-3): ");
                System.out.println("1. Área");
                System.out.println("2. Perímetro");
                System.out.println("3. Potencia");
                int operacion = scanner.nextInt();

                double resultado = 0;

                if (operacion == 3) { // Cálculo de potencia
                    System.out.print("Ingrese la base: ");
                    double base = leerDouble(scanner);
                    System.out.print("Ingrese el exponente: ");
                    int exponente = leerEntero(scanner);
                    resultado = calcularPotencia(base, exponente); // Método recursivo
                    System.out.printf("\nLa potencia de %.2f elevado a %d es: %.2f\n", base, exponente, resultado);
                } else {
                    resultado = calcularFigura(figura, operacion, scanner);
                }

                // Almacenar el resultado
                resultados.add(resultado);

            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Intente nuevamente.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        }

        // Mostrar todos los resultados acumulados
        System.out.println("\nResultados acumulados:");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.printf("Operación %d: %.2f\n", i + 1, resultados.get(i));
        }
        scanner.close();
    }
    private static double calcularFigura(int figura, int operacion, Scanner scanner) {
        double resultado = 0;
        try {
            switch (figura) {
                case 1:
                    System.out.print("Ingrese el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    if (operacion == 1) {
                        resultado = Math.PI * radio * radio; // Área
                    } else if (operacion == 2) {
                        resultado = 2 * Math.PI * radio; // Perímetro
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double ladoCuadrado = scanner.nextDouble();
                    if (operacion == 1) {
                        resultado = ladoCuadrado * ladoCuadrado; // Área
                    } else if (operacion == 2) {
                        resultado = 4 * ladoCuadrado; // Perímetro
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la base del triángulo: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese la altura del triángulo: ");
                    double altura = scanner.nextDouble();
                    if (operacion == 1) {
                        resultado = (base * altura) / 2; // Área
                    } else if (operacion == 2) {
                        System.out.print("Ingrese los otros dos lados del triángulo (lado 1): ");
                        double lado1 = scanner.nextDouble();
                        System.out.print("Ingrese el lado 2 del triángulo: ");
                        double lado2 = scanner.nextDouble();
                        resultado = base + lado1 + lado2; // Perímetro
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el largo del rectángulo: ");
                    double largo = scanner.nextDouble();
                    System.out.print("Ingrese el ancho del rectángulo: ");
                    double ancho = scanner.nextDouble();
                    if (operacion == 1) {
                        resultado = largo * ancho; // Área
                    } else if (operacion == 2) {
                        resultado = 2 * (largo + ancho); // Perímetro
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el lado del pentágono: ");
                    double ladoPentagono = scanner.nextDouble();
                    if (operacion == 1) {
                        System.out.print("Ingrese el apotema del pentágono: ");
                        double apotema = scanner.nextDouble();
                        resultado = (5 * ladoPentagono * apotema) / 2; // Área
                    } else if (operacion == 2) {
                        resultado = 5 * ladoPentagono; // Perímetro
                    }
                    break;

                default:
                    System.out.println("Figura no válida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Intente nuevamente.");
            scanner.nextLine();
        }
        return resultado;
    }
    private static double calcularPotencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente < 0) {
            return 1 / calcularPotencia(base, -exponente);
        } else {
            return base * calcularPotencia(base, exponente - 1);
        }
    }
    private static int leerEntero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido. Intente nuevamente.");
                scanner.nextLine();
            }
        }
    }
    private static double leerDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número decimal válido. Intente nuevamente.");
                scanner.nextLine();
            }
        }
    }
}
