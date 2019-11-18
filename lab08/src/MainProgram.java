public class MainProgram {
    public static void main(String[] args) {
        GameCharacter slime = new GameCharacter(
                "Slime", 100, 40, new Weapon(0, 0)
        );
        Weapon stick = new Weapon(3, 30);
        GameCharacter player = new GameCharacter("Inorin", 100, 20, stick);



        Gun rpg = new Gun(1200, 1, 1, 60);
        GameCharacter leon = new GameCharacter("Leon", 340, 44, rpg);

        Weapon a = new Gun();

        Dog dog = new Dog();

        Chicken kfc = new Chicken();
        dog.eat(kfc);

        Vegetable lettuce = new Vegetable();
        dog.eat(lettuce);

        Computer com = new Computer();

        Radio radio = new Radio();

        RemoteControl.increaseVolume(com);

        RemoteControl.decreaseVolume(radio);


    }
}
