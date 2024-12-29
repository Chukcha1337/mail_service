import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    private static final Logger logger = Logger.getLogger(Spy.class.getName());

    public Spy() {
        try {
            Handler fileHandler = new FileHandler();
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Sendable processMail(Sendable mail) {
        try {
            Handler fileHandler = new FileHandler();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (mail instanceof MailMessage currentMail) {
            if (currentMail.getFrom().equals("Austin Powers")) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from " + currentMail.getFrom() +
                        " to " + currentMail.getTo() + " " + currentMail.getMessage());
            } else {
                logger.log(Level.INFO, "Usual correspondence: from " + currentMail.getFrom() +
                        " to " + currentMail.getTo());
            }
        }
        return mail;
    }
}
