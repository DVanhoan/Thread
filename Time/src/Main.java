import javax.swing.*;
import java.time.Clock;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            ClockGui clockGui = new ClockGui();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}