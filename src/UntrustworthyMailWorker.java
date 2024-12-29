public class UntrustworthyMailWorker implements MailService {
    MailService[] mailServices;
    RealMailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable result = mail;
        for (MailService mailService : mailServices) {
            result = mailService.processMail(result);
        }
        return realMailService.processMail(result);
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}
