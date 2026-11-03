// Задача одного пользователя чата.
// Реализует интерфейс Runnable — код, который будет выполняться в отдельном потоке.
public class ChatUserTask implements Runnable {

    private String[] messages; // сообщения, которые отправит пользователь
    private int delay;         // пауза между сообщениями (в миллисекундах)

    public ChatUserTask(String[] messages, int delay) {
        this.messages = messages;
        this.delay = delay;
    }

    // Метод run() — то, что делает поток после вызова start()
    @Override
    public void run() {
        // getName() возвращает имя текущего потока = имя пользователя
        String userName = Thread.currentThread().getName();
        System.out.println(">>> " + userName + ": вход в чат");

        for (int i = 0; i < messages.length; i++) {
            System.out.println("[" + userName + "]: " + messages[i]);
            try {
                Thread.sleep(delay); // пауза — имитация набора следующего сообщения
            } catch (InterruptedException e) {
                System.out.println(userName + " был прерван");
            }
        }

        System.out.println("<<< " + userName + ": выход из чата");
    }
}
