public class Register {
    public static double calculateCrustSizeCost(Pizza pizza){

        String size = pizza.getSize();

        double sizeCost = 0;
        switch(size){
            case "Small":
                sizeCost = 8.0;
                break;
            case "Medium":
                sizeCost = 12.0;
                break;
            case "Large":
                sizeCost = 16.0;
                break;
            case "X-Large":
                sizeCost = 20.0;
                break;
            default:
                sizeCost = 0;
                break;

        }
        return sizeCost;
    }

    public static double calculateToppingCost(Pizza pizza){
        return (pizza.getToppings().size() - 1) * 1.0;
    }

}
