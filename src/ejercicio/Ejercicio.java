package ejercicio;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Cantidad de conductores");
        int cantConductores = leer.nextInt();
        System.out.println("-----------------------------------------");
        System.out.println("Llenar Conductores");
        String[] nombres = new String[cantConductores];
        LlenarNombres(nombres);
        MostrarNombres(nombres);
        System.out.println("-----------------------------------------");
        System.out.println("LLenando Kilometraje de cada conductor");
        int kms[][] = new int[7][cantConductores];
        LlenarM(kms, 7, cantConductores);
        MostrarM(kms, 7, cantConductores);
        System.out.println("-----------------------------------------");
        int[] total_kms = new int[cantConductores];
        System.out.println("Total Kilometraje");
        kilometroTotalesConductor(kms, 7, cantConductores, total_kms);
        System.out.println("-----------------------------------------");
        System.out.println("Total Kilometraje de cada conductor");
        kilometroTotalesConductorNombres(total_kms, nombres);
        System.out.println("-----------------------------------------");
        mayorKilometraje(total_kms, nombres);
    }

    public static void MostrarM(int[][] v, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("[" + v[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void MostrarVector(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("[" + v[i] + "]");
        }
        System.out.println();
    }

    public static void MostrarNombres(String[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("[" + v[i] + "]");
        }
        System.out.println();
    }

    public static void LlenarM(int[][] A, int m, int n) {
        Random rand = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = rand.nextInt(51);
            }
        }
    }

    public static void LlenarNombres(String[] A) {
        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < A.length; i++) {
            A[i] = leer.next();
        }
    }

    public static void kilometroTotalesConductor(int kms[][], int m, int n, int[] total_kms) {
        int cont = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                total_kms[cont] = total_kms[cont] + kms[j][i];
            }
            cont++;
        }
        MostrarVector(total_kms);
    }

    public static void mayorKilometraje(int[] total_kms, String[] nombre) {
        int may = -999;
        int indice = 0;
        for (int j = 0; j < total_kms.length; j++) {
            if (total_kms[j] > may) {
                may = total_kms[j];
                indice = j;
            }
        }
        System.out.println("El conductor con mas kilometros recorrio es : " + nombre[indice] + "  con  " + may);
    }

    public static void kilometroTotalesConductorNombres(int[] total_kms, String nombre[]) {
        for (int i = 0; i < total_kms.length; i++) {
            System.out.println("Nombre: " + nombre[i] + "   Total Kilometros: " + total_kms[i]);
        }
    }
}
