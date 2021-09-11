package Task_2.Documents;

public abstract class AbstractDocument implements Document {

    private final int number;
    private String title;

    public AbstractDocument(int number, String title) {
        this.number = number;
        this.title = title;
    }

    public int getNumber (){
        return number;
    }
    public String getTitle(){
        return title;
    }
    public final void simplePrint(){
        System.out.println("Документ № " + number + ". " + title);
    }
}
