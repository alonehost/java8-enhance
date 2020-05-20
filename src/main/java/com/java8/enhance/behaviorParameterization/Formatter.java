package com.java8.enhance.behaviorParameterization;

public interface Formatter<T> {
    String accept(T t);
}
