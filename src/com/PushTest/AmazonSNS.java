package com.PushTest;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

/**
 * Created by fpileggi on 7/26/16.
 */
public class AmazonSNS {
    public static String awsAccessKey = "AKIAIDHXE2V6C6VWPH2Q";
    public static String awsSecretKey = "t70IpgrNiQ3QYpRtTpNxHdstxAvyDe1j9yXd";
    public static String iOsAppArn = "arn:aws:sns:us-west-2:263203416749:app/GCM/TesteProduceAndroid";
    public static String androidAppArn = "arn:aws:sns:us-west-2:26320416749:app/GCM/TesteProduceAndroid";

    public String subscribeDevice(String token, String platform) {
        AmazonSNSClient snsClient = new AmazonSNSClient(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
        snsClient.setRegion(Region.getRegion(Regions.US_WEST_2));

        CreatePlatformEndpointRequest request = new CreatePlatformEndpointRequest();
        request.setPlatformApplicationArn(platform);
        request.setToken(token);
        CreatePlatformEndpointResult result = snsClient.createPlatformEndpoint(request);

        return result.getEndpointArn();
    }

    public void sendMessage(String message, String endpointArn) {
        AmazonSNSClient snsClient = new AmazonSNSClient(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
        snsClient.setRegion(Region.getRegion(Regions.US_WEST_2));

        PublishRequest request = new PublishRequest();
        request.setTargetArn(endpointArn);
        request.setMessage(message);
        PublishResult publishResult = snsClient.publish(request);

        System.out.println("MessageId - " + publishResult.getMessageId());
    }
}
