package greedy;

/**
 * Created by ludao on 2017/3/31.
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||cost==null){
            return -1;
        }
        int length = gas.length;
        int temp;
        for(int i=0;i<length;){
            temp = gas[i] - cost[i];
            int j = i+1;
            for(;j<i+length&&temp>=0;j++){
                int index = j>=length?j-length:j;
                temp = temp + gas[index] - cost[index];
            }
            if(temp>=0){
                return i;
            }
            i=j;
        }
        return -1;
    }

    public int canCompleteCircuit_v2(int[] gas,int[] cost){
        if(gas==null||cost==null){
            return -1;
        }
        int length = gas.length;
        int costTotal=0,stationTotal=0,start=0;
        for(int i=0;i<length;i++){
            stationTotal += (gas[i] - cost[i]);
            if(stationTotal<0){
                costTotal += stationTotal;
                stationTotal = 0;
                start = i+1;
            }
        }
        return costTotal + stationTotal<0?-1:start;
    }


    public static void main(String[] args){
        int[] gas = {1,2,3,3},cost = {2,1,5,1};
        GasStation_134 gasStation_134 = new GasStation_134();
        int result = gasStation_134.canCompleteCircuit(gas,cost);
        return;
    }
}
