/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt sendTo change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java sendTo edit this template
 */
package Business.Utility;

import Business.UserAccount.UserAccount;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author sushmithaprathap
 */
public class EmailClass {

    public static void sendEmailFunc(String emailId, UserAccount userAcc) {
// Recipient's email ID needs sendTo be mentioned.
        String sendTo = emailId;
        String sendFrom = "harshitaranganath25@gmail.com";
        String password = "swbckqewbesptajn";
// Assuming you are sending email sendFrom localhost
// String hostName = "192.168.0.16";

// Get system properties
        Properties properties = System.getProperties();
        String hostName = "smtp.gmail.com";

        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.ssl.trust", hostName);
        properties.put("mail.smtp.user", sendFrom);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

// Setup mail server
        properties.setProperty("mail.smtp.host", hostName);
        properties.put("mail.smtp.starttls.enable", "true");
// Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
// Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

// Set From: header field of the header.
            message.setFrom(new InternetAddress(sendFrom));

// Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));

// Set Subject: header field
            message.setSubject("User Account Registration");
            message.setText("Congratulation! Your account is created. Username: "
                    + userAcc.getUsername() + " Password: " + userAcc.getPassword()
                    + " Please login to your account.");
// Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(hostName, sendFrom, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid email id");
        }
    }

    public static void sendEmailAppointmentFunc(String emailId, UserAccount userAcc, String stat) {
// Recipient's email ID needs sendTo be mentioned.
        String sendTo = emailId;
        String sendFrom = "harshitaranganath25@gmail.com";
        String password = "swbckqewbesptajn";
// Assuming that you are sending email sendFrom localhost
// String hostName = "192.168.0.16";

// Get system properties
        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";

        properties.put("mail.smtp.starttls.enable", "true");

        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", sendFrom);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

// Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.starttls.enable", "true");
// Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
// Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

// Set From: header field of the header.
            message.setFrom(new InternetAddress(sendFrom));

// Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));

// Set Subject: header field
            message.setSubject("Appointment Booking Successful");
            message.setText(stat + " Username: "
                    + userAcc.getUsername() + " Password: " + userAcc.getPassword()
                    + " Please login to your account.");
// Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, sendFrom, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid email id");
        }
    }

    public static void sendTextMessageFunc(String contact) {
        // Recipient's email ID needs sendTo be mentioned.
        String sendTo = contact;
        System.out.println(contact);
        String sendFrom = "harshitaranganath25@gmail.com";
        String pass = "swbckqewbesptajn";
        // Assuming you are sending email sendFrom localhost
        // String hostName = "192.168.0.16";
        // Get system properties
        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", sendFrom);
        properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        //was comented starttls
        properties.put("mail.smtp.starttls.enable", "true");
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(sendFrom));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));

            // Set Subject: header field
            message.setSubject("User Account Registration");
            message.setText("Congratulation! You have registered with us. Login details are sent to your email.");
            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, sendFrom, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("User : Text message sent successfully!!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SMS not sent, Phone Number is wrong.");
        }
    }

    public static void sendTextAppointmentFunc(String contact, UserAccount userAcc, String stat) {
        // Recipient's email ID needs to be mentioned.
        String sendTo = contact;
        System.out.println(contact);
        String sendFrom = "harshitaranganath25@gmail.com";
        String paasword = "swbckqewbesptajn";
        // Assuming you are sending email from localhost
        // String hostName = "192.168.0.16";
        // Get system properties
        Properties properties = System.getProperties();
        String host = "smtp.gmail.com";
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.user", sendFrom);
        properties.put("mail.smtp.password", paasword);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        //was comented starttls
        properties.put("mail.smtp.starttls.enable", "true");
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(sendFrom));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));

            // Set Subject: header field
            message.setSubject("Appointment Booking Successful!");
            message.setText(stat + " Username: "
                    + userAcc.getUsername() + " Password: " + userAcc.getPassword()
                    + " Please login to your account to view more.");
            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, sendFrom, paasword);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("User : Text message sent successfully!!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SMS not sent, Phone number is wrong");
        }
    }

    public Boolean contactValidity(String custContact) {
        String exp = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        Pattern pattern = Pattern.compile(exp);

        Matcher matcher = pattern.matcher(custContact);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
