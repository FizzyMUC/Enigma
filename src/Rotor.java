package Enigma;

public class Rotor {
    private String left;
    private String right;
    private String notch;
    
    public int notchPosition;
    public int rotorPosition;
    
    Rotor(String wiring, String notch) {
        this.left = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.right = wiring;
        this.notch = notch;
        this.notchPosition = left.indexOf(notch);
        this.rotorPosition = 0;
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
    
    void print() {
        System.out.println(this.left);
        System.out.println(this.right);
    }
    
    void rotate() {
        this.left = left.substring(1) + left.substring(0, 1);
        this.right = right.substring(1) + right.substring(0, 1);
        
        if (this.rotorPosition < 25) {
            this.rotorPosition += 1;
        } else {
            this.rotorPosition = 0;
        }
    }
    
    void rotate(int numberOfRotations) {
        for (int i = 0; i < numberOfRotations; i += 1) {
            this.rotate();
        } 
    }
    
    void rotateToLetter(String letter) {
        int positionOfLetter = this.right.indexOf(letter);
        this.rotate(positionOfLetter);
    }
    
    public boolean rotorReadyToRotate() {
        return rotorPosition == notchPosition;
    }
}
