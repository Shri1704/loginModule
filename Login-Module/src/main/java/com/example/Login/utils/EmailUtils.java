package com.example.Login.utils;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class EmailUtils {
    public static void sendMail( EmailSenderDto emailSenderDto){
        try{
        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;
        client = new MailjetClient("34e2ffab0fbb53562d9d65e0863628e7"/*System.getenv("34e2ffab0fbb53562d9d65e0863628e7")*/,"ab388ac90d6be15c6cce67f17d511caf"/* System.getenv("ab388ac90d6be15c6cce67f17d511caf")*/, new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "fjzgtyzbdeebyctvxd@mrvpm.net")
                                        .put("Name", "testing_statistics"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", emailSenderDto.getEmailTo())
                                                .put("Name", emailSenderDto.getEmailName())))
                                .put(Emailv31.Message.SUBJECT, emailSenderDto.getEmailSubject())
                                .put(Emailv31.Message.TEXTPART, emailSenderDto.getEmailBody())));
                                //.put(Emailv31.Message.HTMLPART, "<h3>Dear passenger 1, welcome to <a href='https://www.mailjet.com/'>Mailjet</a>!</h3><br />May the delivery force be with you!")
                                //.put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));
        response = client.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());}catch (Exception e){
            e.printStackTrace();
        }
    }
}
