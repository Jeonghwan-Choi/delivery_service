package controller

import data.ChattingMessage
import data.ChattingResponse
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils
import kotlin.jvm.internal.Intrinsics.Kotlin

@Controller
class ChattingController {

    private val logger = KotlinLogging.logger {}

    @MessageMapping("/chatting-message")
    @SendTo("/topic/chatting")
    fun chatting(chattingMessage: ChattingMessage): ChattingResponse{
        logger.info {">>> Received Message: ${chattingMessage.message}"}
        return ChattingResponse(HtmlUtils.htmlEscape(chattingMessage.message))
    }
}