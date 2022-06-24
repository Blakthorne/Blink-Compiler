package org.main.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayUtils {
    public static <T> T[] of(Class<T> clazz, T... elements) {
        var arr = (T[]) Array.newInstance(clazz, elements.length);
        for(int i = 0; i < elements.length; ++i) {
            arr[i] = elements[i];
        }
        return arr;
    }

    public static <T> boolean arrayContains(T[] array, T t) {
        for (T item : array) {
            if (item.equals(t)) {
                return true;
            }
        }
        return false;
    }

    public static boolean arrayContains(int[] array, int t) {
        for (int item : array) {
            if (item == t) {
                return true;
            }
        }
        return false;
    }

    public static <T> String join(T[] array) {
        String s = "";
        for (int i = 0; i < array.length; ++i) {
            s += array[i];
            if (i == array.length - 2) {
                s += " or ";
            } else if (i != array.length - 1) {
                s += ", ";
            }
        }
        return s;
    }
}
