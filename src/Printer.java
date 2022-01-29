public class Printer {

    public static void menu() {
        System.out.println("Что вы хотите сделать?\n" +
                "1 - Считать все месячные отчёты\n" +
                "2 - Считать годовой отчёт\n" +
                "3 - Сверить отчёты\n" +
                "4 - Вывести информацию о всех месячных отчётах\n" +
                "5 - Вывести информацию о годовом отчёте\n" +
                "exit - Выход из программы");
    }

    public static void readingSuccess() {
        System.out.println("------------------------------------------\n" +
                "Считывание отчета прошло успешно\n" +
                "------------------------------------------");
    }

    public static void reportNotReady() {
        System.out.println("--------------------\n" +
                "Отчет не сформирован\n" +
                "--------------------");
    }

    public static void errorReadingFile() {
        System.out.println("Ошибка при чтении файла");
    }

    public static void exit() {
        System.out.println("Выход из программы");
    }

}
