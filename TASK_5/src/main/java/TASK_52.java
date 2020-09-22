import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Программа копирования файла – на входе 2 аргумента
 * Полное (с путём) имя копируемого файла
 * Полное имя файла, в который будет скопирован 1 файл
 * подсказка: использовать fis, fos
 */
public class TASK_52 {

    public static void main(String[] args) {
        try(
                FileInputStream fis = new FileInputStream(args[0]);
                FileOutputStream fos = new FileOutputStream(args[1]);
            ){
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer, 0, buffer.length);
                fos.write(buffer, 0, buffer.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
