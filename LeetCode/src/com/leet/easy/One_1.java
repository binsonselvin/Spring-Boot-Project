package com.leet.easy;

/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

	You may assume that each input would have exactly one solution, and you may not use the same element twice.

	You can return the answer in any order.
 */

public class One_1 {

	public static int[] twoSum(int[] nums, int target) {
		int pointer = 1;
        int[] variableArr = new int[2];
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<=nums.length-1; j++) {            
                if( (nums[i] + nums[j]) == target ) {
                    variableArr[0] = i;
                    variableArr[1] = j;
                    return variableArr; 
                }
            }
            pointer = pointer + 1;
          }
        return variableArr; 
    }
	
	public static void main(String[] args) {
		int[] nums = {3,2,3};
		int[] arr = One_1.twoSum(nums, 6);
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("i: "+arr[i]);
		}
	}

}
