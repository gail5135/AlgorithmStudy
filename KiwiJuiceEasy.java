public class KiwiJuiceEasy {
    public int[] thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId){
        for(int i=0; i < fromId.length; ++i){
            if(bottles[fromId[i]]+bottles[toId[i]] >= capacities[toId[i]]){
                bottles[fromId[i]] = bottles[fromId[i]] + bottles[toId[i]] - capacities[toId[i]];
                bottles[toId[i]] = capacities[toId[i]];
            }
            else{
                bottles[toId[i]] += bottles[fromId[i]];
                bottles[fromId[i]] = 0;
            }

        }

        return bottles;
    }
}
