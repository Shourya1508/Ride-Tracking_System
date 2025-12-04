package com.example.ride.Config;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.security.KeyStore;

@Configuration
public class InternalFeignSslConfig {

    @Bean(name = "internalFeignClient")
    public Client internalFeignClient() throws Exception {
        String keyStorePassword = "changeit";

        // Load KeyStore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream keyStoreStream = new ClassPathResource("certificates/ride-service.jks").getInputStream()) {
            keyStore.load(keyStoreStream, keyStorePassword.toCharArray());
        }

        // Load TrustStore
        KeyStore trustStore = KeyStore.getInstance("JKS");
        try (InputStream trustStoreStream = new ClassPathResource("certificates/ride-service-truststore.jks").getInputStream()) {
            trustStore.load(trustStoreStream, keyStorePassword.toCharArray());
        }

        // Build SSLContext
        SSLContext sslContext = SSLContextBuilder.create()
                .loadKeyMaterial(keyStore, keyStorePassword.toCharArray())
                .loadTrustMaterial(trustStore, null)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        return new ApacheHttpClient(httpClient);
    }
}











//package com.example.ride.Config;
//
//import feign.Client;
//import feign.httpclient.ApacheHttpClient;
//
//import java.io.File;
//
//import javax.net.ssl.SSLContext;
//
//import org.apache.http.conn.ssl.NoopHostnameVerifier;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.ssl.SSLContextBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FeignSslConfig {
//
//    @Bean
//    public Client feignClient() throws Exception {
//        SSLContext sslContext = SSLContextBuilder.create()
//                .loadKeyMaterial(
//                        new File("src/main/resources/certificates/ride-service.jks"),
//                        "changeit".toCharArray(),
//                        "changeit".toCharArray())
//                .loadTrustMaterial(
//                        new File("src/main/resources/certificates/ride-service-truststore.jks"),
//                        "changeit".toCharArray())
//                .build();
//
//        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
//
//        CloseableHttpClient httpClient = HttpClients.custom()
//                .setSSLSocketFactory(csf)
//                .build();
//
//        return new ApacheHttpClient(httpClient);
//    }
//}
