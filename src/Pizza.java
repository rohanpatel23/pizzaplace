import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pizza {
    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void addToppings(String topping) {
        this.toppings.add(topping);
    }

    public void removeTopping(String topping){
        this.toppings.remove(topping);
    }

    private String crust;
    private String size;
    private ArrayList<String> toppings;

    public Pizza(){
        this.toppings =  new ArrayList<>();
    }
}
