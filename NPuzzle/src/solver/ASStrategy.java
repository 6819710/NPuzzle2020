package solver;

import java.util.ArrayList;
import java.util.LinkedList;

public class ASStrategy extends SearchMethod {
	
	
	public ASStrategy() {
		code = "AS";
		longName = "A Star Search";
		Frontier = new LinkedList<PuzzleState>();
		Searched = new LinkedList<PuzzleState>();
	}

	@Override
	public direction[] Solve(nPuzzle aPuzzle) {
		// Initialize frontier list with starting state.
		addToFrontier(aPuzzle.StartState);
		
		// While the open list is not empty:
		while(Frontier.size() > 0) {
			// Find the frontier with the lowest F value.
			PuzzleState q = popFrontier();
			
			ArrayList<PuzzleState> newStates = q.explore();
			
			for(PuzzleState n : newStates) {
				// If goal state return path to state.
				if(n.equals(aPuzzle.GoalState))
					return n.GetPathToState();
				// Else add state to open list.
				else {
					n.HeuristicValue = HeuristicValue(n, aPuzzle.GoalState);
					n.setEvaluationFunction(n.HeuristicValue + n.Cost);
					addToFrontier(n);
				}
			}
			
		}
		
		return null;
	}

	@Override
	public boolean addToFrontier(PuzzleState aState) {
		//We only want to add the new state to the fringe if it doesn't exist
		
		if(Searched.contains(aState)) {
			return false;
		}
		else if (Frontier.contains(aState)) {
			for(PuzzleState n : Frontier) {
				if(n.getEvaluationFunction() <= aState.getEvaluationFunction())
					return false;
			}
		}
		Frontier.add(aState);
		return true;
	}

	@Override
	protected PuzzleState popFrontier() {
		PuzzleState lState = Frontier.getFirst();
		int f = lState.getEvaluationFunction();
		
		// Find state with greatest f-value.
		for(int i = 1; i < Frontier.size(); i++) {
			if(f > Frontier.get(i).getEvaluationFunction()) {
				lState = Frontier.get(i);
				f = Frontier.get(i).getEvaluationFunction();
			}
		}
		
		//remove found state from list.		
		Frontier.remove(lState);
		
		
		//add it to the list of searched states so that duplicates are recognised.
		Searched.add(lState);
		
		return lState;
	}
	
	private int HeuristicValue(PuzzleState aState, PuzzleState goalState)
	{
		//find out how many elements in aState match the goalState
		//return the number of elements that don't match
		int heuristic = 0;
		for(int i = 0; i < aState.Puzzle.length; i++)
		{
			for(int j = 0; j < aState.Puzzle[i].length; j++)
			{
				if(aState.Puzzle[i][j] != goalState.Puzzle[i][j])
					heuristic++;
			}
		}
		
		return heuristic;
	}
}
