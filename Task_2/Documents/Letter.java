package Task_2.Documents;

public class Letter extends AbstractDocument {

    private String from;
    private String to;

    public Letter(int number, String title) {
        super(number, title);
    }

    public void setFrom(String from){
        this.from = from;
    }

    public void setTo (String to){
        this.to = to;
    }

    @Override
    public void detailPrint() {
        System.out.println("============== Письмо ==============");
        System.out.println("Номер: " + getNumber());
        System.out.println("Название: " + getTitle());
        System.out.println("От кого: " + from);
        System.out.println("Кому: " + to);
        System.out.println("====================================");
    }
}
