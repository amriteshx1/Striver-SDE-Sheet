// Optimal Approach: Greedy Algorithm

class Meeting {
    int start;
    int end;
    int pos;

    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class Solution {
    public int maxMeetings(int[] start, int[] end) {

        int n = start.length;

        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i], i + 1);
        }

        Arrays.sort(meetings, (a, b) -> a.end - b.end);

        int count = 1;
        int freeTime = meetings[0].end;

        // If asked to return meeting numbers:
        // List<Integer> selected = new ArrayList<>();
        // selected.add(meetings[0].pos);

        for (int i = 1; i < n; i++) {
            if (meetings[i].start > freeTime) {
                count++;
                freeTime = meetings[i].end;

                // selected.add(meetings[i].pos);
            }
        }

        return count;
    }
}