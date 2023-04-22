package Enigma;

public class Reflector {
    private String left;
    private String right;
    
    Reflector(String wiring) {
        this.left = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.right = wiring;
    }
    
    int reflect(int inputSignal) {
        String letter = String.valueOf(right.charAt(inputSignal));
        
        int outputSignal = left.indexOf(letter);
        return outputSignal;
    }
    
}
