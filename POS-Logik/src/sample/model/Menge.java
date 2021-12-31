package sample.model;
import java.io.Serializable;
import java.util.*;

public class Menge implements Serializable
{
    private char letter;
    private ArrayList<Integer> numbers = new ArrayList<Integer>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menge menge = (Menge) o;
        return letter == menge.letter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter);
    }

    public Menge(char letter, ArrayList<Integer> numbersToBeAdded){
        super();
        tryNumbersToBeAdded(numbersToBeAdded);
        for(int n : numbersToBeAdded){
            if(!numbers.contains(n)) {
                numbers.add(n);
            }
        }
        sortInt(numbers);
        setLetter(letter);
    }

    public void sortInt(ArrayList<Integer> n){
        Collections.sort(n);
    }

    public boolean tryNumbersToBeAdded(ArrayList<Integer> n){
        for(int number : n){
            if(number < 0 || number > 9){
                throw new IllegalArgumentException("Die Nummer muss zwischen 0 und 9 sein!");
            }
        }
        return true;
    }

    public void setLetter(char letter){
        this.letter = letter;
    }

    public char getLetter(){
        return this.letter;
    }

    @Override
    public String toString() {
        return "Menge{" +
                "letter=" + letter +
                ", numbers=" + numbers +
                '}';
    }

    public ArrayList<Integer> getNumbers(){
        return numbers;
    }

}