package com.dsa.queue;


/*
Problem Description:
An Animal shelter holds dogs and cats, operates strictly on FIFO basis.
People can adopt either oldest(based on arrival time) of all animals at the shelter or they can
select whether they would prefer dog or cat (oldest animal of that type). People can select specific animal.
Implement operations like enqueue, dequeueAny, dequeueDog, dequeueCat.
 */


/*
Input: Dog1->Cat2->Dog3->Cat4->Dog5->cat6
Output for dequeueDog: Dog1

Input: Cat2->Dog3->Cat4->Dog5->cat6
Output for dequeueAny: Cat2

Input: Dog3->Cat4->Dog5->cat6
Output for dequeueCat: Cat4
 */

/*
Solution:
a) Create 2 queues - one for dog and other cat
b) Create a wrapper class which holds both queues.
c) Store a timestamp or order for each animal when they are enqueued.
d) dequeueDog - poll() from dog queue
d) dequeueCat - poll() from cat queue
d) dequeueAny - peek() from dog and cat queues, find which is older and return it.
 */

public class AnimalShelter {

    private MyQueue<Animal> dogQueue;
    private MyQueue<Animal> catQueue;
    private int order = 0;

    public AnimalShelter() {
        dogQueue = new MyQueue<>();
        catQueue = new MyQueue<>();
    }

    public static void main(String a[]) {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Dog("Dog1"));
        animalShelter.enqueue(new Cat("Cat2"));
        animalShelter.enqueue(new Dog("Dog3"));
        animalShelter.enqueue(new Cat("Cat4"));
        animalShelter.enqueue(new Dog("Dog5"));
        animalShelter.enqueue(new Cat("Cat6"));

        System.out.println("Animal Shelter : " + animalShelter.dogQueue.toString() + animalShelter.catQueue.toString());
        System.out.println(animalShelter.dequeueDog().getName());
        System.out.println(animalShelter.dequeueAny().getName());
        System.out.println(animalShelter.dequeueCat().getName());
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if (animal instanceof Dog) {
            dogQueue.add(animal);
        } else if (animal instanceof Cat) {
            catQueue.add(animal);
        }
    }

    public Animal dequeueDog() {
        return dogQueue.remove();
    }

    public Animal dequeueCat() {
        return catQueue.remove();
    }

    public Animal dequeueAny() {

        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            return null;
        } else if (dogQueue.isEmpty()) {
            return dequeueCat();
        } else if (catQueue.isEmpty()) {
            return dequeueDog();
        }

        Animal dog = dogQueue.peek();
        Animal cat = catQueue.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }
}


abstract class Animal {

    private String name;
    private int order;


    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal animal) {
        return this.order < animal.order;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}
