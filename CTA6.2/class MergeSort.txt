package studentInfoArrayListMergeSort;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        
        // Add 10 student objects
        students.add(new Student(5, "Tyler Butorac", "123 Boost Blvd"));
        students.add(new Student(3, "Eric Mikula", "456 Meatloaf Dr"));
        students.add(new Student(10, "David Howard", "789 Space Lane"));
        students.add(new Student(1, "Colin Jenison", "101 Bicycle Ave"));
        students.add(new Student(6, "Bryant Butorac", "123 Gamer Plaza"));
        students.add(new Student(9, "Brett Butorac", "456 Flood St"));
        students.add(new Student(2, "Justin Butorac", "789 Soccer St"));
        students.add(new Student(7, "Mishelle Trembly", "14 Equest Ln"));
        students.add(new Student(4, "Elliot Turton", "323 Musicman Rd"));
        students.add(new Student(8, "Trevor Berg", "747 Hotrod Ln"));

        // Sort the students by rollnum using merge sort
        students = mergeSort(students, new RollNumComparator());

        // Print the sorted student list
        System.out.println("MUSIC-101: Student Roll Sheet (sorted)");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static ArrayList<Student> mergeSort(ArrayList<Student> list, Comparator<Student> comparator) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        ArrayList<Student> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left, comparator);
        right = mergeSort(right, comparator);

        return merge(left, right, comparator);
    }

    public static ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right, Comparator<Student> comparator) {
        ArrayList<Student> merged = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) <= 0) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex++));
        }

        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex++));
        }

        return merged;
    }
}

