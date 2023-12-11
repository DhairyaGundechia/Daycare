package edu.neu.csye6200.daycare.cronservice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailReminder{

    public static void emailService() throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://mail-sender-api1.p.rapidapi.com/"))
		.header("content-type", "application/json")
		.header("X-RapidAPI-Key", "6d5bef293cmshfc9814c90f2759ep10495fjsnda647fe638fd")
		.header("X-RapidAPI-Host", "mail-sender-api1.p.rapidapi.com")
		.method("POST", HttpRequest.BodyPublishers.ofString("{\r\n    \"sendto\": \"suhaskm23@gmail.com\",\r\n    \"ishtml\": \"false\",\r\n    \"title\": \"HELLO\",\r\n    \"body\": \"FROM THE OTHER SIDE / Text\"\r\n}"))
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void emailSender(){
        // Sender's email configuration

        // db fetch email and password
        final String senderEmail = "d07395123@gmail.com";
        final String senderPassword = "Neuinfo5100section2";

        // Recipient's email address
        String recipientEmail = "suhaskm23@gmail.com";

        // Email properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create a session with the email server
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderPassword);
                    }
                });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender's email address
            message.setFrom(new InternetAddress(senderEmail));

            // Set the recipient's email address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set the email subject
            message.setSubject("Daycare Account Created");

            // Set the email content
            message.setText("Hi,\n\n Your Account created. Your Password is  \n\n Thanks");

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}
