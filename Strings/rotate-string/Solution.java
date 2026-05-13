class Solution {
	public static boolean isRotate(String s , String goal) {
		if(s.length()!= goal.length()) return false;
		
		return (s+s).contains(goal);
		
	}
	public static void main(String[] args) {
		String s = "abcde";
		String goal = "eabcd";
		System.out.println(isRotate(s , goal));
	}
}
