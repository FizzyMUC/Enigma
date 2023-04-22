package Enigma;

public class Keyboard {
    
    // Maps an input letter to its corresponding position in the standard alphabet and passes it on as an output signal
    public int forward(String letter) {
        int signal = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(letter);
        return signal;
    }
    
    // Maps an input signal / position to its corresponding letter in the standard alphabet and passes it on as an output letter
    public String backward(int signal) {
        String letter = String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(signal));
        return letter;
    }
}
