package linkedList;

public class LinkIterator {
    public Link current;
    private Link previous;
    private LinkedList list;

    public LinkIterator(LinkedList list) {
        this.list = list;
        this.reset();
    }

    //перемещение в начало
    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    //корректировка возраста
    public Link resetCurrent() {
        String name = current.name;
        int age1 = current.age+1;
        current.age = age1;
        System.out.println(name+" "+age1);
        return current;
    }





    //перемещение к следующему элементу
    public void nexLink() {
        previous = current;
        current = current.next;
    }

    //возвращает элемент, на который указывает итератор
    public Link getCurrent() {
        String name = current.name;
        int age = current.age;
        System.out.println(name+" "+age);
        return current;
    }

    // true, если итератор в конце списка
    public boolean atEnd() {
        return (current.next == null);
    }

    public void insertAfter(String name, int age) {
        Link newLink = new Link(name, age);
        if (list.isEmpty()) {
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nexLink();
        }
    }

    public void insertBefore(String name, int age) {
        Link newLink = new Link(name, age);
        if (previous == null) {
            newLink.next = list.getFirst();
            list.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public String deleteCurrent() {
        String name = current.name;
        if (previous == null) {
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }
        return name;
    }
}
