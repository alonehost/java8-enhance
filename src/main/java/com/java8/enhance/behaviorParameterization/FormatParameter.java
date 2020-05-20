package com.java8.enhance.behaviorParameterization;

import com.java8.enhance.bean.Apple;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zhangxuan
 * @date 2020/5/19
 */

public class FormatParameter {

    public static <T> void format(List<T> list, Formatter<T> format) {
        for (T e : list) {
            String accept = format.accept(e);
            System.out.println(accept);
        }
    }

    public static void main(String[] args) {
        Apple apple1 = new Apple("red", 10.24);
        Apple apple2 = new Apple("green", 12.24);
        Apple apple3 = new Apple("red", 2.24);
        ArrayList<Apple> apples = Lists.newArrayList(apple1, apple2, apple3);
        Formatter<Apple> formatter = (apple -> {
            String characteristic = apple.getWeight() > 10 ? "heavy" : "light";
            return "A " + characteristic + " " + apple.getColor() + " apple";
        });

        format(apples, formatter);

        Predicate<Apple> predicate = apple -> "red".equals(apple.getColor());
    }
}
