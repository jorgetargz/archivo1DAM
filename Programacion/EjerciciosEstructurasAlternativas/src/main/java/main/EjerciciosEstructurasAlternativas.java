package main;

import java.util.Scanner;

public class EjerciciosEstructurasAlternativas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejercicios estructuras alternativas: ");
        System.out.println("1.(Ejercicio 9). Algoritmo que pida tres números y los muestre ordenados (de mayor a menor);");
        System.out.println("2.(Ejercicio 13). Escribe un programa que pida una fecha (día, mes y año) y diga si es correcta.");
        System.out.println("3.(Ejercicio 14). La asociación de vinicultores");
        System.out.println("4.(Ejercicio 15). El director de una escuela está organizando un viaje de estudios");
        System.out.println("5.(Ejercicio 16). La política de cobro de una compañía telefónica");
        System.out.println("6.(Ejercicio 17). Lanzar un dado de seis caras y muestre por pantalla el número en letras");
        System.out.println("7.(Ejercicio 18). Realiza un programa que pida el día de la semana y escriba el día correspondiente");
        System.out.println("8.(Ejercicio 19). Escribe un programa que pida un número entero entre uno y doce");
        System.out.println("9.(Ejercicio 20). Una compañía de transporte internacional ");
        System.out.print("Introduce el numero de programa a ejecutar: ");
        int menu1 = sc.nextInt();
        switch (menu1) {
            case 1:
                System.out.print("Indica el primer número: ");
                double n1 = sc.nextDouble();
                System.out.print("Indica el segundo número: ");
                double n2 = sc.nextDouble();
                System.out.print("Indica el tercer número: ");
                double n3 = sc.nextDouble();
                if (n1 == n2 && n1 == n3) {
                    System.out.println("Los números" + n1 + ", " + n2 + " y " + n3 + "son iguales");
                } else if (n1 >= n2 && n1 >= n3) {
                    if (n1 == n2) {
                        System.out.println(n1 + " y " + n2 + " son los mayores");
                        System.out.println(n3 + " es el tercero ");
                    } else if (n1 == n3) {
                        System.out.println(n1 + " y " + n3 + " son los mayores");
                        System.out.println(n2 + " es el tercero");
                    } else if (n2 == n3) {
                        System.out.println(n1 + " es el mayor");
                        System.out.println("Los números" + n2 + " y " + n3 + "son iguales");
                    } else if (n2 > n3) {
                        System.out.println(n2 + " es el segundo");
                        System.out.println(n3 + " es el tercero ");
                    } else {
                        System.out.println(n3 + " es el segundo ");
                        System.out.println(n2 + " es el tercero");
                    }
                } else if (n2 >= n1 && n2 >= n3) {
                    if (n2 == n3) {
                        System.out.println(n2 + " y " + n3 + " son los mayores");
                        System.out.println(n1 + " es el tercero");
                    } else if (n1 == n3) {
                        System.out.println(n2 + " es el mayor");
                        System.out.println("Los números" + n1 + "y" + n3 + "son iguales");
                    } else if (n1 > n3) {
                        System.out.println(n1 + " es el segundo");
                        System.out.println(n3 + " es el tercero");
                    } else {
                        System.out.println(n3 + " es el segundo");
                        System.out.println(n1 + " es el tercero");
                    }
                } else {
                    if (n1 == n2) {
                        System.out.println(n3 + " es el mayor");
                        System.out.println("Los números" + n1 + "y" + n2 + "son iguales");
                    } else if (n1 > n2) {
                        System.out.println(n1 + " es el segundo");
                        System.out.println(n2 + " es el tercero");
                    } else {
                        System.out.println(n2 + " es el segundo");
                        System.out.println(n1 + " es el tercero");
                    }
                }
                break;
            case 2:
                System.out.print("Introduce el dia: ");
                int dia = sc.nextInt();
                System.out.print("Introduce el mes: ");
                int mes = sc.nextInt();
                System.out.print("Introduce el año: ");
                int year = sc.nextInt();
                if (year > 0 && year < 3000) {
                    if (mes > 0 && mes <= 12) {
                        switch (mes) {
                            case 2:
                                if (dia > 0 && dia <= 29) {
                                    System.out.println("La fecha es correcta: " + dia + "/" + mes + "/" + year);
                                } else {
                                    System.out.println("El dia " + dia + " no es valido");
                                }
                                break;
                            case 4:
                            case 11:
                            case 9:
                            case 6:
                                if (dia > 0 && dia <= 30) {
                                    System.out.println("La fecha es correcta: " + dia + "/" + mes + "/" + year);
                                } else {
                                    System.out.println("El dia " + dia + " no es valido");
                                }
                                break;
                            default:
                                if (dia > 0 && dia <= 31) {
                                    System.out.println("La fecha es correcta: " + dia + "/" + mes + "/" + year);
                                } else {
                                    System.out.println("El dia " + dia + " no es valido");
                                }
                                break;
                        }
                    } else {
                        System.out.println("El mes " + mes + " no es valido");
                        break;
                    }
                } else {
                    System.out.println("El año " + year + " no es valido");
                    break;
                }
                break;
            case 3:
                System.out.print("Introduce el numero de kilos: ");
                double kilos = sc.nextDouble();
                sc.nextLine();
                System.out.print("¿De que tipo son los uvas? (A o B)");
                String tipo = sc.nextLine();
                System.out.print("¿De que tamaño son las uvas? (1 o 2)");
                int tamanioUva = sc.nextInt();
                double pagar = 0;
                if (tipo.equalsIgnoreCase("A") || tipo.equalsIgnoreCase("B")) {
                    if (tamanioUva == 1 || tamanioUva == 2) {
                        if (tipo.equalsIgnoreCase("A") && tamanioUva == 1) {
                            pagar = pagar + (kilos * 0.2);
                        } else if (tipo.equalsIgnoreCase("A") && tamanioUva == 2) {
                            pagar = pagar + (kilos * 0.3);
                        } else if (tipo.equalsIgnoreCase("B") && tamanioUva == 1) {
                            pagar = pagar + (kilos * -0.3);
                        } else if (tipo.equalsIgnoreCase("B") && tamanioUva == 2) {
                            pagar = pagar + (kilos * -0.5);
                        }
                    } else {
                        System.out.println("El tamaño de uva introducido no es valido");
                    }
                } else {
                    System.out.println("El tipo de uva introducido no es valido");
                }
                System.out.println("La ganancia es " + pagar + "€");
                break;
            case 4:
                System.out.print("Introduce el numero de alumnos: ");
                int alumnos = sc.nextInt();
                int costeBusTotal;
                int costeAlumnos;
                if (alumnos >= 100) {
                    costeAlumnos = 65;
                    costeBusTotal = alumnos * costeAlumnos;
                    System.out.println("El coste total es " + costeBusTotal + "€");
                    System.out.println("Cada alumno debe abonar " + costeAlumnos + "€");
                } else if (alumnos >= 50) {
                    costeAlumnos = 70;
                    costeBusTotal = alumnos * costeAlumnos;
                    System.out.println("El coste total es " + costeBusTotal + "€");
                    System.out.println("Cada alumno debe abonar " + costeAlumnos + "€");
                } else if (alumnos >= 30) {
                    costeAlumnos = 95;
                    costeBusTotal = alumnos * costeAlumnos;
                    System.out.println("El coste total es " + costeBusTotal + "€");
                    System.out.println("Cada alumno debe abonar " + costeAlumnos + "€");
                } else if (alumnos >= 1) {
                    costeBusTotal = 4000;
                    costeAlumnos = costeBusTotal / alumnos;
                    System.out.println("El coste total es " + costeBusTotal + "€");
                    System.out.println("Cada alumno debe abonar " + costeAlumnos + "€");
                } else {
                    System.out.println("El numero de alumnos ha de ser un entero mayor o igual a 1");
                }
                break;
            case 5:
                System.out.print("¿Es domingo? (S/N)");
                String esDomingo = sc.nextLine();
                System.out.print("¿Es por la mañana o por la tarde? (M/T)");
                String horario = sc.nextLine();
                System.out.print("Duración de la llamada: ");
                int minutos = sc.nextInt();
                double precioLlamada;
                if (minutos <= 5) {
                    precioLlamada = minutos;
                } else if (minutos <= 8) {
                    precioLlamada = ((minutos - 5) * 0.8) + 5;
                } else if (minutos <= 10) {
                    precioLlamada = ((minutos - 8) * 0.7) + 5 + 2.4;
                } else {
                    precioLlamada = ((minutos - 10) * 0.5) + 5 + 2.4 + 1.4;
                }
                if (esDomingo.equalsIgnoreCase("S")) {
                    precioLlamada = precioLlamada * 1.03;
                } else if (horario.equalsIgnoreCase("M")) {
                    precioLlamada = precioLlamada * 1.15;
                } else if (horario.equalsIgnoreCase("T")) {
                    precioLlamada = precioLlamada * 1.1;
                } else {
                    System.out.println("Por favor responda a las preguntas con los caracteres entre paréntesis");
                }
                System.out.println("El precio de la llamada es de " + precioLlamada + "€");
                break;
            case 6:
                System.out.print("Indica el resultado del dado: ");
                int dado = sc.nextInt();
                switch (dado) {
                    case 1:
                        System.out.println("La cara opuesta es 6");
                        break;
                    case 2:
                        System.out.println("La cara opuesta es 5");
                        break;
                    case 3:
                        System.out.println("La cara opuesta es 4");
                        break;
                    case 4:
                        System.out.println("La cara opuesta es 3");
                        break;
                    case 5:
                        System.out.println("La cara opuesta es 2");
                        break;
                    case 6:
                        System.out.println("La cara opuesta es 1");
                        break;
                    default:
                        System.out.println("ERROR: número incorrecto.");
                        break;
                }
                break;
            case 7:
                System.out.print("Introduce el numero de dia de la semana (1-7): ");
                int diaSemana = sc.nextInt();
                switch (diaSemana) {
                    case 1:
                        System.out.println("Lunes");
                        break;
                    case 2:
                        System.out.println("Martes");
                        break;
                    case 3:
                        System.out.println("Miércoles");
                        break;
                    case 4:
                        System.out.println("Jueves");
                        break;
                    case 5:
                        System.out.println("Viernes");
                        break;
                    case 6:
                        System.out.println("Sábado");
                        break;
                    case 7:
                        System.out.println("Domingo");
                        break;
                    default:
                        System.out.println("El dia introducido no es valido");
                        break;
                }
                break;
            case 8:
                System.out.print("Introduce un número de mes (1-12): ");
                int numeroMes = sc.nextInt();
                switch (numeroMes) {
                    case 2:
                        System.out.println("El mes de febrero tiene 28 o 29 dias si es bisiesto");
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        System.out.println("El mes tiene 30 dias");
                        break;
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        System.out.println("El mes tiene 31 dias");
                        break;
                    default:
                        System.out.println("El numero introducido no es un mes valido");
                        break;
                }
                break;
            case 9:
                System.out.print("Introduce el peso del paquete (g): ");
                double pesoPaquete = sc.nextDouble();
                if (pesoPaquete >= 5000) {
                    System.out.println("El peso introducido excede el maximo de 5kg");
                    break;
                }
                double precioPaquete = 0;
                System.out.println("1. America del norte");
                System.out.println("2. America central");
                System.out.println("3. America del sur");
                System.out.println("4. Europa");
                System.out.println("5. Asia");
                System.out.print("Introduce el destino del paquete (1-5): ");
                int zonaDestino = sc.nextInt();
                switch (zonaDestino) {
                    case 1:
                        precioPaquete = pesoPaquete * 24;
                        break;
                    case 2:
                        precioPaquete = pesoPaquete * 20;
                        break;
                    case 3:
                        precioPaquete = pesoPaquete * 21;
                        break;
                    case 4:
                        precioPaquete = pesoPaquete * 10;
                        break;
                    case 5:
                        precioPaquete = pesoPaquete * 18;
                        break;
                    default:
                        System.out.println("La zona introducida no es valida");
                        break;
                }
                System.out.println("El precio del envío es " + precioPaquete + "€");
                break;
        }
    }
}