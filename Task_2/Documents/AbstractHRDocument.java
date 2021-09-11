package Task_2.Documents;

public abstract class AbstractHRDocument extends AbstractDocument implements StatusChangeble {

    private final String employee;
    private String text;
    private Status status;

    public AbstractHRDocument(int number, String title, String employee) {
        super(number, title);
        this.employee = employee;
        this.status = Status.CREATED;
    }
    public void setText(String text){this.text=text;}

    public final void changeStatus (Status status){
        if (this.status == Status.COMPLETED){
            System.out.println("Запрещено изменение статуса");
        }
        else {
            this.status = status;
            System.out.println("Статус изменен на " + status + " " + getNumber() + " " + getTitle());
        }

    }
    public Status getStatus(){
        return status;
    }
}
