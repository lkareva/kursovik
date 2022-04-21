import org.litote.kmongo.*

val mSchedule = scheduleMongo.aggregate<ScheduleMongo>(
    sort(ScheduleMongo::participants / Participants:: teacher eq 1),
)
