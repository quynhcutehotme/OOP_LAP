package OOP;

public class Animal {
    public String name;

    public Animal(String name){this.name = name;}
    @Override
    public String toString(){
        return "Animal[name="+name+"]";}
}

class Mammal extends Animal{
    public Mammal(String name){
        super(name);
    }
    @Override
    public String toString(){
        return ("Mammal "+super.toString());
    }

}

class Cat extends Mammal{
    public Cat(String name){super(name);}
    public void greets(){
        System.out.println("Meow");
    }
    @Override
    public String toString(){
        return ("Cat "+ super.toString());
    }

}

class Dog extends Mammal{
    public Dog(String name){super(name);}
    public void greets(){
        System.out.println("Woof");
    }
    public void greets(Dog another){
        System.out.println("wooooof");
    }
    @Override
    public String toString(){
        return ("Dog "+ super.toString());
    }
}

class TestAnimal {
    public static void main(String[] args) {
        Dog dog = new Dog("Dog");
        System.out.println(dog.toString());
        Dog dog1 = new Dog("Puppy");
        dog.greets(dog1);

        Cat cat = new Cat("Kitty");
        System.out.println(cat.toString());



    }
}
