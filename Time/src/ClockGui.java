import javax.swing.*;
import java.awt.*;

public class ClockGui extends JFrame {
    public int id = 1;
    public JLabel label;
    public JTextArea txt;
    public JButton btn;
    private String strTime;
    Controller ac = new Controller(this);
    public ClockGui(){
        init();
        ac.Start();
    }

    public ClockGui(String strTime){
        this.strTime = strTime;
        init();
        SetThread thread = new SetThread(id++, new Time(strTime));
        thread.start();

        new Thread(()->{
            while(true) {
                ac.setTime(thread.getTime().toString());
            }

        }).start();
    }



    public void init(){
        setTitle("Clock");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        Font font = new Font("Bogart", Font.BOLD, 20);
        label = new JLabel("");
        label.setFont(font);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setLayout(new GridLayout(1,2));
        txt = new JTextArea();
        txt.setFont(font);
        btn = new JButton("Click me");
        btn.setFont(font);
        btn.addActionListener(ac);
        south.add(txt);
        south.add(btn);

        add(south, BorderLayout.SOUTH);
        setVisible(true);
    }
}
