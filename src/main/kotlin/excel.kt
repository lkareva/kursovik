import org.apache.poi.hssf.usermodel.*
import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.util.*
import java.io.FileOutputStream
import java.time.DayOfWeek
var fileSchedule = "Расписание.xls"
val book: Workbook = HSSFWorkbook()
val sheet: Sheet = book.createSheet("Расписание")  // создание нового листа в книг

//создание шаблона
fun patternSchedule() {
    //нумерация начинается с нуля
    val row = sheet.createRow(0) // создание новой строки в листе
    sheet.addMergedRegion(CellRangeAddress(0, 0, 0, 60)) //объединение ячеек
    row.createCell(0).apply {
        setCellValue("Расписание")
        cellStyle = styleAll
    }

    val row1 = sheet.createRow(1) // создание новой строки в листе
    sheet.addMergedRegion(CellRangeAddress(1, 1, 0, 29)) //объединение ячеек
    row1.createCell(0).apply {
        setCellValue("Нечетная")
        cellStyle = styleAll
    }
    sheet.addMergedRegion(CellRangeAddress(1, 3, 30, 30))
    row1.createCell(30).apply {
        setCellValue("Преподаватель")
        cellStyle = styleT
    }
    sheet.addMergedRegion(CellRangeAddress(1, 1, 31, 60)) //объединение ячеек
    row1.createCell(31).apply {
        setCellValue("Четная")
        cellStyle = styleAll
    }

    val row2 = sheet.createRow(2) // создание новой строки в листе
    val row3 = sheet.createRow(3)

    var i = 0
    listOf("Пн", "Вт", "Ср", "Чт", "Пт", "Сб").map { day ->
        sheet.addMergedRegion(CellRangeAddress(2, 2, i, i + 4))
        sheet.addMergedRegion(CellRangeAddress(2, 2, 31 + i, 31 + i + 4))
        row2.createCell(i).apply {
            setCellValue(day)
            cellStyle = styleAll
        }
        row2.createCell(31 + i).apply {
            setCellValue(day)
            cellStyle = styleAll
        }
        var j = i
        listOf("08:00 - 09:35", "09:45 - 11:20", "11:30 - 13:05", "13:55 - 15:30", "15:40 - 17:15").map { number ->
            row3.createCell(j).apply {
                setCellValue(number)
                cellStyle = styleT
            }
            row3.createCell(31 + j).apply {
                setCellValue(number)
                cellStyle = styleT
            }
            sheet.autoSizeColumn(j)
            sheet.autoSizeColumn(31 + j)
            j++
        }
        i += 5
    }
}

//заполнение таблицы данными
fun filingScheduleExcel(){
    filling()
    var proverka = ""
    var i = 3
    var row = sheet.createRow(4)
    mSchedule.forEach {
        if(it.participants.teacher != proverka) {
            proverka = it.participants.teacher
            i++
            row = sheet.createRow(i)
            row.createCell(30).apply {
                setCellValue(it.participants.teacher)
                cellStyle = styleAll
            }
            sheet.autoSizeColumn(30)
        }
        var j = 0
        if(it.coordinates.typeOfWeeK != TypeOfWeek.ODD) j = 31
        j += when(it.coordinates.dayOfWeek) {
            DayOfWeek.MONDAY -> 0
            DayOfWeek.TUESDAY -> 5
            DayOfWeek.WEDNESDAY -> 10
            DayOfWeek.THURSDAY -> 15
            DayOfWeek.FRIDAY -> 20
            else -> 25

        }
        j += when(it.coordinates.numberClass) {
            1 ->  0
            2 ->  1
            3 ->  2
            4 ->  3
            else ->  4
        }
        row.createCell(j).apply {
            setCellValue("${it.discipline}\n${it.type}\n${it.classroom}\n${it.participants.group}")
            if(it.type == TypeLesson.LECTURE) cellStyle = styleCellLec
            else cellStyle = styleCell
        }
        sheet.autoSizeColumn(j)
    }

}

fun writeIntoExcel() {
    patternSchedule()
    filingScheduleExcel()
    book.write(FileOutputStream(fileSchedule))
    book.close()
}
