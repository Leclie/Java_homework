package fitness;

import java.util.*;

public class FitnessRegistrator {
    private TreeSet<Human> inGym = new TreeSet<>();
    private TreeSet<Human> inPool = new TreeSet<>();
    private TreeSet<Human> inGroup = new TreeSet<>();

    FitnessRegistrator(){
        Comparator<Human> humanComparator = new HumanSurnameComparator().thenComparing(new HumanNameComparator());
        inGym = new TreeSet<>(humanComparator);
        inPool = new TreeSet<>(humanComparator);
        inGroup = new TreeSet<>(humanComparator);
    }

    public void add(Client client, FitnessServiceEnumeration type)  {
        if (FitnessServiceEnumeration.GYM.equals(type)) {
            if (inGym.size() < 21){
                inGym.add(client);
            }else {throw new QueueException("Все места заняты!");}
        }
        else if(FitnessServiceEnumeration.POOL.equals(type)){
            if (inPool.size() < 21){
                inPool.add(client);
            }else {throw new QueueException("Все места заняты!");}
        }
        else {throw new NoAccessException("Вы не можете посетить данную секцию!");}
        client.setVisited(true);
    }

    public void add(DayClient dayClient, FitnessServiceEnumeration type){
        if (FitnessServiceEnumeration.GYM.equals(type)) {
            if (inGym.size() < 21){
                inGym.add(dayClient);
            }else {throw new QueueException("Все места заняты!");}
        }
        if (FitnessServiceEnumeration.GROUP.equals(type)) {
            if (inGroup.size() < 21){
                inGroup.add(dayClient);
            }else {throw new QueueException("Все места заняты!");}
        }
        else {throw new NoAccessException("Вы не можете посетить данную секцию!");}
    }

    public void add(FullDayClient fullDayClient, FitnessServiceEnumeration type){
        if (FitnessServiceEnumeration.GYM.equals(type)) {
            if (inGym.size() < 21){
                inGym.add(fullDayClient);
            }else {throw new QueueException("Все места заняты!");}
        }
        if (FitnessServiceEnumeration.GROUP.equals(type)) {
            if (inGroup.size() < 21){
                inGroup.add(fullDayClient);
            }else {throw new QueueException("Все места заняты!");}
        }else if(FitnessServiceEnumeration.POOL.equals(type)){
            if (inPool.size() < 21){
                inPool.add(fullDayClient);
            }else {throw new QueueException("Все места заняты!");}
        }
    }

    public void deleteFromAllLists(Human human){
        inGroup.remove(human);
        inPool.remove(human);
        inGym.remove(human);
    }

    public void out(){
        System.out.println(inGym);
        System.out.println(inPool);
        System.out.println(inGroup);
    }


    public static void main(String[] args) {
        FitnessRegistrator fitnessRegistrator = new FitnessRegistrator();
        FitnessServiceEnumeration group = FitnessServiceEnumeration.GROUP;
        FitnessServiceEnumeration gym = FitnessServiceEnumeration.GYM;
        FitnessServiceEnumeration pool = FitnessServiceEnumeration.POOL;

        fitnessRegistrator.add(new Client("jeje", "john", 1945), gym);
        fitnessRegistrator.add(new Client("jaji", "jein", 1945), gym);
        fitnessRegistrator.add(new Client("jojo", "jaja", 1945), pool);
        fitnessRegistrator.out();
    }

    @Override
    public String toString() {
        return "FitnessRegistrator{" +
                "inGym=" + inGym +
                ", inPool=" + inPool +
                ", inGroup=" + inGroup +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(inGym, inPool, inGroup);
    }
}
class HumanNameComparator implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class HumanSurnameComparator implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
