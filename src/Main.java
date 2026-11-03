// Тема 8. Чат двух пользователей.
// Два пользователя одновременно отправляют сообщения в консоль,
// поэтому их сообщения перемешиваются.
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Чат запущен ===");

        // Сообщения первого пользователя
        String[] aliMessages = {
                "Привет!",
                "Как дела?",
                "Ты сделал задание по Java?",
                "Отлично, до завтра!"
        };

        // Сообщения второго пользователя
        String[] dinaMessages = {
                "Привет, Али!",
                "Хорошо, спасибо.",
                "Да, тема про потоки.",
                "Пока!"
        };

        // Создаём задачу (Runnable) для каждого пользователя
        ChatUserTask aliTask = new ChatUserTask(aliMessages, 500);
        ChatUserTask dinaTask = new ChatUserTask(dinaMessages, 700);

        // Создаём потоки и даём им имена — имя потока = имя отправителя
        Thread aliThread = new Thread(aliTask, "Али");
        Thread dinaThread = new Thread(dinaTask, "Дина");

        // start() запускает новый поток, который сам вызовет run()
        aliThread.start();
        dinaThread.start();

        // join() — главный поток ждёт, пока оба пользователя закончат
        try {
            aliThread.join();
            dinaThread.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван");
        }

        System.out.println("=== Все потоки завершены. Чат закрыт ===");
    }
}
