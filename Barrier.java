package Fine;

public abstract class Barrier {
    public abstract void doIt(Competitor competitor);
}

class Wall extends Barrier {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height, 1);
    }
}

class Water extends Barrier {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length, 1);
    }
}

class Cross extends Barrier {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length, 1);
    }
}

class Course extends Barrier {
    int lengthW;
    int lengthG;
    int height;

    public Course(int lengthG, int lengthW, int height) {
        this.lengthW = lengthW;
        this.lengthG = lengthG;
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        for (int n = 0; n <= 2; n++) {
            competitor.swim(lengthW, n);
            competitor.run(lengthG, n);
            competitor.jump(height, n);
        }
    }
}


class MainCross {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Bob"), new Cat("Vaska"), new Dog("Sharik")};
        Barrier[] barriers = {new Cross(80), new Wall(5), new Water(3)};

        for (Competitor c : competitors) {
            for (Barrier b : barriers) {
                b.doIt(c);
                if (!c.isOnDistance()) {
                    break;
                }
            }
        }
        for (Competitor c : competitors) {
            c.info();
        }

        // Выполнение ДЗ
        Team team = new Team("GTO Stars");
        Course c = new Course(100, 10, 10);
        c.doIt(team);
        team.info();
    }
}