package com.everis.mscreditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

@Slf4j
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableKafka
@SpringBootApplication
public class MsCreditCardApplication {

	public static void main(String[] args) {
		boolean useSsl = true;
        String cacheHostname = "redis-cache-banking-jabmm.redis.cache.windows.net";
        String cachekey = "ylI1E3C9Mpp97MLoZvUUdUGKEmWSr5fjg+lNeTRAEmI=";

        // Connect to the Azure Cache for Redis over the TLS/SSL port using the key.
        JedisShardInfo shardInfo = new JedisShardInfo(cacheHostname, 6380, useSsl);
        shardInfo.setPassword(cachekey); /* Use your access key. */
        Jedis jedis = new Jedis(shardInfo);      

        // Perform cache operations using the cache connection object...

        // Simple PING command        
        log.info( "\nCache Command  : Ping" );
        log.info( "Cache Response : " + jedis.ping());

        // Simple get and put of integral data types into the cache
        log.info( "\nCache Command  : GET Message" );
        log.info( "Cache Response : " + jedis.get("Message"));

        log.info( "\nCache Command  : SET Message" );
        log.info( "Cache Response : " + jedis.set("Message", "Hello! The cache is working from Java!"));

        // Demonstrate "SET Message" executed as expected...
        log.info( "\nCache Command  : GET Message" );
        log.info( "Cache Response : " + jedis.get("Message"));

        // Get the client list, useful to see if connection list is growing...
        log.info( "\nCache Command  : CLIENT LIST" );
        log.info( "Cache Response : " + jedis.clientList());

        jedis.close();
        SpringApplication.run(MsCreditCardApplication.class, args);
	}

}
