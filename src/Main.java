import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Algorytm plecakowy ogólny");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile elementów ma tablica?");
        int size = scanner.nextInt();

        int[] valueArray = new int[size];
        int[] weightArray = new int[size];
        int[] numberUsedProducts = new int[size];

        System.out.println("Podaj kolejno elementy produkty. Najpierw wartość potem wagę");
        for(int i = 0; i < size; i++){
            valueArray[i] = scanner.nextInt();
            weightArray[i] = scanner.nextInt();
        }
        sortArray(valueArray, weightArray);

        //drukowanie tablic
        for(int i = 0; i < size; i++) System.out.print(valueArray[i] + ", ");
        System.out.println();
        for(int i = 0; i < size; i++) System.out.print(weightArray[i] + ", ");
        System.out.println();

        System.out.println("Podaj wage plecaka");
        int weight = scanner.nextInt();

        //pobiueramy wage plecaka
        int value = packBackpack(valueArray, weightArray, weight, numberUsedProducts);
        System.out.println("Wrtosc plecaka wunosi : " + value);
        //drukujemu tablice elementow wykorzystywanych do pakowania
        for(int i = 0; i < size; i++) System.out.print(numberUsedProducts[i] + ", ");
        System.out.println();
    }
    public static int packBackpack(int[] valueArray, int[] weightArray, int weight, int[] numberUsedProducts){

        int size = valueArray.length;
        int value = 0;
        for (int i = 0; i < size; i++){
            if(weightArray[i] <= weight){
                numberUsedProducts[i]++;
                weight -=weightArray[i];
                value += valueArray[i];

            }
//            numberUsedProducts[i] =  weight / weightArray[i];
//            weight -= numberUsedProducts[i] * weightArray[i];
//            value += numberUsedProducts[i] * valueArray[i];
        }
        return value;
    }

    public static void sortArray( int[] valueArray, int[] weightArray){
        int size = valueArray.length;
        int valueTemp;
        int weightTemp;
        for(int i = 0; i < size; i++){
            valueTemp = valueArray[i];
            weightTemp = weightArray[i];
            for(int j = i; j >=0; j--){
                if(((double) valueArray[j] / weightArray[j]) < ((double) valueTemp / weightTemp )){
                    valueArray[j+1] = valueArray[j];
                    weightArray[j+1] = weightArray[j];
                    valueArray[j] = valueTemp;
                    weightArray[j] = weightTemp;
                }
            }
        }
    }
}
