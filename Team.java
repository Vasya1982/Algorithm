/**
 *  Geekbrains. Java, lvl 2.
 *  Домашнее задание к уроку 1.
 * @ author Golovanov Igor
 * @ version Oct 25, 2018
 */



package Fine;

public class Team implements Competitor {
    String name;

    //нужны для вывода на экран имен
    String names[];
    String a = "";
    String b = "";
    String c = "";

    int maxRunDistance[];
    int maxJumpHeight[];
    int maxSwimDistance[];

    boolean active;

    public Team(String name) {
        this.name = name;
        int maxRunDistance[] = {2000, 3000, 4000};
        this.maxRunDistance = maxRunDistance;
        int maxJumpHeight[] = {30, 20, 5};
        this.maxJumpHeight = maxJumpHeight;
        int maxSwimDistance[] = {200, 150, 100};
        this.maxSwimDistance = maxSwimDistance;
        String names[] = {"Angela", "Karina", "Kristina"};
        this.names = names;
        this.active = true;
    }

    @Override
    public void run(int dist, int n) {
        if (dist <= maxRunDistance[n]) {
            System.out.println(names[n] + " успешно прошел бег");
            a = a + names[n] + ", ";
        } else {
            System.out.println(names[n] + " провалил бег");
            active = false;
        }
    }

    @Override
    public void swim(int dist, int n) {
        if (dist <= maxSwimDistance[n]) {
            System.out.println(names[n] + " успешно проплыл");
            b = b + names[n] + ", ";
        } else {
            System.out.println(names[n] + " провалил правание");
            active = false;
        }
    }

    @Override
    public void jump(int height, int n) {
        if (height <= maxJumpHeight[n]) {
            System.out.println(names[n] + " успешно прыгнул");
            c = c + names[n] + ", ";
        } else {
            System.out.println(names[n] + " провалил прыжок");
            active = false;

        }
    }

    @Override
    public boolean isOnDistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(a + " " + "успешно пробежали");
        System.out.println(b + " " + "успешно проплыли");
        System.out.println(c + " " + "успешно подпрыгнули");
    }

}
