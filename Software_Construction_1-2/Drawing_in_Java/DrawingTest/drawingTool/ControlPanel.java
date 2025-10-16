package drawingTool;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel extends JPanel implements ChangeListener, ActionListener{

	private JLabel unitsNumberLabel, sizeLabel, comboLabel, colorLabel;
	private JSlider unitsNumberSlider;
	private JTextField sizeField;
	private JComboBox<String> comboBox;
	private JButton generate, clear, randomizeColor;
    private DrawingArea drawingArea;
    
    public ControlPanel(DrawingArea drawingArea) {
        this.drawingArea = drawingArea;                   
    }
	
	public void initialise() {

		setLayout(new GridLayout(2, 5, 10, 10));
		
		colorLabel = new JLabel("Randomize the color of the Pig");
		
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
		
		String[] options = {"Random", "With shirt", "With sunglasses", "Both", "No decoration"};
        comboLabel = new JLabel("Decoration type:");
        comboBox = new JComboBox<>(options);
        
        generate = new JButton("Generate Pigs");
        clear = new JButton("Clear the field");
        randomizeColor = new JButton("Randomize Pig Colors");
        
        colorLabel.setHorizontalAlignment(JLabel.CENTER);
        colorLabel.setVerticalAlignment(JLabel.CENTER);

		unitsNumberLabel.setText("Attempts to generate Pigs: " + unitsNumberSlider.getValue());
		
		unitsNumberLabel.setHorizontalAlignment(JLabel.CENTER);
	    unitsNumberLabel.setVerticalAlignment(JLabel.CENTER);
	    
	    sizeLabel.setHorizontalAlignment(JLabel.CENTER);
	    sizeLabel.setVerticalAlignment(JLabel.CENTER);
	    
	    comboLabel.setHorizontalAlignment(JLabel.CENTER);
	    comboLabel.setVerticalAlignment(JLabel.CENTER);
	    
	    sizeField.setMaximumSize(new Dimension(100, sizeField.getPreferredSize().height));
	    
	    getGenerateButton().addActionListener(this);
        getClearButton().addActionListener(this);
        getColorButton().addActionListener(this);
        
		
		// Add the label, slider, and input field to the control panel at the specified positions
	    add(unitsNumberLabel);  
	    add(sizeLabel);    
	    add(comboLabel);
	    add(colorLabel);
	    add(generate); 
	    
	    add(unitsNumberSlider); 
	    add(sizeField);    
	    add(comboBox);
	    add(randomizeColor);
	    add(clear); 
	}
	
	public JButton getGenerateButton() {
        return generate;
    }
	
	public JButton getClearButton() {
        return clear;
    }
	
	public JButton getColorButton() {
		return randomizeColor;
	}

    public int getComboBoxState() {
    	
        int index = comboBox.getSelectedIndex();
        return (index >= 0 && index <= 4) ? index : 0;  // fallback to Random
     }

    public int getAttempts() {
        return unitsNumberSlider.getValue();
    }
    
    public int getPigSize() {
    	
        String text = sizeField.getText().trim();
        
        System.out.print(text + "\n");
	        
        	try {
	            int string = Integer.parseInt(text);
	            
	            if (string < 50 || string > 200) {
	                throw new NumberFormatException("out of range");
	            }
	            return string;
	            
	        } 
	        
	        catch (NumberFormatException event) {
	        	
	            JOptionPane.showMessageDialog(this, "Please enter an integer between 50 and 200.", "Invalid size", JOptionPane.ERROR_MESSAGE);
	            return -1;                 // tells caller that the input is bad
	            
	        }  
    }
    

	public void stateChanged(ChangeEvent e) {
		
		unitsNumberLabel.setText("Attempts to generate Pigs: " + unitsNumberSlider.getValue());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == getClearButton()) {
		    		
		    		drawingArea.getScene().clear();
		            drawingArea.repaint();
		    	}
		
        if (e.getSource() == getGenerateButton()) {
            int amount = getAttempts();
            int size   = getPigSize();   

            if (size == -1) {                         
                return;
            }
            
            int shirtState = getComboBoxState();
            
            drawingArea.getScene().setPigSize(size);  
            drawingArea.getScene().updatePigs(amount, shirtState);
            
            drawingArea.revalidate();
            drawingArea.repaint();
        }
        
        if (e.getSource() == getColorButton()) {
        	
        	int amount = getAttempts();
            int size   = getPigSize();   

            if (size == -1) {                         
                return;
            }
            
            int shirtState = getComboBoxState();
        	
        	drawingArea.getScene().setPigSize(size);  
        	drawingArea.getScene().randomizeColors(amount, shirtState);
        	
        	drawingArea.revalidate();
            drawingArea.repaint();
        }
		
	}
}
