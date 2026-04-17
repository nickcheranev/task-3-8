package ru.diasoft.ncheranev.otus.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageChannel;
import ru.diasoft.ncheranev.otus.util.TransformUtil;
import ru.diasoft.ncheranev.otus.web.dto.CommentDto;

import java.util.concurrent.CompletableFuture;

@Configuration
@IntegrationComponentScan
public class IntegrationConfig {
    @Bean
    @Qualifier("inputCommentChannel")
    public MessageChannel inputCommentChannel() {
        return new DirectChannel();
    }

    @Bean
    @Qualifier("persistingCommentChannel")
    public MessageChannel outputChannel() {
        return new QueueChannel();
    }

    @Bean
    public IntegrationFlow inputCommentFlow() {
        return IntegrationFlow
                .from("inputCommentChannel")
                .transform(TransformUtil::toEntity)
                .channel("persistingCommentChannel")
                .get();
    }

    @Bean
    public IntegrationFlow persistingCommentFlow() {
        return IntegrationFlow
                .from("persistingCommentChannel")
                .handle("persistingCommentService", "save")
                .transform(TransformUtil::toDto)
                .get();
    }

    @MessagingGateway
    public interface CommentGateway {
        @Gateway(requestChannel = "inputCommentChannel")
        CompletableFuture<CommentDto> create(CommentDto commentDto);
    }
}
