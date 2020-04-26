package solver;

import java.util.ArrayList;
import java.util.LinkedList;

public class DFSStrategy extends SearchMethod {
	
	public DFSStrategy() {
		code = "DFS";
		longName = "Depth-first Search";
		Frontier = new LinkedList<PuzzleState>();
		Searched = new LinkedList<PuzzleState>();
	}

	@Override
	public direction[] Solve(nPuzzle aPuzzle) {
		Searched.add(aPuzzle.StartState);
		return iterate(aPuzzle, aPuzzle.StartState);
	}

	@Override
	public boolean addToFrontier(PuzzleState aState) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected PuzzleState popFrontier() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private direction[] iterate(nPuzzle aPuzzle, PuzzleState state) {
		// state at goal, return path to state.
		if(state.equals(aPuzzle.GoalState))
			return state.GetPathToState();
		
		ArrayList<PuzzleState> states = state.explore();
		
		for(int i = 0; i < states.size(); i++) {
			if(!Searched.contains(states.get(i))) {
				Searched.add(states.get(i));
				direction [] check = iterate(aPuzzle, states.get(i));
				// Solution found, return it.
				if(check != null) {
					return check;
				}
			}
		}
		
		// Solution not found, backtrack;
		return null;
	}

}
