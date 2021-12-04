package walkingRobotSimulation;

/*
 * 
 * A robot on an infinite XY-plane starts at point (0, 0) facing north. 
 * The robot can receive a sequence of these three possible types of commands:

-2: Turn left 90 degrees.
-1: Turn right 90 degrees.
1 <= k <= 9: Move forward k units, one unit at a time.
Some of the grid squares are obstacles. The ith obstacle is at grid point 
obstacles[i] = (xi, yi). If the robot runs into an obstacle, then it will 
instead stay in its current location and move on to the next command.

Return the maximum Euclidean distance that the robot ever gets from the origin 
squared (i.e. if the distance is 5, return 25).

Note:

North means +Y direction.
East means +X direction.
South means -Y direction.
West means -X direction.
 */

//O(n*m)
public class Solution {
	public int robotSim(int[] commands, int[][] obstacles) {
        char direction = 'u';
        int[] point = {0,0};
        int max = 0;
        // O(n)
        for(int i = 0; i < commands.length; i++){
            int num = commands[i];
            if(num > 0){
            	//O(m)
                movable(point, obstacles, num, direction);
                int distance = (point[0] * point[0]) + (point[1] * point[1]);
                if(distance > max){
                    max = distance;
                }
                //System.out.println(point[0] + " " + point[1] + " " + direction);
            }
            else{
                direction = determineDirection(direction, num);
            }
        }
        
        return max;
    }
    
	// O(m)
    public void movable(int[] point, int[][] obstacles, int num, char direction){
        int move = num;
        boolean obs = false;
        if(direction == 'u'){
            for(int i = 0; i < obstacles.length; i++){
                if(obstacles[i][0] == point[0]){
                    if(obstacles[i][1] <= point[1] + num && obstacles[i][1] > point[1]){
                        if(obs == false){
                            move = obstacles[i][1] - 1;
                            obs = true;
                        }else{
                            if(move >= obstacles[i][1]){
                                move = obstacles[i][1] - 1;
                            }
                        }
                    }
                }
            }
            if(obs == true){
                point[1] = move;
            }
            else{
                point[1] += num;
            }
        }else if(direction == 'd'){
            for(int i = 0; i < obstacles.length; i++){
                if(obstacles[i][0] == point[0]){
                    if(obstacles[i][1] >= point[1] - num && obstacles[i][1] < point[1]){
                        if(obs == false){
                            move = obstacles[i][1] + 1;
                            obs = true;
                        }else{
                            if(move <= obstacles[i][1]){
                                move = obstacles[i][1] + 1;
                            }
                        }
                    }
                }
            }
            if(obs == true){
                point[1] = move; 
            }
            else{
                point[1] -= num;
            }
        }else if(direction == 'l'){
            for(int i = 0; i < obstacles.length; i++){
                if(obstacles[i][1] == point[1]){
                    if(obstacles[i][0] >= point[0] - num && obstacles[i][0] < point[0]){
                        if(obs == false){
                            move = obstacles[i][0] + 1;
                            obs = true;
                        }
                        else{
                            if(move <= obstacles[i][0]){
                                move = obstacles[i][0] + 1;
                            }
                        }
                    }
                }
            }
            if(obs == true){
                point[0] = move;
            }
            else{
                point[0] -= num;
            }
        }else{
            for(int i = 0; i < obstacles.length; i++){
                if(obstacles[i][1] == point[1]){
                    if(obstacles[i][0] <= point[0] + num && obstacles[i][0] > point[0]){
                        if(obs == false){
                            move = obstacles[i][0] - 1;
                            obs = true;
                        }
                        else{
                            if(move >= obstacles[i][0]){
                                move = obstacles[i][0] - 1;
                            }
                        }
  
                    }
                }
            }
            if(obs == true){
                point[0] = move;
            }
            else{
                point[0] += num;
            }
        }
    }
    
    // O(1)
    public char determineDirection(char currentDirection, int num){
        if(currentDirection == 'u' && num == -1){
            return 'r';
        }else if(currentDirection == 'u' && num == -2){
            return 'l';
        }
        else if(currentDirection == 'd' && num == -1){
            return 'l';
        }
        else if(currentDirection == 'd' && num == -2){
            return 'r';
        }
        else if(currentDirection == 'r' && num == -1){
            return 'd';
        }
        else if(currentDirection == 'r' && num == -2){
            return 'u';
        }
        else if(currentDirection == 'l' && num == -1){
            return 'u';
        }
        else{
            return 'd';
        }
    }
}
