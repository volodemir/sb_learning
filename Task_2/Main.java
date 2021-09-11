package Task_2;

import Task_2.Documents.*;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Document> documents = new ArrayList<>();

        documents.add(createLetter());
        documents.add(createEmploymentOrder());
        documents.add(createOrderForDismissal());

        Printer printer = new Printer(args);

        for (Document document : documents) {
            printer.print(document);
        }
        for (Document document : documents) {
            if (document instanceof StatusChangeble) {
                ((StatusChangeble) document).changeStatus(Status.COMPLETED);
            }
        }
        for (Document document : documents) {
            printer.print(document);
        }
    }

    private static Letter createLetter() {
        Letter letter = new Letter(1, "Письмо на деревню дедушке");
        letter.setFrom("Мальчик");
        letter.setTo("Дедушка");
        return letter;
    }

    private static EmploymentOrder createEmploymentOrder() {
        EmploymentOrder employmentOrder = new EmploymentOrder(2, "Приказ о приеме на работу Программистом", "Иванов Иван Иванович");
        employmentOrder.setText("Приказ о приеме на работу разработчика Автоматизированных систем");
        return employmentOrder;
    }

    private static OrderForDismissal createOrderForDismissal() {
        OrderForDismissal orderForDismissal = new OrderForDismissal(3, "Приказ об увольнении Иванова", "Иванов Иван Иванович");
        orderForDismissal.setText("Уволен Иванов");
        orderForDismissal.setReason("За то что ничего не делал");
        return orderForDismissal;
    }
}
//        Document letter = new Letter();
//        Document employmentOrder = new EmploymentOrder();
//        Document orderForDism = new OrderForDismissal();
//
//        User recepient = new User("Иванов И.И.", 25);
//        User sender = new User("Петров П.П.", 29);
//        User hired = new User("Анисимов Кирилл Вячеславович", 32);
//        User fired = new User("Кудакова Мария Павловна", 48);
//
//        System.out.println("Номер документа: " + letter.getNumber());
//        letter.getName();
//        letter.getRecepient(recepient.getName());
//        letter.getSender(sender.getName());
//        System.out.println("\n");
//
//        String status = "Создан";
//        System.out.println("Номер документа: " + employmentOrder.getNumber());
//        employmentOrder.getName();
//        employmentOrder.getEmployee(hired.getName());
//        employmentOrder.getTextOfOrder("Какой-то текст");
//        if (status.equals(Status.valueOf("EXECUTED"))) {
//            status = "Исполнен";
//        }
//        employmentOrder.setStatus(status);
//        System.out.println("\n");
//
//        System.out.println("Номер документа: " + orderForDism.getNumber());
//        orderForDism.getName();
//        orderForDism.getEmployee(fired.getName());
//        orderForDism.getTextOfOrder("Какой-то текст");
//        orderForDism.setStatus(status);
//        orderForDism.reasonForLeaving("По собственному");
//
//        System.out.println("\n");
//
//        status = "Исполнен";
//        System.out.println("Номер документа: " + employmentOrder.getNumber());
//        employmentOrder.getName();
//        employmentOrder.getEmployee(hired.getName());
//        employmentOrder.getTextOfOrder("Какой-то текст");
//        if (status.equals(Status.valueOf("EXECUTED"))) {
//            status = "Исполнен";
//        }
//        employmentOrder.setStatus(status);
//        System.out.println("\n");
//
//        System.out.println("Номер документа: " + orderForDism.getNumber());
//        orderForDism.getName();
//        orderForDism.getEmployee(fired.getName());
//        orderForDism.getTextOfOrder("Какой-то текст");
//        orderForDism.setStatus(status);
//        orderForDism.reasonForLeaving("По собственному");
//
//        if (args[0].equals("-simple")){
//            System.out.println("Номер документа: " + letter.getNumber());
//            letter.getName();
//            System.out.println("\n");
//
//            System.out.println("Номер документа: " + employmentOrder.getNumber());
//            employmentOrder.getName();
//            System.out.println("\n");
//
//            System.out.println("Номер документа: " + orderForDism.getNumber());
//            orderForDism.getName();
//        }
