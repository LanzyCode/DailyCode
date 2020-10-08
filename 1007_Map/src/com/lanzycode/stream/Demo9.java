package com.lanzycode.stream;

import com.lanzycode.domain.Actor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo9 {
    public static void main(String[] args) {
        ArrayList<Actor> maleActor = new ArrayList<>(List.of(new Actor("大木"), new Actor("加藤鹰"), new Actor("王宝强"),
                new Actor("彭于晏"), new Actor("葛优"), new Actor("王一博")));
        ArrayList<Actor> femaleActor = new ArrayList<>(List.of(new Actor("林黛玉"), new Actor("林青霞"), new Actor("林心如"),
                new Actor("赵薇"), new Actor("范冰冰"), new Actor("李冰冰")));
        Stream<Actor> maleStream = maleActor.stream().filter(actor -> actor.getName().length() == 3).limit(3);
        Stream<Actor> femaleStream = femaleActor.stream().filter(actor -> actor.getName().startsWith("林")).skip(1);
        List<Actor> collect = Stream.concat(maleStream, femaleStream).collect(Collectors.toList());
        System.out.println(collect);
    }
}
