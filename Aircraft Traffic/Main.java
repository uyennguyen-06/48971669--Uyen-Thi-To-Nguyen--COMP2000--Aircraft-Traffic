import javax.swing.JFrame;

public class Main{
    public static void main (String[] args){
        System.out.println("Program started!");
       
        JFrame mainPanel = new JFrame();
        mainPanel.setName("This is the simulation"); // ID
        mainPanel.setTitle("Airport Simulation"); // title of tab
        mainPanel.setSize(1000, 800); // size, duh
        mainPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ensure jpanel tab can close
        JPanelVisualizer plaeTemp = new JPanelVisualizer(); // creates objects
        // adding the elements
        mainPanel.add(plaeTemp); // adds objects
        
        mainPanel.setVisible(true); // whoa, i can see clearly now
        
    }
}