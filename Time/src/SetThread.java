public class SetThread extends java.lang.Thread {
    private int id;
    private Time time;

    public SetThread(int id, Time time){
        this.id = id;
        this.time = time;

    }
    public void run() {
        while (true) {
            System.out.println("Thread " + id + ": " + time);
            time.increaseSecond();
            try {
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Time getTime() {
        return time;
    }

}