
public class RouteCircleCheck {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return false;
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char cur = moves.charAt(i);
            if (cur == 'U') {
                y++;
            }
            if (cur == 'D') {
                y--;
            }
            if (cur == 'L') {
                x--;
            }
            if (cur == 'R') {
                x++;
            }
        }
        return (x == 0 && y == 0);
    }
}
