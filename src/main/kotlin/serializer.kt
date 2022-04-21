import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.DayOfWeek


object TypeOfWeekSerializer : KSerializer<TypeOfWeek> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("TypeOfWeek", PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder) =
        when (decoder.decodeString()) {
            "Четная" -> TypeOfWeek.EVEN
            else -> TypeOfWeek.ODD
        }

    override fun serialize(encoder: Encoder, value: TypeOfWeek) =
        encoder.encodeString(
            when (value) {
                TypeOfWeek.EVEN -> "Четная"
                TypeOfWeek.ODD -> "Нечетная"
            }
        )
}



object DayOfWeekSerializer : KSerializer<DayOfWeek> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("DayOfWeek", PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder) =
        when (decoder.decodeString()) {
            "Пн" -> DayOfWeek.MONDAY
            "Вт" -> DayOfWeek.TUESDAY
            "Ср" -> DayOfWeek.WEDNESDAY
            "Чт" -> DayOfWeek.THURSDAY
            "Пт" -> DayOfWeek.FRIDAY
            "Сб" -> DayOfWeek.SATURDAY
            else -> DayOfWeek.SUNDAY
        }

    override fun serialize(encoder: Encoder, value: DayOfWeek) =
        encoder.encodeString(
            when (value) {
                DayOfWeek.MONDAY -> "Пн"
                DayOfWeek.TUESDAY -> "Вт"
                DayOfWeek.WEDNESDAY -> "Ср"
                DayOfWeek.THURSDAY -> "Чт"
                DayOfWeek.FRIDAY -> "Пт"
                DayOfWeek.SATURDAY -> "Сб"
                DayOfWeek.SUNDAY -> "Вс"
            }
        )
}



object TypeLessonSerializer : KSerializer<TypeLesson> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("TypeLesson", PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder) =
        when (decoder.decodeString()) {
            "Лек" -> TypeLesson.LECTURE
            "Пр" -> TypeLesson.PRACTICE
            "Лаб" -> TypeLesson.LAB
            "КСР" -> TypeLesson.KSR
            else -> TypeLesson.KRB
        }

    override fun serialize(encoder: Encoder, value: TypeLesson) =
        encoder.encodeString(
            when (value) {
                TypeLesson.LECTURE -> "Лек"
                TypeLesson.PRACTICE -> "Пр"
                TypeLesson.LAB -> "Лаб"
                TypeLesson.KSR -> "КСР"
                TypeLesson.KRB -> "КРБ"
            }
        )
}