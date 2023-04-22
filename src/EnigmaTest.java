package Enigma;

public class EnigmaTest {
    public static void main(String[] args) {
        /*
         * Reflector: A
         * Rotors: I, II, III
         * Plugboard: A -> R, G -> K, O -> X
         * Key: 
         * Ring Setting: 
         * 
         * Message: A -> X
         */
        
        // Create new instace of Keyboard class
        Keyboard keyboard = new Keyboard();
        
        // Create new instance of Plugboard class, swapping A with R, G with K, and O with X
        String[] plugboardSwaps = new String[] {"AR", "GK", "OX"};
        Plugboard plugboard = new Plugboard(plugboardSwaps);
        
        // Create new instances of Rotor class with historic rotors
        Rotor rotorI = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "Q"); // Enigma I Rotor I (1930)
        Rotor rotorII = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", "E"); // Enigma I Rotor II (1930)
        Rotor rotorIII = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", "V"); // Enigma I Rotor III (1930)
        // Rotor IV = new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", "J"); // M3 Army Rotor IV (December 1938)
        // Rotor V = new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", "Z"); // M3 Army Rotor V (December 1938)
        
        // Create new instance of Reflector class with historic reflectors
        Reflector reflectorA = new Reflector("EJMZALYXVBWFCRQUONTSPIKHGD");
        // Reflector reflectorB = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
        // Reflector reflectorC = new Reflector("FVPJIAOYEDRZXWGCTKUQSBNMHL");
        
       
        
        
        // Test für den gesamten Flow
        String letter = "X";
        int signal = keyboard.forward(letter);
        System.out.println(signal);        
        
        signal = plugboard.forward(signal);
        System.out.println(signal);    
        
        signal = rotorIII.forward(signal);
        System.out.println(signal);   
        
        signal = rotorII.forward(signal);
        System.out.println(signal); 
        
        signal = rotorI.forward(signal);
        System.out.println(signal); 
        
        signal = reflectorA.reflect(signal);
        System.out.println(signal); 
        
        signal = rotorI.backward(signal);
        System.out.println(signal); 
        
        signal = rotorII.backward(signal);
        System.out.println(signal); 
        
        signal = rotorIII.backward(signal);
        System.out.println(signal);
        
        signal = plugboard.backward(signal);
        System.out.println(signal); 
        
        letter = keyboard.backward(signal);
        System.out.println(letter); 
        
        System.out.println(rotorII.notchPosition); 
        System.out.println(rotorII.rotorPosition); 
        System.out.println(rotorII.rotorReadyToRotate()); 
        
        rotorII.rotate(4);
        
        System.out.println(rotorII.notchPosition); 
        System.out.println(rotorII.rotorPosition); 
        System.out.println(rotorII.rotorReadyToRotate()); 
    }
}
