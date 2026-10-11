class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>();
        for(int i = 0; i < position.length;i++){
            double pos = position[i];
            double spd = speed[i];
            double tar = target;
            double timeToTarget = ((tar - pos) / spd);
            map.put(position[i], timeToTarget);
        }
        List<Double> values = new ArrayList<>(map.values());
        for(int i = 0; i < values.size() - 1; i++){
            double temp = values.get(i);
            if (temp <= values.get(i+1)){
                values.remove(Double.valueOf(temp));
                i--;
                if(i >= 0){
                    i--;
                }
            }
        }
        return values.size();
    }
}
