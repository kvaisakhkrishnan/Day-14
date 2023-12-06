import java.io.*;
import java.util.*;

class HashTable {
    private final int numOfSlots;
    private final List<LinkedList<Integer>> slots;

    public HashTable(int numOfSlots) {
        this.numOfSlots = numOfSlots;
        this.slots = new ArrayList<>(numOfSlots);

        for (int i = 0; i < numOfSlots; i++) {
            slots.add(new LinkedList<>());
        }
    }

    public void insert(int number) {
        int slotIndex = number % numOfSlots;
        LinkedList<Integer> chain = slots.get(slotIndex);

        if (!chain.contains(number)) {
            chain.add(number);
        }
    }

    public void searchAndRemove(int number) {
        int slotIndex = number % numOfSlots;
        LinkedList<Integer> chain = slots.get(slotIndex);

        if (chain.contains(number)) {
            chain.remove((Integer) number);
        } else {
            chain.add(number);
        }
    }

    public void display() {
        for (int i = 0; i < numOfSlots; i++) {
            System.out.print("Slot " + i + ": ");
            for (Integer number : slots.get(i)) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < numOfSlots; i++) {
                for (Integer number : slots.get(i)) {
                    writer.print(number + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}