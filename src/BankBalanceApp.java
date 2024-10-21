import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApp {
    private double balance = 0.0;
    private JFrame frame;
    private JPanel panel;
    private JTextField inputField;
    private JTextArea displayArea;

    public BankBalanceApp() {
        frame = new JFrame("Bank Balance Application");
        panel = new JPanel();
        inputField = new JTextField(10);
        displayArea = new JTextArea(5, 20);
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton showBalanceButton = new JButton("Show Balance");

        displayArea.setEditable(false);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        showBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showBalance();
            }
        });

        panel.add(new JLabel("Amount:"));
        panel.add(inputField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(showBalanceButton);
        panel.add(new JScrollPane(displayArea));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void deposit() {
        try {
            double amount = Double.parseDouble(inputField.getText());
            balance += amount;
            displayArea.append("Deposited: $" + amount + "\n");
            inputField.setText("");
        } catch (NumberFormatException e) {
            displayArea.append("Invalid input. Please enter a number.\n");
        }
    }

    private void withdraw() {
        try {
            double amount = Double.parseDouble(inputField.getText());
            if (amount <= balance) {
                balance -= amount;
                displayArea.append("Withdrew: $" + amount + "\n");
            } else {
                displayArea.append("Insufficient funds.\n");
            }
            inputField.setText("");
        } catch (NumberFormatException e) {
            displayArea.append("Invalid input. Please enter a number.\n");
        }
    }

    private void showBalance() {
        displayArea.append("Current Balance: $" + balance + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankBalanceApp::new);
    }
}
