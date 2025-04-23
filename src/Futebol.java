package src;

import java.util.Scanner;

public class Futebol {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // leitura do número de jogadores
        int n = leitor.nextInt();
        int[] skills = new int[n];

        // leitura das skills
        for (int i = 0; i < n; i++) {
            skills[i] = leitor.nextInt();
        }
        leitor.close();

        // cálculo do maior time possível
        int maxTeamSize = maiorTimePossivel(skills);

        System.out.println("O tamanho maximo do time: " + maxTeamSize);
        System.out.println("A complexidade de tempo total do algoritmo = O(n^2), sendo O(n) para a para a verificao do tamanho do time e O(n^2) para a ordenacao");
    }


    private static int maiorTimePossivel(int[] skills) {
        // ordena o vetor de skills
        ordenar(skills);

        int maxTamanho = 0;
        int inicio = 0;

        // percorre o vetor de skills
        for (int fim = 0; fim < skills.length; fim++){

            // enquanto a diferença entre o maior e o menor skill for maior que 5, incrementa o início
            while (skills[fim] - skills[inicio] > 5){
                inicio++;
            }

            // calcula o tamanho atual do time
            int tamanhoAtual = fim - inicio + 1;

            // atualiza o tamanho máximo do time
            if (tamanhoAtual > maxTamanho){
                maxTamanho = tamanhoAtual;
            }
        }
        return maxTamanho;
    }


    private static void ordenar(int[] vetor) {

        int n = vetor.length;

        // Ordenação Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }
}