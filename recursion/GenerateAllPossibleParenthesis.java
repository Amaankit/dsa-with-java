package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllPossibleParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(n, n, "", result);
        return result;
    }

    private void solve(int openCount, int closeCount, String op, List<String> result) {
        if (openCount == 0 && closeCount == 0) {
            result.add(op);
            return;
        }

        if (openCount > 0) {
            solve(openCount - 1, closeCount, op + "(", result);
        }

        if (closeCount > openCount) {
            solve(openCount, closeCount - 1, op + ")", result);
        }
    }
}

