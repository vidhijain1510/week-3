/*Circular Tour Problem
Problem: Given a set of petrol pumps with petrol and distance to the next pump,
determine the starting point for completing a circular tour.
Hint: Use a queue to simulate the tour, keeping track of surplus petrol at each pump.*/

package day02stackqueuehash;

import java.util.*;

public class CircularTour {
    public static int startingIndex(int[] petrol, int[]distance){
        Queue<Integer> queue = new LinkedList<>();
        int totalPetrol = 0, currentPetrol = 0, startIndex = 0;
        for (int i = 0; i < petrol.length; i++){
            int netPetrol = petrol[i] - distance[i];
            currentPetrol += netPetrol;
            queue.add(i);
            totalPetrol += netPetrol;

            while(currentPetrol<0 && !queue.isEmpty()){
                startIndex = queue.poll()+1;
                currentPetrol = petrol[startIndex - 1] - distance[startIndex -1];
            }
        }
        return (totalPetrol>=0)?startIndex:-1;
    }

    public static void main(String[] args) {
        int[] petrol = {4,2,5,8};
        int[] distance = {5,1,5,4};
        int start = startingIndex(petrol,distance);
        if(start==-1){
            System.out.println("No  possible solution");
        }else{
            System.out.println("Circular tour start at: " + start);
        }
    }
}

