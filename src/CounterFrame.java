import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterFrame extends JFrame {
    private DataBase dataBase;

    public CounterFrame(DataBase dataBase) throws HeadlessException {
        super("CaloriesCounter");
        this.dataBase = dataBase;
        setSize(400, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel);
        JTextField textField = new JTextField();
        textField.setSize(100, 40);
        textField.setVisible(true);
        textField.setText("Enter food name:");
        panel.add(textField);
        JLabel label = new JLabel();
        panel.add(label);
        JButton button = new JButton("Search");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Food food = dataBase.getFoodByName(textField.getText());
                if (food != null) {
                    label.setText(food.toString());
                } else {
                    label.setText("Food with name " + textField.getText() + " is not exist");
                }
            }
        });
    }
}
