public class Thief implements MailService {
    private int minimalCost;
    private int totalStolen;

    public Thief(int minimalCost) {
        this.minimalCost = minimalCost;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage pack && pack.getContent().getPrice() > minimalCost) {
            Sendable differentMail = new MailPackage(mail.getFrom(), mail.getTo(),
                    new Package("stones instead of " + pack.getContent().getContent(), 0));
            totalStolen += pack.getContent().getPrice();
            return differentMail;
        }
        return mail;
    }

    public int getStolenValue() {
        return totalStolen;
    }
}
