public static void moveRobot(Robot robot, int toX, int toY) {
    //robot.stepForward(); // your implementation here
        if (toX > robot.getX()) {
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            }
        } else {
                while (robot.getDirection() != Direction.LEFT) {
                 robot.turnRight();
                }
        }
        while (toX != robot.getX()) {
            robot.stepForward();
        }

        if (toY > robot.getY()) {
        while (robot.getDirection() != Direction.UP) {
        robot.turnRight();
        }
        } else {
        while (robot.getDirection() != Direction.DOWN) {
        robot.turnRight();
        }
        }
        while (toY != robot.getY()) {
            robot.stepForward();
        }

}