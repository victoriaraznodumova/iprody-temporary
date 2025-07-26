package algorithms;

import java.util.Arrays;
import java.util.Random;

public class Sortings {
    public static void main(String[] args) {
        int[] values = new int[10];
        Random random = new Random();
        for(int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(values));
        System.out.println("Пузырьковая сортировка");

        for(int i = 0; i < values.length; i++) {
            //Количество проходов
            int size = values.length - i - 1;
            //Нужно идти до предпоследнего элемента, так как его не с чем сравнивать
            for(int j = 0; j < size; j++) {
                if (values[j] > values[j + 1]){
                    //Операция выделения памяти тоже может быть вынесена за пределы цикла, а в нем будет только присваивание значений
                    int temp = values[j + 1];
                    values[j + 1] = values[j];
                    values[j] = temp;
                }
                System.out.println( i + " " + Arrays.toString(values));
            }
        }
        System.out.println(Arrays.toString(values));





        values = new int[10];
        for(int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(10);
        }

        System.out.println("\nШейкерная сортировка");
        System.out.println(Arrays.toString(values));

        int leftIndex = 0, rightIndex = values.length - 1, temp;
        int iterationNumber = 1;
        //Можно сделать без проверки номера итерации, просто подряд проходить сначала с одной стороны, потом - с другой
        //Возможно, что будет появляться дополнительный ненужный прогон
        boolean wasChanged = true;
        //Можно убрать флаг, пример есть в конспекте
        while (leftIndex < rightIndex && wasChanged){
            wasChanged = false;
            if (iterationNumber % 2 == 1){
                int lastIndex = leftIndex;
                for(int i = leftIndex; i < rightIndex; i++) {
                    if (values[i] > values[i + 1]){
                        temp = values[i + 1];
                        values[i + 1] = values [i];
                        values[i] = temp;
                        lastIndex = i;
                        wasChanged = true;
                    }
                }
                rightIndex = lastIndex;
            }
            else{
                int lastIndex = rightIndex;
                for(int i = rightIndex - 1; i >= leftIndex; i--) {
                    if (values[i] > values[i + 1]){
                        temp = values[i + 1];
                        values[i + 1] = values [i];
                        values[i] = temp;
                        lastIndex = i + 1;
                        wasChanged = true;
                    }
                }
                leftIndex = lastIndex;
            }
            iterationNumber++;
        }
        System.out.println(Arrays.toString(values));



        values = new int[10];
        for(int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(10);
        }

        System.out.println("\nВстроенная сортировка");
        System.out.println(Arrays.toString(values));

        Arrays.sort(values);
        System.out.println(Arrays.toString(values));



        values = new int[10];
        for(int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(10);
        }

        System.out.println("\nПоиск минимального и максимального значений, фильтрация");
        System.out.println(Arrays.toString(values));

        int minimum = values[0];
        int maximum = values[0];
        for(int i = 1; i < values.length; i++) {
            if (values[i] < minimum){
                minimum = values[i];
            }
            if (values[i] > maximum){
                maximum = values[i];
            }
        }
        System.out.println("minimum: " + minimum);
        System.out.println("maximum: " + maximum);

        Arrays.sort(values);
        System.out.println(Arrays.toString(values));
        int valueToSearch = random.nextInt(10);
        int index = indexOf(values, valueToSearch);
        System.out.println("Index of " + valueToSearch + " is " + index);
        //Нужно пофиксить, так как он некорректно ищет последний элемент, выводит -1
        //Теперь вроде работает корректно, исправили в соответствии со встроенной функцией класс Arrays
    }


    private static int indexOf(int[] values, int value){
        int leftIndex2 = 0;
        int rightIndex2 = values.length - 1;
        int medium = -1;
        while (leftIndex2 <= rightIndex2){
            medium = (leftIndex2 + rightIndex2) / 2;
            if (values[medium] == value) return medium;
            if (values[medium] < value){
                leftIndex2 = medium + 1;
                //Нет смысла ставить левому индексу просто медиум. Если бы медиум имел значение, мы бы этот value уже вернули бы
            } else{
                rightIndex2 = medium - 1;
            }
        }
        return -1;
    }
}