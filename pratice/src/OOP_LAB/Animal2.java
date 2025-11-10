package OOP;

public abstract class Animal2 {

    public String name;
    public Animal2(String name){this.name = name;}
    public abstract void greets();
}

class Cat extends Animal2{
    public Cat(String name){super(name);}
    public void greets(){
        System.out.println("Meow");
    }


}

class Dog extends Animal2{
    public Dog(String name){super(name);}
    public void greets(){
        System.out.println("Woof");
    }
    public void greets(Dog another){
        System.out.println("Wooooof");
    }

}

class BigDog extends Dog{
    public BigDog(String name){
        super(name);
    }
    @Override
    public void greets(){
        System.out.println("Wooow");
    }
    @Override
    public void greets(Dog another){
        System.out.println("Wooooow");
    }
    public void greets(BigDog another){
        System.out.println("Wooooooooow");
    }


}

class TestAnimal {
    public static void main(String[] args) {
        Dog dog = new Dog("Dog");
        Dog dog1 = new Dog("Puppy");
        dog.greets(dog1);

        BigDog bigDog = new BigDog("Chó bự");
        BigDog bigDog2 = new BigDog("Chó chà bá");
        bigDog.greets(bigDog2);

        Cat cat = new Cat("Kitty");
        cat.greets();




    }
}
