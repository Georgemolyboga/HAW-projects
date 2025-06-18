package drawingTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;

public class Buttons {
    private JButton generateButton = new JButton("Generate Pigs");
    private JButton colorButton = new JButton("Random Colors");
    private JButton clearButton = new JButton("Clear All");
    private JCheckBox randomSizeCheckBox = new JCheckBox("Random Sizes", true);
    private JSlider sizeSlider = new JSlider();
    private JTextField sizeInputField = new JTextField(5);

    public void addActionListener(ActionListener listener) {
        generateButton.addActionListener(listener);
        colorButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        randomSizeCheckBox.addActionListener(listener);
    }

    public void addChangeListener(ChangeListener listener) {
        sizeSlider.addChangeListener(listener);
    }

    public void addButtonsToAPanel(JFrame frame) {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(10, 1, 15, 20));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Generation controls
        controlPanel.add(createTitleLabel("Generation"));
        controlPanel.add(generateButton);
        controlPanel.add(clearButton);

        // Customization controls
        controlPanel.add(createTitleLabel("Customization"));
        controlPanel.add(colorButton);

        // Size controls
        controlPanel.add(createTitleLabel("Size Control"));
        controlPanel.add(randomSizeCheckBox);
        controlPanel.add(createSizeInputPanel());

        frame.add(controlPanel, BorderLayout.WEST);
    }

    private JPanel createSizeInputPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Size:"));
        panel.add(sizeInputField);
        return panel;
    }

    private JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        return label;
    }

    // Getters
    public JButton getGenerateButton() { return generateButton; }
    public JButton getColorButton() { return colorButton; }
    public JButton getClearButton() { return clearButton; }
    public JCheckBox getRandomSizeCheckBox() { return randomSizeCheckBox; }
    public JSlider getSizeSlider() { return sizeSlider; }
    public JTextField getSizeInputField() { return sizeInputField; }
}