package Task_2.Exception;

public class PrinterNoPaperException extends RuntimeException{
    public PrinterNoPaperException(String message){
        super (message);
    }
}
