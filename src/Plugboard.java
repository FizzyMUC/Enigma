package Enigma;

public class Plugboard {
    
    String right = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String left = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    Plugboard(String[] pairs) {
        for (String pair : pairs) {
            String a = String.valueOf(pair.charAt(0));
            String b = String.valueOf(pair.charAt(1));
            int positionOfA = right.indexOf(a);
            int positionOfB = right.indexOf(b);
            
            left = left.substring(0, positionOfA) + b + left.substring(positionOfA + 1);
            left = left.substring(0, positionOfB) + a + left.substring(positionOfB + 1); 
        }
    }
    
    int forward(int inputSignal) {
        String letter = String.valueOf(right.charAt(inputSignal));
        
        int outputSignal = left.indexOf(letter);
        return outputSignal;
    }
    
    int backward(int inputSignal) {
        String letter = String.valueOf(left.charAt(inputSignal));
        
        int outputSignal = right.indexOf(letter);
        return outputSignal;
    }
}
