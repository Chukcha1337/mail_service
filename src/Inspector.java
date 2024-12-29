public class Inspector implements MailService{

    @Override
    public Sendable processMail(Sendable mail) {
        try {
            if (mail instanceof MailPackage pack) {
                if (pack.getContent().getContent().contains("weapons") ||
                        pack.getContent().getContent().contains("banned substance")) {
                    throw new IllegalPackegeExeption();
                } else if (pack.getContent().getContent().contains("stones")) {
                    throw new StolenPackageException();
                }
            }
        } catch (IllegalPackegeExeption e) {
            System.out.println("Обнаружена запрещенная посылка");
        } catch (StolenPackageException e) {
            System.out.println("Обнаружена посылка, над которой поработал Thief");;
        }
        return mail;
    }
}
