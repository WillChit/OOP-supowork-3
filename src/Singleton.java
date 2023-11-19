public class Singleton {
    static Singleton theInstance;

    public static Singleton getInstance(){
        if (theInstance == null) theInstance = new Singleton();
        return theInstance;
    }
}