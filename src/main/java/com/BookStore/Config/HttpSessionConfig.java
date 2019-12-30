package com.BookStore.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession

public class HttpSessionConfig {
	//newly Added
	@Bean
public static ConfigureRedisAction configureRedisAction() {
	return ConfigureRedisAction.NO_OP;
	}
@Bean
public LettuceConnectionFactory connectionFactory()
{
	return new LettuceConnectionFactory();
}
}
