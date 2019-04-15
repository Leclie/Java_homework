package fitness;

@AccessMode(gym = "16", group = "16", pool = "0")
public class DayClient extends Human{

    private String endOfReg;
    private Access group = new Access(8, 16, FitnessServiceEnumeration.GROUP);
    private Access gym = new Access(8, 16, FitnessServiceEnumeration.GYM);

    public Access getGroup() {
        return group;
    }

    public void setGroup(Access group) {
        this.group = group;
    }


    public DayClient(String name, String surname, int bYear) {
        super(name, surname, bYear);
//        "12.04.2019";
        //TODO: подсчет даты окончания регистрации отдельным методом
        endOfReg1();
    }

    public DayClient(String name, String surname, int bYear, String regDate, int end) {
        //TODO: подсчет даты окончания регистрации отдельным методом
        super(name, surname, bYear, regDate);
        endOfReg2(end);
    }

    public void endOfReg1(){
        String today = "12.04.2019";
        this.endOfReg = "12.04.20" + (Integer.parseInt(today.substring(8)) + 1);
    }

    public void endOfReg2(int end){
        String regDate = getRegDate();
        int day = Integer.parseInt(regDate.substring(0,2));
        int month = Integer.parseInt(regDate.substring(3,5));
        int year = Integer.parseInt(regDate.substring(6));
        month = month + end;
        while(month > 12){
                year++;
                month = month - 12;
        }
        endOfReg = day + "." + month + "." + year;
    }

    public Access getGym() {
        return gym;
    }

    @Override
    public String toString() {
        return "DayClient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
