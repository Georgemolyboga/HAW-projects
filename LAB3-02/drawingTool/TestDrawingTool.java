package drawingTool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class TestDrawingTool extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;
    private final ControlPanel controlPanel;
    private final DrawingArea drawingArea;
    private static final int DEFAULT_PIG_SIZE = 200; // Default size value
    private static final int DEFAULT_PIG_COUNT = 5;  // Default pig count

    public TestDrawingTool(String title) {
        super(title);
        setLayout(new BorderLayout());
        Dimension screen = getToolkit().getScreenSize();
        
        drawingArea = new DrawingArea(screen.width, (int) (screen.height * 0.7));
        controlPanel = new ControlPanel();
        controlPanel.setBackground(Color.CYAN);
        controlPanel.setPreferredSize(new Dimension(screen.width, (int) (screen.height * 0.3)));
        
        // Initialize control panel with default values
        controlPanel.initialise(DEFAULT_PIG_SIZE, DEFAULT_PIG_COUNT);
        
        controlPanel.getGenerateButton().addActionListener(this);
        controlPanel.getClearButton().addActionListener(this);
        
        add(controlPanel, BorderLayout.SOUTH);
        add(drawingArea, BorderLayout.CENTER);
        setBounds(0, 0, screen.width, screen.height);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
        // Automatically generate pigs with default values on startup
        generatePigsWithCurrentSettings();
    }

    private void generatePigsWithCurrentSettings() {
        int amount = controlPanel.getAttempts();
        int size = controlPanel.getPigSize();
        int shirtState = controlPanel.getComboBoxState();
        
        drawingArea.getScene().setPigSize(size);
        drawingArea.getScene().updatePigs(amount, shirtState);
        drawingArea.repaint();
    }

    public static void main(String[] args) {
        new TestDrawingTool("My Pig");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == controlPanel.getClearButton()) {
            drawingArea.getScene().clear();
            drawingArea.repaint();
        }

        if (e.getSource() == controlPanel.getGenerateButton()) {
            generatePigsWithCurrentSettings();
        }
    }
}