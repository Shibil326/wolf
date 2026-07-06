
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * DigitalClock.java
 * A simple working digital clock built with Java Swing.
 * It updates every second and shows the current date and time.
 */
public class DigitalClock extends JFrame {

    private final JLabel timeLabel;
    private final JLabel dateLabel;
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");

    public DigitalClock() {
        setTitle("Java Digital Clock");
        setSize(420, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);

        timeLabel = new JLabel();
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setFont(new Font("Consolas", Font.BOLD, 60));
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        dateLabel = new JLabel();
        dateLabel.setForeground(Color.LIGHT_GRAY);
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());
        panel.add(timeLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(dateLabel);
        panel.add(Box.createVerticalGlue());

        add(panel);

        updateClock();

        // Timer fires every 1000 ms (1 second) to refresh the displayed time
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();
    }

    private void updateClock() {
        LocalDateTime now = LocalDateTime.now();
        timeLabel.setText(now.format(timeFormatter));
        dateLabel.setText(now.format(dateFormatter));
    }

    public static void main(String[] args) {
        // Run the GUI on Swing's event dispatch thread
        SwingUtilities.invokeLater(() -> {
            DigitalClock clock = new DigitalClock();
            clock.setVisible(true);
        });
    }
}
