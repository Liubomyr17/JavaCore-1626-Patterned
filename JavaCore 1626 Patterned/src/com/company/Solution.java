package com.company;

/*

1626 Modeling
Find out how the program works.
In the image and likeness of CountDownRunnable, create a thread CountUpRunnable, which outputs values ​​in the normal order - from 1 to number.

Requirements:
1. The CountUpRunnable class must implement the Runnable interface.
2. The CountUpRunnable class must have a public run method without parameters.
3. The CountUpRunnable class run method should run for approximately 2.5 seconds.
4. The run method of the CountUpRunnable class should output the flow name, colon, and counter value from 1 to 5 every half a second (for example: "Increase: 1").
5. The run method of the CountUpRunnable class should call Thread.sleep (500).


 */

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountDownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }

    public static class CountUpRunnable implements Runnable {
        //Add your code here - добавь код тут
        private int countIndexUp = 0;

        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    countIndexUp += 1;
                    System.out.println(toString());
                    if (countIndexUp == Solution.number) return;
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}


