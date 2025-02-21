//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean isBalanced(String s) {
        
        Stack<Character> stack=new Stack<>();
        
        int n=s.length();
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            if(ch=='{' || ch=='('|| ch=='['){
                stack.push(ch);
                continue;
            }
            
            if(ch=='}'){
                if(!stack.isEmpty() &&stack.peek()=='{'){
                    stack.pop();
                }else{
                    return false;
                }
                
            }else if(ch==')'){
                if(!stack.isEmpty() &&stack.peek()=='('){
                    stack.pop();
                }else{
                    return false;
                }
                
            }else{
                if(!stack.isEmpty() &&stack.peek()=='['){
                    stack.pop();
                }else{
                    return false;
                }
                
            }
                
            }
            return stack.isEmpty();
            
        }
        
        
            
        
        // code here
}
