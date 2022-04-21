import kotlinx.serialization.Serializable
import org.litote.kmongo.*
import java.time.DayOfWeek

@Serializable
enum class TypeOfWeek{//Тип недели
    EVEN, ODD
    //Четная, Нечетная
}
@Serializable
enum class TypeLesson(private val type: String) { //Тип занятий
    LECTURE("Лек"),
    PRACTICE("Пр"),
    LAB("Лаб"),
    KSR("КСР"),
    KRB("КРБ");

    override fun toString() = type
}
@Serializable
data class Coordinates( //Координаты занятия
    @Serializable(with = TypeOfWeekSerializer::class)
    val typeOfWeeK:TypeOfWeek, //Тип недели
    @Serializable(with = DayOfWeekSerializer::class)
    val dayOfWeek:DayOfWeek, //День недели
    val numberClass: Int //Номер пары
)
@Serializable
data class Participants( //Список учавствующих
    val teacher: String, //преподаватель
    val group: String, //группа
    val subgroup: Int? = null //подгруппа
)

@Serializable
data class ScheduleMongo( //Расписание
    val coordinates: Coordinates,
    val participants: Participants,
    val discipline: String, //Предмет
    @Serializable(with = TypeLessonSerializer::class)
    val type: TypeLesson, //Тип занятий
    val classroom: String //аудитория
)
val scheduleMongo = mongoDatabase.getCollection<ScheduleMongo>().apply { drop() }
