package org.codeforcoffee.marbles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public class Person {
        public int marbles = 0;
        public ArrayList<Person> descendants = new ArrayList<>();
        public int totalMarbles = 0;
        Person() {

        }
        Person(int numOfMarbles) {
            this.marbles = numOfMarbles;
        }

        public int countOfAllFamilyMarbles() {
            int total = 0;
            for (int i = 0; i < descendants.size(); i++) {
                Person temp = descendants.get(i);
                total = total + temp.countOfAllFamilyMarbles();
            }
            total = total + this.marbles;
            return total;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person tywin = new Person(200);
        Person jaime = new Person(100);
        Person cersei = new Person(280);
        Person tyrion = new Person(10);

        tywin.descendants.add(jaime);
        tywin.descendants.add(cersei);
        tywin.descendants.add(tyrion);

        Person joffrey = new Person(4);
        Person myrcella = new Person(50);
        Person tommen = new Person(900);

        cersei.descendants.add(joffrey);
        cersei.descendants.add(myrcella);
        cersei.descendants.add(tommen);

        int totalMarbles = tywin.countOfAllFamilyMarbles();

        String putBreakpointHere = "";

    }
}
