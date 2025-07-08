package com.FawryRiseJourney.Mail;

public class PseudoMailServiceProvider implements MailInterface {

    @Override
    public boolean sendMailBuyEmail(String targetEmail, String Content) {
        System.out.println("Sending mail to " + targetEmail);
        System.out.println("Content: " + Content);
        return true;
    }
}
