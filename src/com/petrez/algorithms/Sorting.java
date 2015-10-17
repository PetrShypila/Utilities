package com.petrez.algorithms;

import java.util.Arrays;
import java.util.Collections;

public abstract class Sorting {

    //Singleton
    private Sorting() {}

    /**
     * Selection sort algorithm implementation. Algorithm
     * takes O(N^2) time (used two for-loop) even if array is sorted.
     * @param array array for sorting.
     */
    public static void selectionSort(Comparable[] array) {
        for(int i = 0; i < array.length; i++) {
            int min = i;

            for(int j = i + 1; j < array.length; j++) {
                if(array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }
            exchange(array, i, min);
        }
    }

    /**
     * Insertion sort algorithm implementation. Most time takes
     * O(N^2) time, but gut for small arrays and for arrays with half sorted array.
     * @param array array for sorting.
     */
    public static void insertionSort(Comparable[] array) {
        for(int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j].compareTo(array[j - 1]) < 0; j--) {
                exchange(array, j, j - 1);
            }
        }
    }

    /**
     * Shell sort algorithm. Also implement insertion sort algorithm.
     * @param array Array for sorting.
     */
    public static void shellSort(Comparable[] array) {
        int h = 1;

        while(h < array.length / 3) {
            h = h * 3 + 1; //1, 4, 13 and so on.
        }

        while(h > 0) {
            for(int i = h; i < array.length; i++) {
                for (int j = i; j >= h && array[j].compareTo(array[j - 1]) < 0; j -= h) {
                    exchange(array, j, j - h);
                }
            }
            h = h/3;
        }
    }

    /**
     * Merge sort algorithm.
     * @param array Unordered array for sorting.
     */
    public static void mergeSort(Comparable[] array) {
        Comparable[] tempArray = new Comparable[array.length];

        for(int size = 1; size < tempArray.length; size = size + size) {
            for(int low = 0; low < tempArray.length - size; low += size + size) {
                merge(array, low, low + size - 1, Math.min(low + size + size - 1, array.length - 1));
            }
        }
    }

    /**
     * Quick sort algorithm which adeptated for arrays which include
     * a lot of duplicates keys.
     * @param array array for sorting.
     */
    public static void quickSort(Comparable[] array, boolean isManyDuplicates) {
        shuffle(array);
        if(isManyDuplicates) {
            quickSortForDuplicates(array, 0, array.length - 1);
        } else {
            quickSort(array, 0, array.length - 1);
        }
    }

    /**
     * Exchanging two elements in array.
     * @param array Array which contain elements for exchanging.
     * @param x First element for exchanging.
     * @param y Second element for exchanging.
     */
    private static void exchange(Comparable[] array, int x, int y) {
        if( x != y) {
            Comparable temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }
    }

    private static void merge(Comparable[] array, int low, int middle, int high) {
        Comparable[] tempArray = new Comparable[array.length];
        int i = low;
        int j = middle + 1;
        for(int q = low; q <= high; q++) {
            tempArray[q] = array[q];
        }
        for(int q = low; q <= high; q++) {
            if (i > middle) {
                array[q] = tempArray[j++];
            } else if(j > high) {
                array[q] = tempArray[i++];
            } else if(tempArray[j].compareTo(tempArray[i]) < 0) {
                array[q] = tempArray[j++];
            } else {
                array[q] = tempArray[i++];
            }
        }
    }

    private static int  partition(Comparable[] array, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable element = array[low];

        while(true) {
            while(array[++i].compareTo(element) < 0) {
                if(i == high) break;
            }
            while(element.compareTo(array[--j]) < 0) {
                if(j == low)  break;
            }

            if(i >= j) {
                break;
            }
            exchange(array, i, j);
        }

        exchange(array, low, j);
        return j;
    }

    private static void quickSort(Comparable[] array, int low, int high) {
        if(high <= low) {
            return;
        }
        int j = partition(array, low, high);
        quickSort(array, low, j - 1);
        quickSort(array, j + 1, high);
    }

    /**
     * One of Quick Sort variation. This using for array which have much duplicated
     * keys for comparing.
     * @param array Array for duplicating.
     * @param low Lower array index.
     * @param high Higher array index.
     */
    private static void quickSortForDuplicates(Comparable[] array, int low, int high) {
        if(high <= low) {
            return;
        }
        int lt = low;
        int i  = low + 1;
        int gt = high;

        Comparable element = array[low];

        while(i <= gt) {
            int comparing = array[i].compareTo(element);

            if(comparing < 0) {
                exchange(array, lt++, i++);
            } else if (comparing > 0){
                exchange(array, i, gt--);
            }
            else {
                i++;
            }
        }

        quickSortForDuplicates(array, low, lt - 1);
        quickSortForDuplicates(array, gt + 1, high);
    }

    /**
     * Method using for shuffling array before using Quick Sort algorithm.
     * @param array Array for shuffling.
     */
    private static void shuffle(Comparable[] array) {
        Collections.shuffle(Arrays.asList(array));
    }
}