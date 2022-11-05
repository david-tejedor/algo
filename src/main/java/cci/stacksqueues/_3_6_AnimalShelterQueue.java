package cci.stacksqueues;

import java.util.LinkedList;
import java.util.Stack;
import java.util.UUID;

import static cci.stacksqueues.Animal.*;

public class _3_6_AnimalShelterQueue {

//    Shelter with dogs & cats
//            FIFO
//    enqueue / dequeueAny / dequeueDog / dequeueCat
//    may use built-in LinkedList

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Animal(Type.cat));
        animalShelter.enqueue(new Animal(Type.cat));
        animalShelter.enqueue(new Animal(Type.dog));
        animalShelter.enqueue(new Animal(Type.cat));
        animalShelter.enqueue(new Animal(Type.dog));

        animalShelter.dequeue(Type.dog);

        System.out.println(animalShelter);
    }

}

class AnimalShelter {
    LinkedList<Animal> list = new LinkedList();

    public void enqueue(Animal animal) {
        list.add(animal);
    }

    public Animal dequeueAny() {
        return list.poll();
    }

    public Animal dequeueCat() {
        return dequeue(Type.cat);
    }

    public Animal dequeueDog() {
        return dequeue(Type.dog);
    }

    public Animal dequeue(Type type) {
        Stack<Animal> temp = new Stack();
        while (!list.isEmpty()) {
            Animal last = list.remove();
            if (last.type == type) {
                while (!temp.isEmpty())
                    list.add(temp.pop());
                return last;
            }

            temp.push(last);
        }

        return null;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

class Animal {
    public final UUID id;
    public final Type type;

    public Animal(Type type) {
        this.id = UUID.randomUUID();
        this.type = type;
    }

    @Override
    public String toString() {
        return type.name() + " - " + id;
    }

    enum Type {
        dog, cat
    }
}