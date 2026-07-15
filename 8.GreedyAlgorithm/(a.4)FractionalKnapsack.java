// Optimal

class Item {
    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, long cap) {
        int n = val.length;

        Item[] items = new Item[n];
        double totalValue = 0;

        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        Arrays.sort(items, (a, b) ->
            Double.compare(
                (double) b.value / b.weight,
                (double) a.value / a.weight
            )
        );

        for(int i = 0; i < n; i++){
            if(items[i].weight <= cap){
                totalValue += items[i].value;
                cap = cap - items[i].weight;
            }else{
                totalValue += ((double) items[i].value / items[i].weight) * cap;
                break;
            }
        }

        return totalValue;
    }
}