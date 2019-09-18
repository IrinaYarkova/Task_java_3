package com.company;
import java.util.Random;

/**
 * Программа предназначена для замены местами максимального отрицательного элемента по модулю на минимальный положительный.
 * Примечания:
 * Ноль относится к положительным числам,
 * Если несколько одинаковых максимальных или минимальных элесентов, то заменяются все
 * @author Yarkova I. A.
 */
public class Main {
    public static final int size = 20; //размер массива

    public static void main(String[] args) {
        int new_arr[] = new int[size];
        int arr[] = NewArray();
        System.out.println("Сгенерированный массив:");
        PrintArray(arr);
        int min = SearchMin(arr);
        int max = SearchMax(arr);
        new_arr = ReplaceElement(min, max, arr);
        System.out.println("\nМассив с замененными элементами:");
        PrintArray(new_arr);

    }
    //Создание и заполнение массива рандомными числами в интервале [-10;10]
    public static int[] NewArray(){
        Random rand = new Random();
        int array[] = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(21) - 10;
            System.out.println(array[i]);
        }
        return array;
    }
    //Вывод массива в кансоль
    public static void PrintArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        return;
    }
    //Поиск наименьшего положительного элемента в массиве
    public static int SearchMin(int[] arr){
        int min = 10;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= 0) && (min > arr[i])) {
                min = arr[i];
            }
        }
        return min;
    }
    //Поиск наибольшего по модулю отрицательного элемента в массиве
    public static int SearchMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] < 0) && (max > arr[i])) { //изменить max < arr[i], чтобы искать макс. элемент НЕ по модулю
                max = arr[i];
            }
        }
        return max;
    }
    //Замена местами элементов в массиве
    public static int[] ReplaceElement(int a, int b, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a ) {
                arr[i] = b;
            }
            else if (arr[i] == b)
                arr[i] = a;
        }
        return arr;
    }
}
