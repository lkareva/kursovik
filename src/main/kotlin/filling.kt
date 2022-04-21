import java.time.DayOfWeek

fun filling(){
    scheduleMongo.insertOne(ScheduleMongo(Coordinates(TypeOfWeek.EVEN,DayOfWeek.SATURDAY,1),
        Participants("Альтман","29з"), "ООП",TypeLesson.LECTURE,"1-330"))
    scheduleMongo.insertOne(ScheduleMongo(Coordinates(TypeOfWeek.ODD,DayOfWeek.MONDAY,1),
        Participants("Альтман","28з"), "ООП",TypeLesson.LAB,"1-330"))
    scheduleMongo.insertOne(ScheduleMongo(Coordinates(TypeOfWeek.ODD,DayOfWeek.THURSDAY,1),
        Participants("Альтман","29з"), "ООП",TypeLesson.PRACTICE,"1-322"))
    scheduleMongo.insertOne(ScheduleMongo(Coordinates(TypeOfWeek.ODD,DayOfWeek.TUESDAY,2),
        Participants("Альтман","29м"), "ООП",TypeLesson.LAB,"1-330"))
    scheduleMongo.insertOne(ScheduleMongo(Coordinates(TypeOfWeek.EVEN,DayOfWeek.THURSDAY,2),
        Participants("Альтман","28м"), "ООП",TypeLesson.PRACTICE,"1-325"))
    scheduleMongo.insertOne(ScheduleMongo(Coordinates(TypeOfWeek.ODD,DayOfWeek.SATURDAY,1),
        Participants("Альтман","29з"), "ООП",TypeLesson.LECTURE,"1-330"))


    scheduleMongo.insertOne(ScheduleMongo(Coordinates(TypeOfWeek.EVEN,DayOfWeek.SATURDAY,1),
        Participants("Окишев","29з"), "ТО АПС",TypeLesson.LECTURE,"1-330"))
    scheduleMongo.insertOne(ScheduleMongo(Coordinates(TypeOfWeek.ODD,DayOfWeek.FRIDAY,1),
        Participants("Окишев","29з"), "ТО АПС",TypeLesson.LAB,"1-326"))
    scheduleMongo.insertOne(ScheduleMongo(Coordinates(TypeOfWeek.ODD,DayOfWeek.SATURDAY,1),
        Participants("Окишев","29м"), "ТО АПС",TypeLesson.LAB,"1-326"))
    scheduleMongo.insertOne(ScheduleMongo(Coordinates(TypeOfWeek.ODD,DayOfWeek.WEDNESDAY,2),
        Participants("Окишев","29и"), "ЧМ",TypeLesson.LAB,"1-326"))

}