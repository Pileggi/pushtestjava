package com.PushTest;

public class Main {

    public static void main(String[] args) {
        AmazonSNS sns = new AmazonSNS();
        String deviceAmazonToken = sns.subscribeDevice("eqwZh6dZ4PA:APA91bHIRniRjGQSiwWwsaY4siPf3iFgQwDW_b6-l2uL4FEV1SSPzW8a2GHLIhEYuWpR7od_QgVlbxnS4FPAuKJsA4KQoTtPeW3cvaDr1Zbjkr84POc-MpQr40OOQdRhgbd5upcyhAqN", sns.androidAppArn);
        System.out.println("Token: " + deviceAmazonToken );

        sns.sendMessage("Olá Mundo!", deviceAmazonToken);
    }
}
