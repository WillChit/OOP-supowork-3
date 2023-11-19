public class Car implements Comparable<Car>{
    private String manufacturer;
    private int age;

    public String getManufacturer(){ return manufacturer;}
    public int getAge(){ return age;}

    public Car(String _manufacturer, int _age){
        manufacturer = _manufacturer;
        age = _age;
    }

    public int compareTo(Car otherCar){
        if (stringComp(getManufacturer(), otherCar.getManufacturer())) return -1;
        if (stringComp(otherCar.getManufacturer(), getManufacturer())) return 1;
        if (getAge() < otherCar.getAge()) return -1;
        if (otherCar.getAge() < getAge()) return 1;
        return 0;
    }

    private static boolean stringComp(String a, String b){
        for (int i = 0; i < Math.min(a.length(), b.length()); i++){
            if (a.charAt(i) < b.charAt(i)) return true;
        }

        return a.length() < b.length();
    }
}
