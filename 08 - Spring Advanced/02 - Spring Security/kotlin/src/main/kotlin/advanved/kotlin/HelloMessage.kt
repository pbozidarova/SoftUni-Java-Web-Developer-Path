package advanved.kotlin

import java.time.Instant

data class HelloMessage(
        val message: String,
        val sender: String,
        val generated: Instant
)