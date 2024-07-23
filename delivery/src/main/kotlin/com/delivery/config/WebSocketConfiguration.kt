package com.delivery.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.config.annotation.*

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfiguration : WebSocketMessageBrokerConfigurer {
    companion object {
        private const val ENDPOINT = "/hello-websocket-chatting"
        private const val SIMPLE_BROKER = "/topic"
        private const val PUBLISH = "/app"
    }
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableSimpleBroker(SIMPLE_BROKER)
        registry.setApplicationDestinationPrefixes(PUBLISH)
    }
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint(ENDPOINT)
            .setAllowedOrigins("*")
    }
}