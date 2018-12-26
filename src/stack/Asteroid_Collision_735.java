package stack;

import java.util.Stack;

/**
 * Created by Anson on 12/26/18.
 */
public class Asteroid_Collision_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
                continue;
            }
            if (stack.peek() * asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            while (!stack.isEmpty()) {
                int temp = stack.peek();
                if (temp * asteroid < 0) {
                    if (temp < 0 && asteroid > 0) {
                        stack.push(asteroid);
                        break;
                    }
                    if (Math.abs(temp) > Math.abs(asteroid)) {
                        break;
                    } else if (Math.abs(temp) == Math.abs(asteroid)) {
                        stack.pop();
                        break;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(asteroid);
                            break;
                        }
                    }
                } else {
                    stack.push(asteroid);
                    break;
                }
            }
        }
        return stack.stream().mapToInt(item -> (int)item).toArray();
    }
}
