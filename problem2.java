// Problem2 (https://leetcode.com/problems/decode-string/)
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :yes


// Your code here along with comments explaining your approach
//as we need baby string and multiply it with number and add it to the parent string and keep doing it, we have used
//stacks or recursion. 
//for 4 different types of values, we have mentioned the actions that needs to be performed.

// stack
// class Solution {
//     public String decodeString(String s) {
//         Stack<Integer> multiply= new Stack<>();
//         Stack<StringBuilder> parents = new Stack<>();
//         int currentNum=0;
//         StringBuilder currentString = new StringBuilder();
//         int i=0;
//         while(i<s.length()){
//             if(s.charAt(i)=='['){
//                 parents.add(currentString);
//                 multiply.add(currentNum);
//                 currentString=new StringBuilder();
//                 currentNum=0;
//             }
//             else if(s.charAt(i)==']'){
//                 int k= multiply.pop();
//                 StringBuilder temp =new StringBuilder();
//                 for(int j=0;j<k;j++){
//                     temp.append(currentString);
//                 }
//                 StringBuilder parent=parents.pop();
//                 currentString=parent.append(temp);
//             }
//             else if(Character.isDigit(s.charAt(i))){
//                 currentNum=currentNum*10+s.charAt(i)-'0';
//             }else{
//                 currentString.append(s.charAt(i));
//             }
//             i++;
//         }
//         return currentString.toString();
//     }
// }

//recursion
class Solution {
    int i;
    public String decodeString(String s) {
        int currentNum=0;
        StringBuilder currentString = new StringBuilder();
        while(i<s.length()){
            if(s.charAt(i)=='['){
                i++;
                String baby = decodeString(s);
                StringBuilder decodebaby = new StringBuilder();
                for(int j=0;j<currentNum; j++){
                    decodebaby.append(baby);
                }
                currentString.append(decodebaby);
                currentNum=0;
            }
            else if(s.charAt(i)==']'){
                i++;
                return currentString.toString();
            }
            else if(Character.isDigit(s.charAt(i))){
                currentNum=currentNum*10+s.charAt(i)-'0';
                i++;
            }else{
                currentString.append(s.charAt(i));
                i++;
            }
        }
        return currentString.toString();
    }
}