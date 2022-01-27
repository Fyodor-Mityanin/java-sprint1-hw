public enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC;

    static public Month monthByNumber(String num) {
        switch (num) {
            case "01":
            case "1":
                return JAN;
            case "02":
            case "2":
                return FEB;
            case "03":
            case "3":
                return MAR;
            case "04":
            case "4":
                return APR;
            case "05":
            case "5":
                return MAY;
            case "06":
            case "6":
                return JUN;
            case "07":
            case "7":
                return JUL;
            case "08":
            case "8":
                return AUG;
            case "09":
            case "9":
                return SEP;
            case "10":
                return OCT;
            case "11":
                return NOV;
            case "12":
                return DEC;
            default:
                return null;
        }
    }

    static public String toString(Month month) {
        switch (month) {
            case JAN:
                return "Январь";
            case FEB:
                return "Февраль";
            case MAR:
                return "Март";
            case APR:
                return "Апрель";
            case MAY:
                return "Май";
            case JUN:
                return "Июнь";
            case JUL:
                return "Июль";
            case AUG:
                return "Август";
            case SEP:
                return "Сентябрь";
            case OCT:
                return "Октябрь";
            case NOV:
                return "Ноябрь";
            case DEC:
                return "Декабрь";
            default:
                return null;
        }
    }
}
