import java.awt.*;
import java.awt.event.*;

public class j extends Frame implements ActionListener {
    TextField text = new TextField();
    TextField red = new TextField();
    TextField gr = new TextField();
    TextField blue = new TextField();
    Button b1 = new Button("Apply");
    String str = "hello";
    int size = 10;
    Font f;
    Boolean inc = true;
    int r, g, b;
    Color fcolor = Color.BLACK;

    public j() {
        setTitle("Font Animation");
        setSize(400, 300);
        setLayout(new FlowLayout());

        add(new Label("Enter text to animate here"));
        add(text);
        add(new Label("Enter value for red color here"));
        add(red);
        red.setText("0");
        add(new Label("Enter value for green color here"));
        add(gr);
        gr.setText("0");
        add(new Label("Enter value for blue color here"));
        add(blue);
        blue.setText("0");
        add(b1);

        b1.addActionListener(this);

        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            str = text.getText();
            if (str.equals("")) str = "hello";
            try {
                r = Integer.parseInt(red.getText());
                g = Integer.parseInt(gr.getText());
                b = Integer.parseInt(blue.getText());
                fcolor = new Color(r, g, b);
            } catch (NumberFormatException ex) {
                fcolor = Color.BLACK; // Default to black on invalid input
            }
            repaint();
        }
    }

    public void paint(Graphics g) {
        f = new Font("Arial", Font.BOLD, size);
        g.setFont(f);
        g.setColor(fcolor);
        g.drawString(str, 50, 200);

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (inc) {
            size += 10;
            if (size == 100) inc = false;
        } else {
            size -= 10;
            if (size == 10) inc = true;
        }
        repaint();
    }

    public static void main(String[] args) {
        new j();
    }
}
