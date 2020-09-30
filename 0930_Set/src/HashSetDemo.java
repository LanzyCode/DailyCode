import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("路飞");
        set.add("路飞");
        set.add("路飞");
        set.add("路飞");
        set.add("路飞");

        for (String s : set) {
            System.out.println(s);
        }
        Student xiaohei = new Student("xiaohei", 23);
        Student xiaomei = new Student("xiaohei", 23);
        System.out.println(xiaohei.hashCode());
        System.out.println(xiaomei.hashCode());
    }
}
