package drawingTool;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel extends JPanel implements ChangeListener{

	private JLabel unitsNumberLabel, sizeLabel, comboLabel;
	private JSlider unitsNumberSlider;
	private JTextField sizeField;
	private JComboBox<String> comboBox;
	private JButton generate, clear;
	
	public void initialise() {
		
		setLayout(new GridLayout(2, 4, 10, 10));
		
		unitsNumberLabel = new JLabel("Attempts to generate Pigs");
		unitsNumberSlider = new JSlider(0, 100, 10);
		
		sizeLabel = new JLabel("Size of the generated Pigs (min 50 - max 200)");
		sizeField = new JTextField("100");
		
		unitsNumberSlider.setPaintTrack(true);
		unitsNumberSlider.setPaintTicks(true);
		unitsNumberSlider.setPaintLabels(true);
		unitsNumberSlider.setMajorTickSpacing(20);
		//unitsNumberSlider.setMinorTickSpacing(10);
		unitsNumberSlider.addChangeListener(this);
		
		String[] options = {"Random", "With shirt", "Without shirt"};
        comboLabel = new JLabel("Pig type:");
        comboBox = new JComboBox<>(options);
        
        generate = new JButton("Generate Pigs");
        clear = new JButton("Clear the field");

		unitsNumberLabel.setText("Attempts to generate Pigs: " + unitsNumberSlider.getValue());
		
		unitsNumberLabel.setHorizontalAlignment(JLabel.CENTER);
	    unitsNumberLabel.setVerticalAlignment(JLabel.CENTER);
	    
	    sizeLabel.setHorizontalAlignment(JLabel.CENTER);
	    sizeLabel.setVerticalAlignment(JLabel.CENTER);
	    
	    comboLabel.setHorizontalAlignment(JLabel.CENTER);
	    comboLabel.setVerticalAlignment(JLabel.CENTER);
	    
	    sizeField.setMaximumSize(new Dimension(100, sizeField.getPreferredSize().height));
		
		// Add the label, slider, and input field to the control panel at the specified positions
	    super.add(unitsNumberLabel);  
	    super.add(sizeLabel);    
	    super.add(comboLabel);    
	    super.add(generate); 
	    
	    super.add(unitsNumberSlider); 
	    super.add(sizeField);    
	    super.add(comboBox);
	    super.add(clear); 
	    
	}
	
	public JButton getGenerateButton() {
        return generate;
    }
	
	public JButton getClearButton() {
        return clear;
    }

    public int getComboBoxState() {
    	
        int index = comboBox.getSelectedIndex();
        return (index >= 0 && index <= 2) ? index : 0;  // fallback to Random
     }

    public int getAttempts() {
        return unitsNumberSlider.getValue();
    }
    
    public int getPigSize() {
        String txt = sizeField.getText().trim();
        try {
            int string = Integer.parseInt(txt);
            if (string < 50 || string > 200) {
                throw new NumberFormatException("out of range");
            }
            return string;
            
        } 
        
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter an integer between 50 and 300.",
                    "Invalid size",
                    JOptionPane.ERROR_MESSAGE);
            return -1;                 // tells caller that the input is bad
        }
    }
    

	public void stateChanged(ChangeEvent e) {
		
		unitsNumberLabel.setText("Attempts to generate Pigs: " + unitsNumberSlider.getValue());
	}
}
