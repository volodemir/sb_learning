package Task_2;

public class Main {
    public enum Status {
        CREATED("Создан"),
        EXECUTED("Исполнен");
        private String status;

        Status(String status) {
            this.status = status;
        }
    }

    public static void main(String[] args) {
        Document letter = new Letter();
        Document employmentOrder = new EmploymentOrder();
        Document orderForDism = new OrderForDismissal();

        User recepient = new User("Иванов И.И.", 25);
        User sender = new User("Петров П.П.", 29);
        User hired = new User("Анисимов Кирилл Вячеславович", 32);
        User fired = new User("Кудакова Мария Павловна", 48);

        System.out.println("Номер документа: " + letter.getNumber());
        letter.getName();
        letter.getRecepient(recepient.getName());
        letter.getSender(sender.getName());
        System.out.println("\n");

        String status = "Создан";
        System.out.println("Номер документа: " + employmentOrder.getNumber());
        employmentOrder.getName();
        employmentOrder.getEmployee(hired.getName());
        employmentOrder.getTextOfOrder("Какой-то текст");
        if (status.equals(Status.valueOf("EXECUTED"))) {
            status = "Исполнен";
        }
        employmentOrder.setStatus(status);
        System.out.println("\n");

        System.out.println("Номер документа: " + orderForDism.getNumber());
        orderForDism.getName();
        orderForDism.getEmployee(fired.getName());
        orderForDism.getTextOfOrder("Какой-то текст");
        orderForDism.setStatus(status);
        orderForDism.reasonForLeaving("По собственному");

        System.out.println("\n");

        status = "Исполнен";
        System.out.println("Номер документа: " + employmentOrder.getNumber());
        employmentOrder.getName();
        employmentOrder.getEmployee(hired.getName());
        employmentOrder.getTextOfOrder("Какой-то текст");
        if (status.equals(Status.valueOf("EXECUTED"))) {
            status = "Исполнен";
        }
        employmentOrder.setStatus(status);
        System.out.println("\n");

        System.out.println("Номер документа: " + orderForDism.getNumber());
        orderForDism.getName();
        orderForDism.getEmployee(fired.getName());
        orderForDism.getTextOfOrder("Какой-то текст");
        orderForDism.setStatus(status);
        orderForDism.reasonForLeaving("По собственному");

        if (args[0].equals("-simple")){
            System.out.println("Номер документа: " + letter.getNumber());
            letter.getName();
            System.out.println("\n");

            System.out.println("Номер документа: " + employmentOrder.getNumber());
            employmentOrder.getName();
            System.out.println("\n");

            System.out.println("Номер документа: " + orderForDism.getNumber());
            orderForDism.getName();
        }
    }
}
