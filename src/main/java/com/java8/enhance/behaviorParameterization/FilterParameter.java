package com.java8.enhance.behaviorParameterization;

import com.java8.enhance.bean.Apple;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxuan
 * @date 2020/5/19
 */

public class FilterParameter {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Apple apple = new Apple("red", 10.24);
        ArrayList<Apple> apples = Lists.newArrayList(apple);
        List<Apple> filterApples = filter(apples, appleFilter -> "red1".equals(appleFilter.getColor()));
        System.out.println(filterApples);
    }
}
