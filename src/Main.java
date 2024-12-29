import java.util.LinkedList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws Exception {
        List<Sendable> sendables = new LinkedList();
        Sendable message1 = new MailMessage("Ivan","Alexey","Privet");
        Sendable message2 = new MailPackage("Ivan","Alexey",new Package("Pivo",30));
        Sendable message3 = new MailMessage("Austin Powers","Alexey","Я люблю пиво");
        Sendable message4 = new MailPackage("Ivan","Alexey",new Package("Деньги",400));
        Sendable message5 = new MailMessage("Даниил","Роберт Рождественский","Ogo!");
        Sendable message6 = new MailPackage("Ivan","Alexey",new Package("weapons",400));

        sendables.add(message1);
        sendables.add(message2);
        sendables.add(message3);
        sendables.add(message4);
        sendables.add(message5);
        sendables.add(message6);

        MailService[] mailServices = new MailService[3];
        mailServices[0] = new Spy();
        mailServices[1] = new Thief(200);
        mailServices[2] = new Inspector();


        MailService brodyaga = new UntrustworthyMailWorker(mailServices);
        for (Sendable sendable : sendables) {
            brodyaga.processMail(sendable);
        }










    }

}