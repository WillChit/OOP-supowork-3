public class Cat extends Pet{
    public Cat(String name){
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
        hunger = Math.max(0, hunger - 3);
    }
    public void sleep(){
        energy += 3;
    }
}
