/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neeraja.dsaproblems;

/**
 *
 * @author apple
 * @problemStatement:
 * Write a function max_consecutive_ones that takes in a binary array consisting of only 0s 
 * and 1s and returns the maximum number of consecutive 1s in this array if you can flip at most one 0.
 * Input: [1,1,0,1,1,1]
 * Output: 6
 * Input: [1,1,0,0,1,1,1]
 * Output: 4
 * Input: [1,1,0,0,1,0,1,1,1]
 * Output: 5
 */

/*
Solution Intuition:
1 1 0 1 1 1
1 2 0 1 2 3 front
2 1 0 3 2 1 rear
for all 0s in the input array: check front[i-1] + rear[i+1] + 1(because you want to flip this 0 to 1): 2+3+1 = 6

1 1 0 0 1 1 1
1 2 0 0 1 2 3
2 1 0 0 3 2 1 
for 1st zero: 2+0+1 = 3
for 2nd zero: 3+0+1 = 4
*/
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] input = new int[]{1,1,0,1,1,1};
        int output = maxConsecutiveOnes(input);
        System.out.println("output: " + output);
    }
    
    public static int maxConsecutiveOnes(int[] input) {
        int len = input.length;
        int[] countFromFront = new int[len];
        int[] countFromRear = new int[len];
        for(int i = 0; i < len; i++)
            countFromFront[i] = (input[i] == 0) ? 0 : (i == 0 ? 1 : countFromFront[i-1] + 1);
        for(int j = len - 1; j >= 0; j--)
            countFromRear[j] = (input[j] == 0) ? 0 : (j == len-1 ? 1 : countFromRear[j+1] + 1);
        
        int maxConsecutive = 0;
        for(int i = 0; i < len; i++) {
                int count = (i == 0 ? 0 : countFromFront[i-1]) + (i == len-1 ? 0 : countFromRear[i+1]) + 1;
                maxConsecutive = Math.max(maxConsecutive, count);
        }
        return maxConsecutive;
    }
}
