package sample.model;
import sample.model.Menge;

import java.io.*;
import java.util.*;


public class Operation implements Serializable
{


    public ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList('A','B','C','D','E','F'));
    public ArrayList<Menge> mengen= new ArrayList<>();
    private ArrayList<Menge> backup = new ArrayList<>();

    public ArrayList<Menge> updateList() {
        return mengen;
    } // Für Frontend

    public boolean mengeErstellen(Menge m){
        if(!alphabet.contains(m.getLetter())){
            System.err.println("Der Buchstabe von der Menge ist nicht vorhanden");
            return false;
        }
        for(Menge menge : mengen) {
            if (menge.getLetter() == m.getLetter()) {
                System.err.println("Menge ist schon vorhanden");
                return false;
            }else if (mengen.size() >=6 ){
                System.err.println("Mehr als 6 duerfen nicht einfgefuegt werden");
                return false;
            }
        }
        mengen.add(m);
        return true;
    }

    public boolean mengeLöschen(Menge menge){

        ArrayList<Menge> toRemove = new ArrayList();

        if(getSizeOfArrayList() == 0){
            System.err.println("Man kann nichts löschen");
            return false;
        }
        if(getSizeOfArrayList() == 1){
            for (Menge m : mengen){
                if(m == menge){
                    toRemove.add(m);
                }
            }
            mengen.removeAll(toRemove);
            //        System.err.println("Menge " + menge + " existiert nicht");
            return true;
        }
        if(getSizeOfArrayList() == 2){
            for (Menge m : mengen){
                if(m == menge){
                    toRemove.add(m);
                }
            }
            mengen.removeAll(toRemove);
            if(mengen.get(0).getLetter()=='B'){
                mengen.get(0).setLetter('A');
            }
            //       System.err.println("Menge " + menge + " existiert nicht");
            return true;
        }
        if(getSizeOfArrayList() == 3){
            for (Menge m : mengen){
                if(m == menge){
                    toRemove.add(m);
                }
            }
            mengen.removeAll(toRemove);
            if(mengen.get(0).getLetter()=='B'){
                mengen.get(0).setLetter('A');
                mengen.get(1).setLetter('B');
            }
            if(mengen.get(1).getLetter()=='C'){
                mengen.get(1).setLetter('B');
            }
            //   System.err.println("Menge " + menge + " existiert nicht");
            return true;
        }
        if(getSizeOfArrayList() == 4){
            for (Menge m : mengen){
                if(m == menge){
                    toRemove.add(m);
                }
            }
            mengen.removeAll(toRemove);

            if(mengen.get(0).getLetter()=='B'){
                mengen.get(0).setLetter('A');
                mengen.get(1).setLetter('B');
                mengen.get(2).setLetter('C');
            }
            if(mengen.get(1).getLetter()=='C'){
                mengen.get(1).setLetter('B');
                mengen.get(2).setLetter('C');
            }
            if(mengen.get(2).getLetter()=='D'){
                mengen.get(2).setLetter('C');
            }
            //   System.err.println("Menge " + menge + " existiert nicht");
            return true;
        }
        if(getSizeOfArrayList() == 5){
            for (Menge m : mengen){
                if(m == menge){
                    toRemove.add(m);
                }
            }
            mengen.removeAll(toRemove);
            if(mengen.get(0).getLetter()=='B'){
                mengen.get(0).setLetter('A');
                mengen.get(1).setLetter('B');
                mengen.get(2).setLetter('C');
                mengen.get(3).setLetter('D');
            }
            if(mengen.get(1).getLetter()=='C'){
                mengen.get(1).setLetter('B');
                mengen.get(2).setLetter('C');
                mengen.get(3).setLetter('D');
            }
            if(mengen.get(2).getLetter()=='D'){
                mengen.get(2).setLetter('C');
                mengen.get(3).setLetter('D');
            }
            if(mengen.get(3).getLetter()=='E'){
                mengen.get(3).setLetter('D');
            }
            //   System.err.println("Menge " + menge + " existiert nicht");
            return true;
        }
        if(getSizeOfArrayList() == 6){
            for (Menge m : mengen){
                if(m == menge){
                    toRemove.add(m);
                }
            }
            mengen.removeAll(toRemove);
            if(mengen.get(0).getLetter()=='B'){
                mengen.get(0).setLetter('A');
                mengen.get(1).setLetter('B');
                mengen.get(2).setLetter('C');
                mengen.get(3).setLetter('D');
                mengen.get(4).setLetter('E');
            }
            if(mengen.get(1).getLetter()=='C'){
                mengen.get(1).setLetter('B');
                mengen.get(2).setLetter('C');
                mengen.get(3).setLetter('D');
                mengen.get(4).setLetter('E');
            }
            if(mengen.get(2).getLetter()=='D'){
                mengen.get(2).setLetter('C');
                mengen.get(3).setLetter('D');
                mengen.get(4).setLetter('E');
            }
            if(mengen.get(3).getLetter()=='E'){
                mengen.get(3).setLetter('D');
                mengen.get(4).setLetter('E');
            }
            if(mengen.get(4).getLetter()=='F'){
                mengen.get(4).setLetter('E');
            }
            //   System.err.println("Menge " + menge + " existiert nicht");
            return true;
        }
        return false;
    }

    // FÜR Differenz
    /*public ArrayList<Integer> differenzBerechnenAlpabtic(char letter) {

        ArrayList<Integer> a;
        ArrayList<Integer> b;
        ArrayList<Integer> c;
        ArrayList<Integer> d;
        ArrayList<Integer> e;
        ArrayList<Integer> f;

        if(letter == 'A') {
            if (getSizeOfArrayList() == 2) {
                a = mengen.get(0).getNumbers();
                b = mengen.get(1).getNumbers();
                a.removeAll(b);
                return a;
            }
            if (getSizeOfArrayList() == 3) {
                a = mengen.get(0).getNumbers();
                b = mengen.get(1).getNumbers();
                c = mengen.get(2).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                return a;
            }
            if (getSizeOfArrayList() == 4) {
                a = mengen.get(0).getNumbers();
                b = mengen.get(1).getNumbers();
                c = mengen.get(2).getNumbers();
                d = mengen.get(3).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                return a;
            }
            if (getSizeOfArrayList() == 5) {
                a = mengen.get(0).getNumbers();
                b = mengen.get(1).getNumbers();
                c = mengen.get(2).getNumbers();
                d = mengen.get(3).getNumbers();
                e = mengen.get(4).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                a.removeAll(e);
                return a;
            }
            if (getSizeOfArrayList() == 6) {
                a = mengen.get(0).getNumbers();
                b = mengen.get(1).getNumbers();
                c = mengen.get(2).getNumbers();
                d = mengen.get(3).getNumbers();
                e = mengen.get(4).getNumbers();
                f = mengen.get(5).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                a.removeAll(e);
                a.removeAll(f);
                return a;

            }
        }
        if(letter == 'B') {
            if (getSizeOfArrayList() == 2) {
                a = mengen.get(1).getNumbers();
                b = mengen.get(0).getNumbers();
                a.removeAll(b);
                return a;
            }
            if (getSizeOfArrayList() == 3) {
                a = mengen.get(1).getNumbers();
                b = mengen.get(0).getNumbers();
                c = mengen.get(2).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                return a;
            }
            if (getSizeOfArrayList() == 4) {
                a = mengen.get(1).getNumbers();
                b = mengen.get(0).getNumbers();
                c = mengen.get(2).getNumbers();
                d = mengen.get(3).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                return a;
            }
            if (getSizeOfArrayList() == 5) {
                a = mengen.get(1).getNumbers();
                b = mengen.get(0).getNumbers();
                c = mengen.get(2).getNumbers();
                d = mengen.get(3).getNumbers();
                e = mengen.get(4).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                a.removeAll(e);
                return a;
            }
            if (getSizeOfArrayList() == 6) {
                a = mengen.get(1).getNumbers();
                b = mengen.get(0).getNumbers();
                c = mengen.get(2).getNumbers();
                d = mengen.get(3).getNumbers();
                e = mengen.get(4).getNumbers();
                f = mengen.get(5).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                a.removeAll(e);
                a.removeAll(f);
                return a;

            }
        }
        if(letter == 'C') {
            if (getSizeOfArrayList() == 3) {
                a = mengen.get(2).getNumbers();
                b = mengen.get(1).getNumbers();
                c = mengen.get(0).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                return a;
            }
            if (getSizeOfArrayList() == 4) {
                a = mengen.get(2).getNumbers();
                b = mengen.get(1).getNumbers();
                c = mengen.get(0).getNumbers();
                d = mengen.get(3).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                return a;
            }
            if (getSizeOfArrayList() == 5) {
                a = mengen.get(2).getNumbers();
                b = mengen.get(1).getNumbers();
                c = mengen.get(0).getNumbers();
                d = mengen.get(3).getNumbers();
                e = mengen.get(4).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                a.removeAll(e);
                return a;
            }
            if (getSizeOfArrayList() == 6) {
                a = mengen.get(2).getNumbers();
                b = mengen.get(1).getNumbers();
                c = mengen.get(0).getNumbers();
                d = mengen.get(3).getNumbers();
                e = mengen.get(4).getNumbers();
                f = mengen.get(5).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                a.removeAll(e);
                a.removeAll(f);
                return a;

            }
        }
        if(letter == 'D') {
            if (getSizeOfArrayList() == 4) {
                a = mengen.get(3).getNumbers();
                b = mengen.get(2).getNumbers();
                c = mengen.get(1).getNumbers();
                d = mengen.get(0).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                return a;
            }
            if (getSizeOfArrayList() == 5) {
                a = mengen.get(3).getNumbers();
                b = mengen.get(2).getNumbers();
                c = mengen.get(1).getNumbers();
                d = mengen.get(0).getNumbers();
                e = mengen.get(4).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                a.removeAll(e);
                return a;
            }
            if (getSizeOfArrayList() == 6) {
                a = mengen.get(3).getNumbers();
                b = mengen.get(2).getNumbers();
                c = mengen.get(1).getNumbers();
                d = mengen.get(0).getNumbers();
                e = mengen.get(4).getNumbers();
                f = mengen.get(5).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                a.removeAll(e);
                a.removeAll(f);
                return a;

            }
        }
        if(letter == 'E') {
            if (getSizeOfArrayList() == 5) {
                a = mengen.get(4).getNumbers();
                b = mengen.get(3).getNumbers();
                c = mengen.get(2).getNumbers();
                d = mengen.get(1).getNumbers();
                e = mengen.get(0).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                a.removeAll(e);
                return a;
            }
            if (getSizeOfArrayList() == 6) {
                a = mengen.get(4).getNumbers();
                b = mengen.get(3).getNumbers();
                c = mengen.get(2).getNumbers();
                d = mengen.get(1).getNumbers();
                e = mengen.get(0).getNumbers();
                f = mengen.get(5).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                a.removeAll(e);
                a.removeAll(f);
                return a;

            }
        }
        if(letter == 'D') {
            if (getSizeOfArrayList() == 6) {
                a = mengen.get(5).getNumbers();
                b = mengen.get(4).getNumbers();
                c = mengen.get(3).getNumbers();
                d = mengen.get(2).getNumbers();
                e = mengen.get(1).getNumbers();
                f = mengen.get(0).getNumbers();
                a.removeAll(b);
                a.removeAll(c);
                a.removeAll(d);
                a.removeAll(e);
                a.removeAll(f);
                return a;

            }
        }

        throw new RuntimeException("Oops!!!");

    }*/

    /*public ArrayList<Integer> durchschnitt(){
        ArrayList<Integer> a;
        ArrayList<Integer> b;
        ArrayList<Integer> c;
        ArrayList<Integer> d;
        ArrayList<Integer> e;
        ArrayList<Integer> f;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> dummy1 = new ArrayList<>();
        ArrayList<Integer> dummy2 = new ArrayList<>();
        ArrayList<Integer> dummy3 = new ArrayList<>();
        ArrayList<Integer> dummy4 = new ArrayList<>();

        if(getSizeOfArrayList() == 2){
            a = mengen.get(0).getNumbers();
            b = mengen.get(1).getNumbers();
            for(int i = 0; i < 10; i++){
                if(a.contains(i) && b.contains(i)){
                    result.add(i);
                }
            }
            return result;
        }
        if(getSizeOfArrayList() == 3){
            a = mengen.get(0).getNumbers();
            b = mengen.get(1).getNumbers();
            c = mengen.get(2).getNumbers();
            for(int i = 0; i < 10; i++){
                if(a.contains(i) && b.contains(i)){
                    dummy1.add(i);
                }
                if(dummy1.contains(i) && c.contains(i)){
                    result.add(i);
                }
            }
            return result;
        }
        if(getSizeOfArrayList() == 4){
            a = mengen.get(0).getNumbers();
            b = mengen.get(1).getNumbers();
            c = mengen.get(2).getNumbers();
            d = mengen.get(3).getNumbers();
            for(int i = 0; i < 10; i++){
                if(a.contains(i) && b.contains(i)){
                    dummy1.add(i);
                }
                if(d.contains(i) && c.contains(i)){
                    dummy2.add(i);
                }
                if(dummy1.contains(i) && dummy2.contains(i)){
                    result.add(i);
                }
            }
            return result;
        }
        if(getSizeOfArrayList() == 5){
            a = mengen.get(0).getNumbers();
            b = mengen.get(1).getNumbers();
            c = mengen.get(2).getNumbers();
            d = mengen.get(3).getNumbers();
            e = mengen.get(4).getNumbers();
            for(int i = 0; i < 10; i++){
                if(a.contains(i) && b.contains(i)){
                    dummy1.add(i);
                }
                if(d.contains(i) && c.contains(i)){
                    dummy2.add(i);
                }
                if(dummy1.contains(i) && dummy2.contains(i)){
                    dummy3.add(i);
                }
                if(dummy3.contains(i) && e.contains(i)){
                    result.add(i);
                }
            }
            return result;
        }

        if(getSizeOfArrayList() == 6) {
            a = mengen.get(0).getNumbers();
            b = mengen.get(1).getNumbers();
            c = mengen.get(2).getNumbers();
            d = mengen.get(3).getNumbers();
            e = mengen.get(4).getNumbers();
            f = mengen.get(5).getNumbers();
            for (int i = 0; i < 10; i++) {
                if (a.contains(i) && b.contains(i)) {
                    dummy1.add(i);
                }
                if (d.contains(i) && c.contains(i)) {
                    dummy2.add(i);
                }
                if (dummy1.contains(i) && dummy2.contains(i)) {
                    dummy3.add(i);
                }
                if (f.contains(i) && e.contains(i)) {
                    dummy4.add(i);
                }
                if (dummy3.contains(i) && dummy4.contains(i)) {
                    result.add(i);
                }
            }
            return result;
        }
        throw new RuntimeException("What are you doing here?");
    }*/

    /*public ArrayList<Integer> vereignigung()
    {
        ArrayList<Integer> a;
        ArrayList<Integer> b;
        ArrayList<Integer> c;
        ArrayList<Integer> d;
        ArrayList<Integer> e;
        ArrayList<Integer> f;
        ArrayList<Integer> bigList = new ArrayList<Integer>();

        if(getSizeOfArrayList() == 2) {
            a = mengen.get(0).getNumbers();
            b = mengen.get(1).getNumbers();
            bigList.addAll(a);
            for(int i : b){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            Collections.sort(bigList);
            return bigList;
        }
        if(getSizeOfArrayList() == 3) {
            a = mengen.get(0).getNumbers();
            b = mengen.get(1).getNumbers();
            c = mengen.get(2).getNumbers();
            bigList.addAll(a);
            for(int i : b){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            for(int i : c){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            Collections.sort(bigList);
            return bigList;

        }

        if(getSizeOfArrayList() == 4) {
            a = mengen.get(0).getNumbers();
            b = mengen.get(1).getNumbers();
            c = mengen.get(2).getNumbers();
            d = mengen.get(3).getNumbers();
            bigList.addAll(a);
            for(int i : b){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            for(int i : c){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            for(int i : d){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            Collections.sort(bigList);
            return bigList;
        }

        if(getSizeOfArrayList() == 5) {
            a = mengen.get(0).getNumbers();
            b = mengen.get(1).getNumbers();
            c = mengen.get(2).getNumbers();
            d = mengen.get(3).getNumbers();
            e = mengen.get(4).getNumbers();
            bigList.addAll(a);
            for(int i : b){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            for(int i : c){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            for(int i : d){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            for(int i : e){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            Collections.sort(bigList);
            return bigList;
        }

        if(getSizeOfArrayList() == 6) {
            a = mengen.get(0).getNumbers();
            b = mengen.get(1).getNumbers();
            c = mengen.get(2).getNumbers();
            d = mengen.get(3).getNumbers();
            e = mengen.get(4).getNumbers();
            f = mengen.get(5).getNumbers();

            bigList.addAll(a);
            for(int i : b){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            for(int i : c){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            for(int i : d){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            for(int i : e){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            for(int i : f){
                if(!bigList.contains(i)) {
                    bigList.add(i);
                }
            }
            Collections.sort(bigList);
            return bigList;
        }


        throw new RuntimeException("What are you doing here?");
    }*/

    public ArrayList<Integer> vereignigungFürDelta(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> bigList = new ArrayList<>();
        bigList.addAll(a);
        for(int i : b){
            if(!bigList.contains(i)) {
                bigList.add(i);
            }
        }
        Collections.sort(bigList);
        return bigList;
    }

    public ArrayList<Integer> durchschnittFürDelta(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            if(a.contains(i) && b.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
    //TODO Fix this
    public ArrayList<Integer> differenzBerechnenFürDelta(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> durchschnitt;
        ArrayList<Integer> vereignigung;
        ArrayList<Integer> bigList = new ArrayList<>();
        durchschnitt = durchschnittFürDelta(a, b);
        vereignigung = vereignigungFürDelta(a,b);

        bigList.addAll(vereignigung);
        for(int n : durchschnitt){
            if(!bigList.contains(n)) {
                bigList.add(n);
            }
        }
        Collections.sort(bigList);
        for(Integer i :durchschnitt){
            bigList.remove(i);
        }
        return bigList;
    }


    //TODO Fix this
    public ArrayList<Integer> differenzAllgemeinBerechnenFürDelta(){
        ArrayList<Integer> durchschnitt = new ArrayList<>();
        ArrayList<Integer> vereignigung = new ArrayList<>();
        ArrayList<Integer> bigList = new ArrayList<>();
        /*durchschnitt = durchschnitt();
        vereignigung = vereignigung();*/

        bigList.addAll(vereignigung);
        for(int n : durchschnitt){
            if(!bigList.contains(n)) {
                bigList.add(n);
            }
        }
        Collections.sort(bigList);
        for(Integer i :durchschnitt){
            bigList.remove(i);
        }
        return bigList;
    }

    public ArrayList<Integer> delta(char a, char b){

        ArrayList<Character> charachters = new ArrayList<>(Arrays.asList(a,b));
        Collections.sort(charachters);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(Menge m : mengen){
            if(m.getLetter() == charachters.get(0) ){
                list1 = m.getNumbers();
            }
            if(m.getLetter() == charachters.get(1)){
                list2 = m.getNumbers();
            }
        }

        return differenzBerechnenFürDelta(list1, list2);

    }

    public ArrayList<Integer> vereignigungFürZwei(char a, char b){

        ArrayList<Character> charachters = new ArrayList<>(Arrays.asList(a,b));
        Collections.sort(charachters);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(Menge m : mengen){
            if(m.getLetter() == charachters.get(0) ){
                list1 = m.getNumbers();
            }
            if(m.getLetter() == charachters.get(1)){
                list2 = m.getNumbers();
            }
        }

        return vereignigungFürDelta(list1, list2);

    }

    public ArrayList<Integer> durchschnittFürZwei(char a, char b){

        ArrayList<Character> charachters = new ArrayList<>(Arrays.asList(a,b));
        Collections.sort(charachters);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(Menge m : mengen){
            if(m.getLetter() == charachters.get(0) ){
                list1 = m.getNumbers();
            }
            if(m.getLetter() == charachters.get(1)){
                list2 = m.getNumbers();
            }
        }

        return durchschnittFürDelta(list1, list2);

    }

    //FÜR differenz

    public ArrayList<Integer> differenzFürZwei(char a, char b){
        ArrayList<Character> charachters = new ArrayList<>(Arrays.asList(a,b));
        // Collections.sort(charachters);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> bigList = new ArrayList<>();
        for(Menge m : mengen){
            if(m.getLetter() == charachters.get(0)){
                list1 =m.getNumbers();
            }
            if(m.getLetter() == charachters.get(1)){
                list2 = m.getNumbers();
            }
        }
        bigList.addAll(list1);
        for(int n : list2){
            if(!bigList.contains(n)) {
                bigList.add(n);
            }
        }
        Collections.sort(bigList);
        System.out.println(bigList);
        for(Integer i : list2){
            bigList.remove(i);
        }
        return bigList;

    }




    public ArrayList<Integer> differenzFürZweiArrays(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> bigList = new ArrayList<>();
        list1=a;
        list2=b;
        bigList.addAll(list1);
        for(int n : list2){
            if(!bigList.contains(n)) {
                bigList.add(n);
            }
        }
        Collections.sort(bigList);
        System.out.println(bigList);
        for(Integer i : list2){
            bigList.remove(i);
        }
        return bigList;

    }


    public ArrayList<Integer> deltaAllgemein(){

        return differenzAllgemeinBerechnenFürDelta();

    }

    public ArrayList<Integer> komplement(char a){
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        ArrayList<Integer> list2 = new ArrayList<>();

        for(Menge m : mengen){
            if(m.getLetter() == a){
                list2 = m.getNumbers();
            }
        }

        return differenzFürZweiArrays(list1, list2);

    }

    public String potenz(char a){
        ArrayList<Integer> list1 = new ArrayList<>();
        String str = "";

        for(Menge m : mengen){
            if(m.getLetter() == a){
                list1 = m.getNumbers();
            }
        }

        if(list1.size()==1){
            str = "{{}, {" + list1.get(0) + "}}";
            return str;
        }
        if(list1.size()==2){
            str = "{{}, {" + list1.get(0) + "}, " + "{" + list1.get(1) + "}, " + "{" + list1.get(0) + " " + list1.get(1) +  "}}";
            return str;
        }
        if(list1.size()==3){
            str = "{{}, {" + list1.get(0) + "}, " + "{" + list1.get(1) + "}, " + "{" + list1.get(2) + "}, " + "{" + list1.get(0) + "," + list1.get(1) +  "}, " +
                    "{" + list1.get(0) + "," + list1.get(2) +  "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "}}";
            return str;
        }
        if(list1.size()==4){
            str = "{{}, {" + list1.get(0) + "}, " + "{" + list1.get(1) + "}, " + "{" + list1.get(2) + "}, " + "{" + list1.get(3) + "}, "  + "{" + list1.get(0) + "," + list1.get(1) +  "}, " +
                    "{" + list1.get(0) + "," + list1.get(2) +  "}, " + "{" + list1.get(0) + "," + list1.get(3) +  "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "}}";
            return str;
        }
        if(list1.size()==5){
            str = "{{}, {" + list1.get(0) + "}, " + "{" + list1.get(1) + "}, " + "{" + list1.get(2) + "}, " + "{" + list1.get(3) + "}, " + "{" + list1.get(4) + "}, "  + "{" + list1.get(0) + "," + list1.get(1) +  "}, " +
                    "{" + list1.get(0) + "," + list1.get(2) +  "}, " + "{" + list1.get(0) + "," + list1.get(3) +  "}, " + "{" + list1.get(0) + "," + list1.get(4) +  "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "}}";
            return str;
        }
        if(list1.size()==6){
            str = "{{}, {" + list1.get(0) + "}, " + "{" + list1.get(1) + "}, " + "{" + list1.get(2) + "}, " + "{" + list1.get(3) + "}, " + "{" + list1.get(4) + "}, " + "{" + list1.get(5) + "}, " + "{" + list1.get(0) + "," + list1.get(1) +  "}, " +
                    "{" + list1.get(0) + "," + list1.get(2) +  "}, " + "{" + list1.get(0) + "," + list1.get(3) +  "}, " + "{" + list1.get(0) + "," + list1.get(4) +  "}, " + "{" + list1.get(0) + "," + list1.get(5) +  "}, "+ "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "}, "  + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "}}";
            return str;
        }
        if(list1.size()==7){
            str = "{{}, {" + list1.get(0) + "}, " + "{" + list1.get(1) + "}, " + "{" + list1.get(2) + "}, " + "{" + list1.get(3) + "}, " + "{" + list1.get(4) + "}, " + "{" + list1.get(5) + "}, " + "{" + list1.get(6) + "}, " + "{" + list1.get(0) + "," + list1.get(1) +  "}, " +
                    "{" + list1.get(0) + "," + list1.get(2) +  "}, " + "{" + list1.get(0) + "," + list1.get(3) +  "}, " + "{" + list1.get(0) + "," + list1.get(4) +  "}, " + "{" + list1.get(0) + "," + list1.get(5) +  "}, "  + "{" + list1.get(0) + "," + list1.get(6) +  "}, "+ "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "}, "  + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "," + list1.get(6) +  "}}";
            return str;
        }
        if(list1.size()==8){
            str = "{{}, {" + list1.get(0) + "}, " + "{" + list1.get(1) + "}, " + "{" + list1.get(2) + "}, " + "{" + list1.get(3) + "}, " + "{" + list1.get(4) + "}, " + "{" + list1.get(5) + "}, " + "{" + list1.get(6) + "}, " + "{" + list1.get(7) + "}, " + "{" + list1.get(0) + "," + list1.get(1) +  "}, " +
                    "{" + list1.get(0) + "," + list1.get(2) +  "}, " + "{" + list1.get(0) + "," + list1.get(3) +  "}, " + "{" + list1.get(0) + "," + list1.get(4) +  "}, " + "{" + list1.get(0) + "," + list1.get(5) +  "}, "   + "{" + list1.get(0) + "," + list1.get(6) +  "}, " + "{" + list1.get(0) + "," + list1.get(7) +  "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "}, "  + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "," + list1.get(6) +  "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "," + list1.get(6) + "," + list1.get(7) + "}}";
            return str;
        }
        if(list1.size()==9){
            str = "{{}, {" + list1.get(0) + "}, " + "{" + list1.get(1) + "}, " + "{" + list1.get(2) + "}, " + "{" + list1.get(3) + "}, " + "{" + list1.get(4) + "}, " + "{" + list1.get(5) + "}, " + "{" + list1.get(6) + "}, " + "{" + list1.get(7) + "}, " + "{" + list1.get(8) + "}, " + "{" + list1.get(0) + "," + list1.get(1) +  "}, " +
                    "{" + list1.get(0) + "," + list1.get(2) +  "}, " + "{" + list1.get(0) + "," + list1.get(3) +  "}, " + "{" + list1.get(0) + "," + list1.get(4) +  "}, " + "{" + list1.get(0) + "," + list1.get(5) +  "}, "   + "{" + list1.get(0) + "," + list1.get(6) +  "}, " + "{" + list1.get(0) + "," + list1.get(7) +  "}, " + "{" + list1.get(0) + "," + list1.get(8) +  "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "}, "  + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "," + list1.get(6) +  "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "," + list1.get(6) + "," + list1.get(7) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "," + list1.get(6) + "," + list1.get(7) + "," + list1.get(8) + "}}";
            ;
            return str;
        }
        if(list1.size()==10){
            str = "{{}, {" + list1.get(0) + "}, " + "{" + list1.get(1) + "}, " + "{" + list1.get(2) + "}, " + "{" + list1.get(3) + "}, " + "{" + list1.get(4) + "}, " + "{" + list1.get(5) + "}, " + "{" + list1.get(6) + "}, " + "{" + list1.get(7) + "}, " + "{" + list1.get(8) + "}, " + "{" + list1.get(9) + "}, " + "{" + list1.get(0) + "," + list1.get(1) +  "}, " +
                    "{" + list1.get(0) + "," + list1.get(2) +  "}, " + "{" + list1.get(0) + "," + list1.get(3) +  "}, " + "{" + list1.get(0) + "," + list1.get(4) +  "}, " + "{" + list1.get(0) + "," + list1.get(5) +  "}, "   + "{" + list1.get(0) + "," + list1.get(6) +  "}, " + "{" + list1.get(0) + "," + list1.get(7) +  "}, " + "{" + list1.get(0) + "," + list1.get(8) +  "}, " + "{" + list1.get(0) + "," + list1.get(9) +  "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "}, "  + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "," + list1.get(6) +  "}, " + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "," + list1.get(6) + "," + list1.get(7) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "," + list1.get(6) + "," + list1.get(7) + "," + list1.get(8) + "}, "
                    + "{" + list1.get(0) + "," + list1.get(1) + "," + list1.get(2) + "," + list1.get(3) + "," + list1.get(4) + "," + list1.get(5) + "," + list1.get(6) + "," + list1.get(7) + "," + list1.get(8) + "," + list1.get(9) + "}}";
            return str;
        }


        throw new RuntimeException("Whatchu doing here Homeboy?");

    }

    public void save(String f){
        try{
            FileOutputStream writeData = new FileOutputStream(f + ".ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(mengen);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save1(File file) throws IOException{
        try{
            if(file == null) {
                file = new File("mengenlist.ser");
            }
            FileOutputStream writeData = new FileOutputStream(file + ".ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(mengen);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean load(String f){
        try{
            FileInputStream readData = new FileInputStream(f + ".ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<Menge> mengen2 = (ArrayList<Menge>) readStream.readObject();
            readStream.close();
            mengen = mengen2;
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Menge> load1(File file) throws IOException{
        try{
            if(file == null) {
                throw new IllegalArgumentException("File war null");
            }
            FileInputStream readData = new FileInputStream(file);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<Menge> mengen2 = (ArrayList<Menge>) readStream.readObject();
            readStream.close();
            mengen = mengen2;
            return mengen;
        }catch (Exception e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Shouldn't be here");
    }

    public int getSizeOfArrayList(){
        return mengen.size();
    }


}
