package com.example.driver.Config;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class FeignSSLIgnoreConfig {

    @Bean
    public Client feignClient() throws Exception {

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{
                new X509TrustManager() {
                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() { return new java.security.cert.X509Certificate[0]; }
                }
        }, new java.security.SecureRandom());

        // ✅ Reusing your InternalSSL return section
        SSLConnectionSocketFactory csf =
                new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        return new ApacheHttpClient(httpClient);
    }
}



