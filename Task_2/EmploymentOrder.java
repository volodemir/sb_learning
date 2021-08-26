package Task_2;

public class EmploymentOrder implements Document{
    int count;

    @Override
    public final int getNumber() {
        return count++;
    }

    @Override
    public void getName() {
        System.out.println("Название документа: Приказ о приёме на работу");
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
    public void reasonForLeaving(String status) {

    }
}
