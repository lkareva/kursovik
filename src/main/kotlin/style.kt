import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.usermodel.Font.SS_SUB


val styleAll: CellStyle = book.createCellStyle().apply {
    setAlignment(HorizontalAlignment.CENTER)
    setVerticalAlignment(VerticalAlignment.CENTER)
}
val styleT: CellStyle  = book.createCellStyle().apply {
    setAlignment(HorizontalAlignment.CENTER)
    setVerticalAlignment(VerticalAlignment.CENTER)
    rotation = 90
}

val styleCell: CellStyle = book.createCellStyle().apply {
    setAlignment(HorizontalAlignment.CENTER)
    setVerticalAlignment(VerticalAlignment.CENTER)
    val font = book.createFont().apply{
        fontHeight = 140
    }
    setFont(font)
    wrapText = true
}

val styleCellLec: CellStyle = book.createCellStyle().apply {
    setAlignment(HorizontalAlignment.CENTER)
    setVerticalAlignment(VerticalAlignment.CENTER)
    val font = book.createFont().apply{
        fontHeight = 140
        bold = true
    }
    setFont(font)
    wrapText = true
}