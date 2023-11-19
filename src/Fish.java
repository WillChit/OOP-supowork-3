public class Fish extends Pet{

    public Fish(String name){
        super(name);
    }

    public void update(){
        hunger++;
        happiness--;
        age++;
        energy--;
    }
    public void pet(){
        happiness += 5;
    }
    public void feed(){
        hunger = Math.max(0, hunger - 2);
    }
    public void sleep(){
        energy += 10;
    }
}
