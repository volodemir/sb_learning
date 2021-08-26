package Task_2;

/**
* Документ
*/

public interface Document {
    /**
    * Получить номер документа
    */
    int  getNumber();

    /**
     * Получить название документа
     */
    void getName();

    /**
     * Получить имя отправителя письма
     */
    public void getRecepient(String recipient);

    /**
     * Получить имя получателя письма
     */
    public void getSender(String sender);

    /**
     * Получить ФИО сотрудника
     */
    public void getEmployee(String employee);

    /**
     * Получить текст приказа
     */
    public void getTextOfOrder(String txt);

    /**
     * Установить статус (создан/исполнен)
     */
    public void setStatus(String status);

    /**
     * Получить причину увольнения
     */
    public void reasonForLeaving(String reason);
}
