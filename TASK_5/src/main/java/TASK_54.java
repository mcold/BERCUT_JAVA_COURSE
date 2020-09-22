import java.io.*;
import java.util.Calendar;

/**
 * Программа WorkTracker
 * - Считает время, проведенное за работой
 * - Меню
 * * Start (трекер копит время работы)
 * * Pause (трекер не копит время работы)
 * * Status (трекер выводит наработку)
 * * Save (сериализует состояние трекера)
 * * Load (десериализует состояние трекера)
 */

public class TASK_54 {

    private static final String TRACK_BIN = "track.bin";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        WorkTracker wt = new WorkTracker();
        while(true) {
            Menu();
            BufferedReader console = new BufferedReader(new InputStreamReader((System.in)));
            String choice = console.readLine();
            if (choice.startsWith("1") || choice.toLowerCase().contains("start")) {
                System.out.println("Started!!!");
                wt.run();
            }

            if (choice.startsWith("2") || choice.toLowerCase().contains("pause")) {
                wt.pause();
            }

            if (choice.startsWith("3") || choice.toLowerCase().contains("status")) {
                wt.status();
            }

            if (choice.startsWith("4") || choice.toLowerCase().contains("save")) {
                save(wt);
            }

            if (choice.startsWith("5") || choice.toLowerCase().contains("load")) {
                wt = load();
            }

            if(choice.startsWith("6") || choice.toLowerCase().contains(("exit"))){
                System.exit(0);
            }
        }
    }

    public static void Menu(){
        System.out.println("MENU:");
        System.out.println("1: Start");
        System.out.println("2: Pause");
        System.out.println("3: Status");
        System.out.println("4: Save");
        System.out.println("5: Load");
        System.out.println("6: Exit");
        System.out.println("---------");
        System.out.println("Enter command: ");
    }


    public static WorkTracker load() throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TRACK_BIN))){
            WorkTracker wt = (WorkTracker)ois.readObject();
            System.out.println(wt);
            return wt;
        }
    }

    public static void save(WorkTracker wt) throws IOException {
        if(wt.bStopped == false) {
            wt.setCount();
            wt.setLastDate();
        }
        try(ObjectOutputStream oos = new ObjectOutputStream((new FileOutputStream(TRACK_BIN)))){
            oos.writeObject(wt);
        }
    }
}

class WorkTracker implements Serializable{
    static Integer time = 0;
    static boolean bStopped = true;
    static long lastDate = 0;
    static long count = 0;

    public WorkTracker(){
        bStopped = true;
    }

    public void run(){
        bStopped = false;
        if(bStopped == true){
            bStopped = false;
            setLastDate();
        }
        setLastDate();
        System.out.println(this);
    }

    public void pause(){
        bStopped = true;
        setCount();
        setLastDate();
        System.out.println(this);
    }

    public void status(){
        if(bStopped == false){
            setCount();
            setLastDate();
        }
        System.out.println("Time spent: " + count);
        System.out.println(this);
    }

    public static void setCount(){
        count = count + Calendar.getInstance().getTime().getTime() - lastDate;
    }

    public static void setLastDate(){
        lastDate = Calendar.getInstance().getTime().getTime();
    }

    @Override
    public String toString() {
        return "Stopped : " + String.valueOf(this.bStopped)
                + " lastDate : " + lastDate
                + " count : " + count;
    }
}