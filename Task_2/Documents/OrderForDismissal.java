package Task_2.Documents;

import Task_2.Documents.AbstractHRDocument;

public class OrderForDismissal extends AbstractHRDocument {

    private String reason;

    public OrderForDismissal(int number, String title, String employee) {
        super(number, title, employee);
    }

    public void setReason (String reason){ this.reason = reason; }

    @Override
    public void detailPrint() {
        System.out.println("ПОДРОБНО приказ об увольнении");
        System.out.println("Статус: " + getStatus().title);
    }
}
