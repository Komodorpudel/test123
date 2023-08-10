package uebung07_sub_4P.A31_A32;

// package blatt07;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
public class TitleChanger_copy extends JFrame {
public TitleChanger_copy() {
super("TitleChanger");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLayout(new GridLayout(0, 2));
for (int i = 1; i <= 4; i++) {
JButton temp = new JButton("Button " + i);
temp.addActionListener(e -> {
JButton source = (JButton) e.getSource();
setTitle("Title changed by " + source.getText());
});
add(temp);
}
setSize(350, 100);
setVisible(true);
}
public static void main(String[] args) {
new TitleChanger_copy();
}
}