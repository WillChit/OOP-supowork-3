public abstract class Pet implements Comparable<Pet>{
    protected int happiness;
    protected int hunger;
    protected int age;
    protected int energy;
    protected boolean isAlive;
    protected String name;

    public Pet(String name){
        isAlive = true;
        this.name = name;
        happiness = 5;
        hunger = 0;
        age = 0;
        energy = 5;
    }

    public int compareTo(Pet otherPet){
        if (getProbabilityOfDeath() < otherPet.getProbabilityOfDeath()) return 1;
        if (otherPet.getProbabilityOfDeath() < getProbabilityOfDeath()) return -1;
        else return 0;
    }

    public double getProbabilityOfDeath(){
        double res = 1;
        res *= (1.0 / Math.pow(hunger + 1, 0.3));
        res *= (1.0 / (Math.pow(age + 1, 0.3)));
        res *= Math.min(1.0, 5.0 / (Math.pow(energy, 0.3)));
        res *= Math.min(1.0, 5.0 / (Math.pow(happiness, 0.3)));
        return 1.0 - res;
    }

    public String toString(){
        String res = "";
        res += "Name: " + name + "\n";
        res += "Chance of death: " + getProbabilityOfDeath() + "\n";
        res += "Happiness: " + happiness + "\n";
        res += "Hunger: " + hunger + "\n";
        res += "Age: " + age + "\n";
        res += "Energy: " + energy + "\n";
        return res;
    }

    public String getName(){
        return name;
    }

    public void update(){
        hunger++;
        happiness--;
        age++;
        energy--;
        energy = Math.max(energy, 0);
        if (getProbabilityOfDeath() > Math.random()) isAlive = false;
    }
    public abstract void pet();
    public abstract void feed();
    public abstract void sleep();
    public boolean isDead(){
        return !isAlive;
    }
}
