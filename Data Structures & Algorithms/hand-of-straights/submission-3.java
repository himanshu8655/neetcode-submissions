class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
			return false;
        if(groupSize == 1)
            return true;
		Arrays.sort(hand);
		int n = hand.length;
		LinkedList<List<Integer>> grps = new LinkedList<>();

		for (int j = 0; j < n; j++) {
			int num = hand[j];
			boolean isUsed = false;
			int m = grps.size();
 			for (int i = 0; i<m; i++) {
				List<Integer> grp = grps.get(i);
				if (grp.get(grp.size() - 1) + 1 == num) {
					isUsed = true;
					grp.add(num);
					if (grp.size() == groupSize) {
						grps.remove(i);
					}
					break;
				}
			}
			if (!isUsed) {
				grps.add(new ArrayList<>(Arrays.asList(num)));
			}
			isUsed = false;
		}

		return grps.isEmpty();
	}
}
