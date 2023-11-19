import java.util.*;

public class Game {
    private Vector<Pet> pets;
    private Scanner scanner;

    public Game(){
        pets = new Vector<Pet>();
        scanner = new Scanner(System.in);
    }

    public void addPet(){
        int numberOfPetsAvailable = 3;

        System.out.println("what kind of pet do you want\n1: cat\n2: dog\n3: fish");
        int inp = 1000000000;
        while (inp > numberOfPetsAvailable || inp < 1){
            try{
                inp  = Integer.parseInt(scanner.next());
            } catch(Exception e){
                System.out.println("enter a valid number");
            }
        }

        System.out.println("what would you like to name your pet");
        String name = scanner.next();

        if (inp == 1) pets.add(new Cat(name));
        if (inp == 2) pets.add(new Dog(name));
        if (inp == 3) pets.add(new Fish(name));
    }

    public void run(){
        double chanceToGetPet = 0.2;
        addPet();

        while (true){
            Collections.sort(pets);
            for (int i = 0; i < pets.size(); i++){
                System.out.println((i + 1) + "\n" + pets.get(i));
            }

            System.out.println("Which pet would you like to do something with: ");
            int inp = 1000000000;
            while (inp > pets.size() || inp < 1){
                try{
                    inp  = Integer.parseInt(scanner.next());
                } catch(Exception e){
                    System.out.println("enter a valid number");
                }
            }
            inp--;

            System.out.println("What would you like to do with your pet\n1: pet\n2: feed\n3: have it rest");
            int actions = 3;
            int inp2 = 1000000000;
            while (inp2 > actions || inp2 < 0){
                try{
                    inp2  = Integer.parseInt(scanner.next());
                } catch(Exception e){
                    System.out.println("enter a valid number");
                }
            }

            if (inp2 == 1) pets.get(inp).pet();
            else if (inp2 == 2) pets.get(inp).feed();
            else if (inp2 == 3) pets.get(inp).sleep();

            for (int i = pets.size() - 1; i >= 0; i--){
                pets.get(i).update();
                if (pets.get(i).isDead()){
                    pets.remove(i);
                }
            }

            if (pets.size() == 0) break;

            if (Math.random() < chanceToGetPet){
                addPet();
            }
        }

        System.out.println("all your pets have died :(");
    }
}
