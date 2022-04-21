
fun main(args:Array<String>) {
    println("Сохранение расписания кафедры в файл .xls ...")
    var check = false
    while (!check) {
        println("Пример: C:\\\\Расписание.xls")
        print("Введите расположение и название файла:")

        val checkNameFile = readLine()
        val variables = Regex("([А-я]+|[A-z]+|[\\:]+|[0-9]+).xls")
        val match = variables.findAll(checkNameFile!!).toList()
        if (match.isNotEmpty()) {
            println("Файл $checkNameFile успешно создан")
            check = true
            fileSchedule = checkNameFile
        } else
            println("Не верно задан файл, попробуйте снова!")
    }
    writeIntoExcel()
}