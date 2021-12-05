package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {
    private T [] objects;

    public ArrayUtility(T [] objects){
        this.objects= objects;
    }

    public int countDuplicatesInMerge(T [] arrayToMerge, T valueToEvaluate) {
        ArrayList<Object> added = new ArrayList<>(Arrays.asList(objects));
        int occurences = 0;
        Collections.addAll(added, arrayToMerge);

        for (Object newObject : added) {
            if (newObject == valueToEvaluate){
                occurences++;
            }
        }
        return occurences;
    }

    public T getMostCommonFromMerge( T [] arrayToMerge) {
        // Create a new array
        ArrayList<Object> mergedArray = new ArrayList<>(Arrays.asList(objects));
        // Merge arrays using collections
        Collections.addAll(mergedArray, arrayToMerge);
        // Declare a variable to null
        T mostCommon = null;
        // Declare another variable
        int most = Integer.MIN_VALUE;
        // Iterate through mergedArray
        for (Object newObject : mergedArray) {
            // If method call below is greater than most / min value variable
            // Example the number 5 is great than 1
            if (getNumberOfOccurrences((T) newObject) > most){
                // most common which is null now equals the number of occurences
                mostCommon = (T) newObject;

                most = getNumberOfOccurrences((T) newObject);
            }
        }
        return mostCommon;
    }

    public int getNumberOfOccurrences(T valueToEvaluate) {
        int occurrences = 0;
        for (Object newObject : objects) {
            if (newObject == valueToEvaluate) {
                occurrences++;
            }
        }
        return occurrences;
    }

    public T[] removeValue(T valueToRemove) {
////      List<T> newArray = new ArrayList<>(Arrays.asList(objects));
//        newArray.removeAll(Collections.singletonList(valueToRemove));
//        return newArray.toArray();  // Unable to get working due to casting issue.

        return Arrays.stream(objects)
                // filtered using a t variable for values that do not equal value to remove
                .filter(t -> t != valueToRemove)
                // t can go into the new list
                .toArray(newArray ->Arrays.copyOf(objects, newArray));
    }
}