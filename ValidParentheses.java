public class ValidParentheses{
	//whenever find a match
	//update the longest
	public static int longestValidParentheses(String s){
		int longest = 0;
		int last = -1;
		Stack<Integer> lefts = new Stack<Integer>();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '(') {
				lefts.push(i);
			}else{
				if(lefts.isEmpty()){
					last = i;
				}else{
					lefts.pop();
					if(lefts.isEmpty()){
						longest = Math.max(longest, i - last);
					}else{
						longest = Math.max(longest, i - lefts.peak());
					}
				}
			}
		}
		return longest;
	}
	public static void main(String[] args){
		int i = longestValidParentheses(")()())");
		System.out.println(i);
	}
}