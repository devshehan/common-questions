import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String userName = "Shehaan";
        reverseString(userName);
        calculateConstantsAndVowelsInString(userName);

        String name = "hhShehan";
        findFirstNonRepeatedCharacterInString(name);

        String palindromeName = "RADAR";
        findTheStringIsPalindrome(palindromeName);

        String name1 = "skhehaan";
        String name2 = "saahehne";
        findTwoStringAreAnagram(name1,name2);

        // Arrays
        findDuplicatesNumbersInArray();
        findLargestAndShortestNumberInTheArray();
        findPairNumbersThatAddUptoSpecificSum();
    }

    public static void reverseString(String username){
        System.out.println("String : " + username);

        StringBuilder sb = new StringBuilder(username);
        sb.reverse();

        System.out.println("Reversed String : " + sb);
    }
    public static void calculateConstantsAndVowelsInString(String username){

        char[] charArr = username.toLowerCase().toCharArray();

        int constants = 0;
        int vowels = 0;

        for(int i=0; i<username.length(); i++){
            char x = charArr[i];
            if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'){
                vowels++;
            }else{
                constants++;
            }
        }
        System.out.println("\nCalculate Number of vowels and constants in the string");
        System.out.println("String : " + username);
        System.out.println("Vowels : " + vowels);
        System.out.println("Constants : " + constants);
    }
    public static void findFirstNonRepeatedCharacterInString(String username){

        int[] numArr = new int[256];
        Arrays.fill(numArr,0);

        char[] charArr = username.toLowerCase().toCharArray();

        for(char x : charArr){
            numArr[x]++;
        }

        for(char x : charArr){
            if(numArr[x] == 1){
                System.out.println("First Non repeated Character is : " + x);
                break;
            }
        }
    }
    public static void findTheStringIsPalindrome(String username){
        // RADAR
        StringBuilder sb = new StringBuilder(username);
        String reverseString = sb.reverse().toString();

        if(username.equals(reverseString)){
            System.out.println("String : " + username + " is palindrome.");
        }else{
            System.out.println("String : " + username + " is not palindrome.");
        }
    }
    public static void findTwoStringAreAnagram(String name1, String name2){
        int[] numArr = new int[256];
        Arrays.fill(numArr,0);

        if(name1.length() != name2.length()){
            System.out.println("Invalid inputs");
            return;
        }

        for(int i=0; i<name1.length(); i++){
            char x = name1.charAt(i);
            char y = name2.charAt(i);

            numArr[x]++;
            numArr[y]--;
        }

        for(int i : numArr){
            if(i != 0){
                System.out.println("Given two strings are not anagram");
                return;
            }
        }

        System.out.println("Given two strings are anagram of each others.");
    }

    public static void findDuplicatesNumbersInArray(){
        int[] arr = {1, 1, 2, 2, 3, 4, 5, 6, 6, 6, 8};

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i : arr){
            int val = hashMap.getOrDefault(i,0);
            hashMap.put(i,val+1);
        }

        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            if(entry.getValue() > 1){
                System.out.println("Key: " + entry.getKey());
            }
        }

    }
    public static void findLargestAndShortestNumberInTheArray(){
        int[] arr = {100, 1, 2, 200, 3, 4, 5, 6, 6, 6, 8};

        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i : arr){
            if(i >= largest){
                largest = i;
            }
            if(i <= smallest){
                smallest = i;
            }
        }

        System.out.println("Largest value : " + largest);
        System.out.println("Smallest value : " + smallest);

    }
    public static void findPairNumbersThatAddUptoSpecificSum(){
        int[] arr = {100, 1, 2, 200, 3, 4, 50, 6, 150, 6, 6, 8};
        int sum = 250;

        for(int i=0; i<arr.length-1; i++){
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == sum){
                    System.out.println("< " + arr[i] + ", " + arr[j] + " >");
                }
            }
        }

    }
}