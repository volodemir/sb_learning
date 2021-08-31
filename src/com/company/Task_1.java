package com.company.Task_1;

import java.util.*;

public class Task_1 {
    int codeCar; //объявляем переменную для кода авто
    public int gosNumber; //объявляем переменную для гос номера
    public String runAndAddParam;
    public int run; //объявляем переменную для пробега
    public int addParam; //объявляем переменную для доп параметра
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
        double max = Double.MIN_VALUE, min = Double.MAX_VALUE;
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

        List<String> listByCodeAuto = new ArrayList<String>(); //список авто, который будет сформирован после указанного пользователем кода авто
        //Для каждого госномера создаем по отдельному списку
        List<String> gosNumber1List = new ArrayList<>(); //список авто с госномером 1
        List<String> gosNumber2List = new ArrayList<>();
        List<String> gosNumber3List = new ArrayList<>();

        for (int i=0;i<arr.length;i++) {
            if (arr[i].contains(codeAuto)){
                listByCodeAuto.add(arr[i]);
                           }
        }
        sc.close();

        //Создаем экземпляры компаратора для сортировки
        ComparatorByRun comparator = new ComparatorByRun();
        ComparatorByAddParameter cr = new ComparatorByAddParameter();

        int totalRun1 = 0; //суммарный пробег для госномера 1
        int totalAddParam1 = 0; //суммарный доп параметр для госномера 1
        int totalRun2 = 0;
        int totalAddParam2 = 0;
        int totalRun3 = 0;
        int totalAddParam3 = 0;
        for (int i = 0; i < listByCodeAuto.size(); i++) {
            String str = listByCodeAuto.get(i);
            int addParam = Integer.parseInt(str.substring(str.lastIndexOf("-") + 1));
            int gosNumber = Integer.parseInt(str.substring(5, 6));
            int run = 0;
            if (str.substring(8).contains("-")) {
                run = Integer.parseInt(str.substring(7, str.lastIndexOf("-")));
                if (gosNumber == 1){
                    totalRun1 += run;
                    totalAddParam1 += addParam;
                }
                if (gosNumber == 2){
                    totalRun2 += run;
                    totalAddParam2 += addParam;
                }
                if (gosNumber == 3){
                    totalRun3 += run;
                    totalAddParam3 += addParam;
                }
            } else {
                run = Integer.parseInt(str.substring(7));
                if (gosNumber == 1) {
                    totalRun1 += run;
                }
                if (gosNumber == 2) {
                    totalRun2 += run;
                }
                if (gosNumber == 3) {
                    totalRun3 += run;
                }
            }
        }

        gosNumber1List.add(codeAuto + "_" + 1 + "-" + totalRun1 + "-" + totalAddParam1);
        gosNumber2List.add(codeAuto + "_" + 2 + "-" + totalRun2 + "-" + totalAddParam2);
        gosNumber3List.add(codeAuto + "_" + 3 + "-" + totalRun3 + "-" + totalAddParam3);

        List<String> sortByRun = new ArrayList<String>(); //список авто, сортируемый по пробегу
        List<String> sortByAddParameter = new ArrayList<String>(); //по доп параметру

        //Объединяем списки, сформированные по гос номерам
        sortByRun.addAll(gosNumber1List);
        sortByRun.addAll(gosNumber2List);
        sortByRun.addAll(gosNumber3List);

        sortByAddParameter.addAll(gosNumber1List);
        sortByAddParameter.addAll(gosNumber2List);
        sortByAddParameter.addAll(gosNumber3List);

        //Применяем сортировку по пробегу и доп параметру
        Collections.sort(sortByRun, comparator);
        Collections.sort(sortByAddParameter, cr);

        System.out.println("С сортировкой по пробегу");
        for (String s : sortByRun){
            System.out.println("Код авто: " + codeAuto + " Госномер: " + s.substring(5,6) + " Пробег: " + s.substring(7, s.lastIndexOf("-")) + " Доп параметр: " + s.substring(s.lastIndexOf("-")+1));
        }
        System.out.println("С сортировкой по доп параметру");
        for (String s : sortByAddParameter){
            System.out.println("Код авто: " + codeAuto + " Госномер: " + s.substring(5,6) + " Пробег: " + s.substring(7, s.lastIndexOf("-")) + " Доп параметр: " + s.substring(s.lastIndexOf("-")+1));
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
