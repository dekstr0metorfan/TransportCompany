import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * This class is responsible for representing a graphical user interface
 */
public class GUI extends JFrame
{
    /**
     * Maximum number of days for which the simulation lasts
     */
    private int max_day;
    /**
     * Revenue modifier
     */
    private double revenue_mod;
    /**
     * Cost modifier
     */
    private double cost_mod;

    /**
     * Constructs a new GUI for the transport company simulation.
     */
    public GUI()
    {
        setSize(600,350);
        setTitle("Transport Company");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        newGUI();
    }

    /**
     * This method is responsible for setting up the components and layout of the GUI
     */
    public void newGUI()
    {

        JPanel centralPanel = new JPanel(new GridLayout(3,2,2,2));
        centralPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));

        JLabel lMaxDays = new JLabel("Max simulation time [days]: ");
        JTextField fMaxDays = new JTextField(5);

        centralPanel.add(lMaxDays);
        centralPanel.add(fMaxDays);

        JLabel lRevenue = new JLabel("Revenue modifier: ");
        JTextField fRevenue = new JTextField(5);

        centralPanel.add(lRevenue);
        centralPanel.add(fRevenue);

        JLabel lCost = new JLabel("Cost modifier: ");
        JTextField fCost = new JTextField(5);

        centralPanel.add(lCost);
        centralPanel.add(fCost);


        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel lHeader = new JLabel("Enter data for the simulation: ");
        lHeader.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton bSimulation = new JButton("Run Simulation");
        bSimulation.setAlignmentX(Component.CENTER_ALIGNMENT);

        bSimulation.addActionListener(e -> {
            max_day = Integer.parseInt(fMaxDays.getText());
            revenue_mod = Double.parseDouble(fRevenue.getText());
            cost_mod = Double.parseDouble(fCost.getText());

            Company company = new Company();
            try {
                company.simulation(max_day, revenue_mod, cost_mod);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            showMessageDialog(null, "Success.");
        });

        mainPanel.add(lHeader);
        mainPanel.add(centralPanel);
        mainPanel.add(bSimulation);

        setContentPane(mainPanel);
    }
}
