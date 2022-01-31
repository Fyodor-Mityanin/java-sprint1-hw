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
        longLine();
        System.out.println("Считывание отчета прошло успешно");
        longLine();
    }

    public static void reportNotReady() {
        longLine();
        System.out.println("Отчет не сформирован");
        longLine();
    }

    public static void errorReadingFile() {
        longLine();
        System.out.println("Ошибка при чтении файла");
        longLine();
    }

    public static void exit() {
        longLine();
        System.out.println("Выход из программы");
        longLine();
    }

    public static void longLine() {
        System.out.println("-------------------------");
    }

    public static void readingMonthSuccess(Month month) {
        longLine();
        System.out.println("Считывание отчета за " + Month.toString(month) + " прошло успешно");
        longLine();
    }
}
