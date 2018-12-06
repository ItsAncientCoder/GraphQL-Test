package com.test.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class StocktickerWebSocketConfig implements WebSocketConfigurer {

	@Autowired
	private StockTickerGraphqlPublisher stockTickerGraphqlPublisher;

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new StockTickerWebSocketHandler(stockTickerGraphqlPublisher), "/stockticker")
				.setAllowedOrigins("*");
	}
}
