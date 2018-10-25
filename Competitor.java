package Fine;

public interface Competitor {

    //вторая переменная нужна для цикла в классе Team
    void run(int dist, int n);

    void swim(int dist, int n);

    void jump(int height, int n);

    boolean isOnDistance();

    void info();
}
