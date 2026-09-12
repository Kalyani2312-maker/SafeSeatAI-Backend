package com.safeseatai.safeseat_ai.service;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

    public void sendSms(
            String mobileNumber,
            String studentName,
            String busNumber,
            String alertMessage) {

        System.out.println();
        System.out.println("========================================");
        System.out.println("       SAFESEAT AI SMS DEMO");
        System.out.println("========================================");

        System.out.println("To Mobile : " + mobileNumber);
        System.out.println("Student   : " + studentName);
        System.out.println("Bus       : " + busNumber);
        System.out.println("Message   : " + alertMessage);

        System.out.println("----------------------------------------");
        System.out.println("Parent/Teacher Notification : SENT");
        System.out.println("Mode : DEMO (₹0)");
        System.out.println("========================================");
        System.out.println();
    }
}