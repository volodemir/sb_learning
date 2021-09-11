package Task_2;

import Task_2.Documents.Document;

public class Printer {
    private boolean simple;

    public Printer(String ... args) {
        simple = args.length > 0 && args[0].contains("-simple");
    }

    public void print(Document document) {
        if (simple) {
            document.simplePrint();
        } else {
            document.detailPrint();
        }
    }
}
