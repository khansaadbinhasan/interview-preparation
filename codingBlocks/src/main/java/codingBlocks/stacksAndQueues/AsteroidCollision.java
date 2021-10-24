package codingBlocks.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        new AsteroidCollision().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] asteroids = new int[N];

        for (int i = 0; i < N; i++)
            asteroids[i] = sc.nextInt();

        int[] remAsteroids = asteroidCollision(asteroids);

        for( int asteroid: remAsteroids )
            System.out.print(asteroid + " ");
    }

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> remAsteroidStack = new Stack<>();

        for( int asteroid: asteroids){
            if( remAsteroidStack.isEmpty() ) {
                remAsteroidStack.push(asteroid);
                continue;
            }

            if( asteroid < 0 ){
                while ( !remAsteroidStack.isEmpty() &&
                        remAsteroidStack.peek() > 0 &&
                        remAsteroidStack.peek() < Math.abs(asteroid) ) {
                    remAsteroidStack.pop();
                }

                if ( !remAsteroidStack.isEmpty() &&
                        remAsteroidStack.peek() > 0 &&
                        remAsteroidStack.peek() == Math.abs(asteroid) ){
                    remAsteroidStack.pop();
                    continue;
                }
            }


            if( remAsteroidStack.isEmpty() ) remAsteroidStack.push(asteroid);

            else if ( remAsteroidStack.peek() * asteroid > 0 || (remAsteroidStack.peek() < 0 && asteroid > 0) )
                remAsteroidStack.push(asteroid);
        }

        int[] remAsteroid = new int[remAsteroidStack.size()];

        int ind = 0;
        for( int ast: remAsteroidStack ){
            remAsteroid[ind] = ast;
            ind++;
        }

        return remAsteroid;
    }

}
