import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller implements ActionListener {
    ClockGui clockGui;
    public Controller(ClockGui clockGui){
        this.clockGui = clockGui;
        Start();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==clockGui.btn){
            String date = clockGui.txt.getText();
            ClockGui clock1 = new ClockGui(clockGui.txt.getText());
            clock1.label.setText(date);
        }
    }

    public void Start(){
        new Thread(()->{
            while (true){
                Time();
                System.out.println("Thread " + clockGui.id + ": " + clockGui.label.getText());
                try {
                    java.lang.Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }).start();
    }

    private void Time() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        clockGui.label.setText(dateFormat.format(new Date()));
    }

    public void setTime(String strTime) {
        clockGui.label.setText(strTime);
    }
}
