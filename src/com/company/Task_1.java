package com.company;

import java.util.*;

public class Task_1 {
    int codeCar; //объявляем переменную для кода авто
    public int gosNumber; //объявляем переменную для гос номера
    public String runAndAddParam;
    Integer run; //объявляем переменную для пробега
    int addParam; //объявляем переменную для доп параметра
    double costOfFuel; //стоимость топлива
    double expenseOfFuel; //расход топлива
    double fuelConsumption; //расход топлива на 100 км
    double totalExpense;
    double totalExpense_100;
    double totalExpense_200;
    double totalExpense_300;
    double totalExpense_400;
    public Task_1() {
        String[] arr = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
        for (int i = 0; i < arr.length; i++) {

            codeCar = Integer.parseInt(arr[i].substring(1, 4));
            gosNumber = Integer.parseInt(arr[i].substring(5, 6));
            runAndAddParam = arr[i].substring(7); //пробег с доп параметром в одной строке

            if (!runAndAddParam.contains("-")) { //если строка не содержит символ "-"
                run = Integer.parseInt(runAndAddParam.substring(0, runAndAddParam.length())); //пробег равен части строки с 0 элемента до её конца
                addParam = 0;
            } else {
                run = Integer.parseInt(runAndAddParam.substring(0, runAndAddParam.indexOf("-"))); //иначе пробег равен части строки с 0 элемента до индекса символа "-"
                addParam = Integer.parseInt(runAndAddParam.substring(runAndAddParam.indexOf("-") + 1, runAndAddParam.length()));
            }

            switch (codeCar) {
                case 100:
                    costOfFuel = 46.1;
                    fuelConsumption = 12.5;
                    break;
                case 200:
                    costOfFuel = 48.9;
                    fuelConsumption = 12;
                    break;
                case 400:
                    costOfFuel = 48.9;
                    fuelConsumption = 20;
                    break;
                case 300:
                    costOfFuel = 47.5;
                    fuelConsumption = 11.5;
                    break;
            }
            expenseOfFuel = costOfFuel * fuelConsumption * run/100;
            totalExpense += expenseOfFuel; //подсчет расхода топлива со всего массива строк
            if (codeCar == 100) {
                totalExpense_100 += expenseOfFuel;
            }
            if (codeCar == 200) {
                totalExpense_200 += expenseOfFuel;
            }
            if (codeCar == 300) {
                totalExpense_300 += expenseOfFuel;
            }
            if (codeCar == 400) {
                totalExpense_400 += expenseOfFuel;
            }
        }
        System.out.println("Общая стоимость расходов на ГСМ: " + totalExpense);
        System.out.println("Расходы на класс авто 100: " + totalExpense_100);
        System.out.println("Расходы на класс авто 200: " + totalExpense_200);
        System.out.println("Расходы на класс авто 300: " + totalExpense_300);
        System.out.println("Расходы на класс авто 400: " + totalExpense_400);

        double[] arrTotalExp = {totalExpense_100, totalExpense_200, totalExpense_300, totalExpense_400};
        double max = 0.0, min = Double.MAX_VALUE;
        String typeOfCarMax = "", typeOfCarMin = "";

        for (double m : arrTotalExp) {
            if (m > max) max = m;
            if(m < min) min = m;

            for (int i = 0; i < arrTotalExp.length; i++) {
                if (i == 0 && arrTotalExp[i] == max) {
                    typeOfCarMax = "легковой авто";
                }
                if (i == 0 && arrTotalExp[i] == min) {
                    typeOfCarMin = "легковой авто";
                }
                if (i == 1 && arrTotalExp[i] == max) {
                    typeOfCarMax = "грузовой авто";
                }
                if (i == 1 && arrTotalExp[i] == min) {
                    typeOfCarMin = "грузовой авто";
                }
                if (i == 2 && arrTotalExp[i] == max) {
                    typeOfCarMax = "пассажирский транспорт";
                }
                if (i == 2 && arrTotalExp[i] == min) {
                    typeOfCarMin = "пассажирский транспорт";
                }
                if (i == 3 && arrTotalExp[i] == max) {
                    typeOfCarMax = "тяжелая техника(краны)";
                }
                if (i == 3 && arrTotalExp[i] == min) {
                    typeOfCarMin = "тяжелая техника(краны)";
                }
            }
        }
        System.out.println("Тип авто, имеющий наибольшую стоимость расходов: " + typeOfCarMax);
        System.out.println("Тип авто, имеющий наименьшую стоимость расходов: " + typeOfCarMin);

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите код авто - Вводить строго 'C100'/'C200'/'C300'/'C400': ");
        String codeAuto = sc.nextLine();

        List<String> sortByRun = new ArrayList<String>(); //список авто, сортируемый по пробегу
        List<String> sortByAddParameter = new ArrayList<String>();//список авто, сортируемый по доп параметру
        for (int i=0;i<arr.length;i++) {
            if (arr[i].contains(codeAuto)){
                sortByRun.add(arr[i]);
                sortByAddParameter.add(arr[i]);
                           }
        }
        sc.close();
        ComparatorByRun comparator = new ComparatorByRun();
        Collections.sort(sortByRun, comparator);
        ComparatorByAddParameter cr = new ComparatorByAddParameter();
        Collections.sort(sortByAddParameter, cr);
        String []sortByRunArray = new String[sortByRun.size()];
        String []sortByAddParameterArray = new String[sortByAddParameter.size()];
        System.out.println("С сортировкой по пробегу ");
        for (int i = 0; i < sortByRun.size(); i++) {
            sortByRunArray[i] = sortByRun.get(i);
            String addParam = sortByRunArray[i].substring(sortByRunArray[i].lastIndexOf("-") + 1);
            String gosNumber = sortByRunArray[i].substring(5, 6);
            String run = "";
            System.out.print("Код авто: " + codeAuto + " ");
            System.out.print("Госномер: " + gosNumber + " ");
            if (sortByRunArray[i].substring(8).contains("-")) {
                run = sortByRunArray[i].substring(7, sortByRunArray[i].lastIndexOf("-"));
                System.out.print("Пробег: " + run + " ");
                System.out.println("Доп параметр: " + addParam);
            } else {
                run = sortByRunArray[i].substring(7);
                System.out.println("Пробег: " + run);
            }
        }
        System.out.println("С сортировкой по доп параметру ");
        for (int i = 0; i < sortByAddParameter.size(); i++) {
            sortByAddParameterArray[i] = sortByAddParameter.get(i);
            String addParam = sortByAddParameterArray[i].substring(sortByAddParameterArray[i].lastIndexOf("-") + 1);
            String gosNumber = sortByAddParameterArray[i].substring(5, 6);
            String run = "";
            System.out.print("Код авто: " + codeAuto + " ");
            System.out.print("Госномер: " + gosNumber + " ");
            if (sortByAddParameterArray[i].substring(8).contains("-")) {
                run = sortByAddParameterArray[i].substring(7, sortByAddParameterArray[i].lastIndexOf("-"));
                System.out.print("Пробег: " + run + " ");
                System.out.println("Доп параметр: " + addParam);
            } else {
                run = sortByAddParameterArray[i].substring(7);
                System.out.println("Пробег: " + run);
            }
        }
}
    public class ComparatorByRun implements Comparator<String> {

        @Override
        public int compare(String str1, String str2) {

            int num1 = 0;
            int num2 = 0;
            if (!str1.substring(7, str1.length()).contains("-")) {
                num1 = Integer.parseInt(str1.substring(7, str1.length()));
            }
            if(!str2.substring(7, str2.length()).contains("-")){
                num2 = Integer.parseInt(str2.substring(7, str2.length()));
            }
            else{
                num1 = Integer.parseInt(str1.substring(7, str1.lastIndexOf("-")));
                num2 = Integer.parseInt(str2.substring(7, str2.lastIndexOf("-")));
            }
            return num1 - num2;
        }
    }
    public class ComparatorByAddParameter implements Comparator<String> {

        @Override
        public int compare(String str1, String str2) {

            int num1 = 0;
            int num2 = 0;
            if (str1.substring(8).contains("-")) {
                num1 = Integer.parseInt(str1.substring(str1.lastIndexOf("-")));

            }
            if (str2.substring(8).contains("-")){
                num2 = Integer.parseInt(str2.substring(str2.lastIndexOf("-")));
            }
            return num2 - num1;
        }
    }

        public static void main (String[]args){
            Task_1 gsm = new Task_1();

        }
    }
