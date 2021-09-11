package Task_2.Documents;

public class EmploymentOrder extends AbstractHRDocument{
    //private String text;

    public EmploymentOrder(int number, String title, String employee) {
        super(number, title, employee);
    }
    public void detailPrint(){
        System.out.println("ПОДРОБНО Приказ о приеме");
        System.out.println("Статус: " + getStatus().title);

    }
}
