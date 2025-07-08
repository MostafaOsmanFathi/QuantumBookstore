package com.FawryRiseJourney.model.Mail;

public class PseudoMailServiceProvider implements MailInterface {
    private static PseudoMailServiceProvider pseudoMailServiceProvider;

    public static PseudoMailServiceProvider getPseudoMailServiceProvider() {
        if (pseudoMailServiceProvider == null) {
            pseudoMailServiceProvider = new PseudoMailServiceProvider();
        }
        return pseudoMailServiceProvider;
    }

    private PseudoMailServiceProvider() {

    }

    @Override
    public boolean sendMailBuyEmail(String targetEmail, String Content) {
        System.out.println("Sending mail to " + targetEmail);
        System.out.println("Content: " + Content);
        return true;
    }
}
