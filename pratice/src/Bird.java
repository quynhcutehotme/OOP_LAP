package OOP;

public abstract class Bird {
    public void eat() {
        System.out.println("I am eating!");
    }
}


interface FlyingBird {
    void fly();
}

interface SwimmingBird {
    void swim();
}

class Sparrow extends Bird implements FlyingBird {
    @Override
    public void fly() {
        System.out.println("I am flying high!");
    }
}

class Penguin extends Bird implements SwimmingBird {
    @Override
    public void swim() {
        System.out.println("I am swimming!");
    }
}

class Duck extends Bird implements FlyingBird, SwimmingBird {
    @Override
    public void fly() {
        System.out.println("I am flying short distances!");
    }
    @Override
    public void swim() {
        System.out.println("I am swimming in the pond!");
    }
}



