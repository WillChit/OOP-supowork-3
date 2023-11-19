public class Dog extends Pet{

    public Dog(String name){
        super(name);
    }

    public void update(){
        hunger++;
        happiness--;
        age++;
        energy--;
    }
    public void pet(){
        happiness += 3;
    }
    public void feed(){
        hunger = Math.max(0, hunger - 1);
    }
    public void sleep(){
        energy += 5;
    }
}
