package com.zlh.game;

public class GlodPoint {
	private double[] array=new double[10];
	
	public GlodPoint() {
		
	}
	public GlodPoint(double[] array) {
		this.array=array;
	}
	public double[] getArray() {
		return array;
	}
	public void setArray(double[] array) {
		this.array = array;
	}
	public void Calculation() {
		double sum=0;
		double result;
		double differ;
		for (int i = 0; i < array.length; i++) {
			sum+=array[i];
		}
		sum/=10;
		sum*=0.618;
		differ=Math.abs(sum-array[0]);
		//System.out.println(differ);
		result=array[0];
		for (int i = 1; i < array.length; i++) {
			if(differ>Math.abs(sum-array[i])) {
				differ=Math.abs(sum-array[i]);
				result=array[i];
			}
		}
		System.out.println("The G is:"+sum);
		System.out.println("The result is:"+result);
	}
}
