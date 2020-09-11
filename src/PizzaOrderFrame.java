import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class PizzaOrderFrame extends Frame {

    public void setCurrentPizza(Pizza currentPizza) {
        this.currentPizza = currentPizza;
    }

    private Pizza currentPizza;

    public PizzaOrderFrame(){
        this.setSize(600,600);
        this.setTitle("Pizza Order Window!");

        currentPizza = new Pizza();
        createPanels();
    }

    private void createPanels(){
        JPanel main = new JPanel();
        main.setSize(600,600);
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        JPanel crust = new JPanel();
        JPanel size = new JPanel();
        JPanel toppings = new JPanel();

        JPanel p2 = new JPanel();

        JPanel p3 = new JPanel();

        JLabel lbl1 = new JLabel("Crust:");
        JRadioButton bt1 = new JRadioButton("Thin");
        bt1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                currentPizza.setCrust(bt1.getText());
            }
        });
        JRadioButton bt2 = new JRadioButton("Regular");
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                currentPizza.setCrust(bt2.getText());
            }
        });
        JRadioButton bt3 = new JRadioButton("Deep-Dish");
        bt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                currentPizza.setCrust(bt3.getText());
            }
        });
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(bt1);
        btnGroup.add(bt2);
        btnGroup.add(bt3);
        crust.add(lbl1);
        crust.add(bt1);
        crust.add(bt2);
        crust.add(bt3);

        JLabel lbl2 = new JLabel("Size:");
        JComboBox<String> sizes = new JComboBox<String>();
        sizes.addItem("Small");
        sizes.addItem("Medium");
        sizes.addItem("Large");
        sizes.addItem("X-Large");
        sizes.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                currentPizza.setSize((String)sizes.getSelectedItem());

            }
        });
        size.add(lbl2);
        size.add(sizes);

        //toppings checkbox
        JLabel lbl3 = new JLabel("Toppings:");
        JCheckBox tp1 = new JCheckBox("Pepperoni");
        tp1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(currentPizza.getToppings().contains(tp1.getText())){
                    currentPizza.removeTopping(tp1.getText());
                }
                else{
                    currentPizza.addToppings(tp1.getText());
                }
            }
        });
        JCheckBox tp2 = new JCheckBox("Salami");
        tp2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(currentPizza.getToppings().contains(tp2.getText())){
                    currentPizza.removeTopping(tp2.getText());
                }
                else{
                    currentPizza.addToppings(tp2.getText());
                }
            }
        });
        JCheckBox tp3 = new JCheckBox("Ham");
        tp3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(currentPizza.getToppings().contains(tp3.getText())){
                    currentPizza.removeTopping(tp3.getText());
                }
                else{
                    currentPizza.addToppings(tp3.getText());
                }
            }
        });
        JCheckBox tp4 = new JCheckBox("Pastrami");
        tp4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(currentPizza.getToppings().contains(tp4.getText())){
                    currentPizza.removeTopping(tp4.getText());
                }
                else{
                    currentPizza.addToppings(tp4.getText());
                }
            }
        });
        JCheckBox tp5 = new JCheckBox("Sausage");
        tp5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(currentPizza.getToppings().contains(tp5.getText())){
                    currentPizza.removeTopping(tp5.getText());
                }
                else{
                    currentPizza.addToppings(tp5.getText());
                }
            }
        });
        JCheckBox tp6 = new JCheckBox("Boogers");
        tp6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(currentPizza.getToppings().contains(tp6.getText())){
                    currentPizza.removeTopping(tp6.getText());
                }
                else{
                    currentPizza.addToppings(tp6.getText());
                }
            }
        });
        toppings.add(lbl3);
        toppings.add(tp1);
        toppings.add(tp2);
        toppings.add(tp3);
        toppings.add(tp4);
        toppings.add(tp5);
        toppings.add(tp6);

        p1.add(crust);
        p1.add(size);
        p1.add(toppings);

        //receipt text
        JLabel lbl4 = new JLabel("Receipt:");
        JTextArea receipt = new JTextArea(10,20);
        p2.add(lbl4);
        p2.add(receipt);


        //button 3
        JButton order = new JButton("Order");
        order.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                DecimalFormat df = new DecimalFormat("#.##");
                String space = String.format("%-30.30s  %-30.30s%n", " ", " ");
                String l1c1 = currentPizza.getCrust() + " + " + currentPizza.getSize();
                String l1c2 = "$" + Register.calculateCrustSizeCost(currentPizza);
                String line1 = String.format("%-30.30s  %-30.30s%n", l1c1, l1c2);

                String l2c1 = "";
                for(String topping: currentPizza.getToppings()){
                    l2c1 += topping;
                    l2c1 +=  " ";

                }
                String l2c2 ="$" + Register.calculateToppingCost(currentPizza);
                String line2 = String.format("%-30.30s  %-30.30s%n", l2c1, l2c2);
                String line3 = String.format("%-30.30s  %-30.30s%n", "Subtotal", "$" +
                        (Register.calculateCrustSizeCost(currentPizza) + Register.calculateToppingCost(currentPizza)));

                String line4 = String.format("%-30.30s  %-30.30s%n", "Tax", "$" +
                        (df.format((Register.calculateCrustSizeCost(currentPizza) + Register.calculateToppingCost(currentPizza)) *.07)));

                String line5 = String.format("%-30.30s  %-30.30s%n", "Total", "$" + df.format(
                        ((Register.calculateCrustSizeCost(currentPizza) + Register.calculateToppingCost(currentPizza)) +
                                ((Register.calculateCrustSizeCost(currentPizza) + Register.calculateToppingCost(currentPizza)) *.07))
                ));

                receipt.append(line1);
                receipt.append(line2);
                receipt.append(space);
                receipt.append(space);
                receipt.append(line3);
                receipt.append(line4);
                receipt.append("-------------------------------------------------\n");
                receipt.append(line5);

            }
        });
        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                receipt.setText("");
            }
        });
        JButton quit = new JButton("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(-1);
            }
        });
        p3.add(order);
        p3.add(clear);
        p3.add(quit);


        main.add(p1);
        main.add(p2);
        main.add(p3);

        this.add(main);
    }
}




