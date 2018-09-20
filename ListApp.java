package linkedList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListApp {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insert("Василий", 18);
        list.insert("Игорь", 20);
        list.insert("Антон", 22);

        list.display();
        System.out.println();
       // if (!list.isEmpty()) list.delete();
       // list.display();

        LinkIterator iter = new LinkIterator(list);

        iter.insertAfter("Artem",22);
        iter.insertBefore("Denis",21);
//Вывод на экран нового списка
        list.display();
        //переход к следующему элементу, вывод его на экран и удаление
System.out.println();
iter.nexLink();
iter.getCurrent();
iter.deleteCurrent();
System.out.println();
//перебор элементов списка и замена возраста, если текущий год 2018
        iter.reset();
        String date = new SimpleDateFormat("yyyy").format(new Date());
int date2 = Integer.parseInt(date);
if (date2 == 2018){
        while (iter.current != null) {
iter.getCurrent();
        System.out.println();
        iter.resetCurrent();
        System.out.println();
        iter.nexLink();}}
//проверка
list.display();

    }

}
