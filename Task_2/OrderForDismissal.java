package Task_2;

public class OrderForDismissal implements Document{
    int count;

    @Override
    public final int getNumber() {
        return count++;
    }

    @Override
    public void getName() {
        System.out.println("Название документа: Приказ об увольнении");
    }

    @Override
    public void getRecepient(String recipient) {

    }

    @Override
    public void getSender(String sender) {

    }

    @Override
    public final void getEmployee(String employee) {
        System.out.println("ФИО сотрудника: " + employee);
    }

    @Override
    public void getTextOfOrder(String txt) {
        System.out.println("Текст приказа: " + txt);
    }

    @Override
    public void setStatus(String status) {
        System.out.println("Статус: " + status);
    }

    @Override
    public void reasonForLeaving(String reason) {
        System.out.println("Причина увольнения: " + reason);
    }
}
