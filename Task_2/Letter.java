package Task_2;

public class Letter implements Document {
int count;

    @Override
    public final int getNumber() {
        return count++;
    }

    @Override
    public void getName() {
        System.out.println("Название документа: Письмо");
    }

    @Override
    public void getRecepient(String recipient){
        System.out.println("Кому: " + recipient);
    }

    @Override
    public void getSender(String sender){
        System.out.println("От кого: " + sender);
    }

    @Override
    public void getEmployee(String employee) {

    }

    @Override
    public void getTextOfOrder(String txt) {

    }

    @Override
    public void setStatus(String status) {

    }

    @Override
    public void reasonForLeaving(String status) {

    }
}
