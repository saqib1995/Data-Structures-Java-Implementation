public class BitMask {

    public BitMask(){}

    public int setBit(int bitmask , int position) {
        int mask = 1;
        mask = mask<<position;

        return (bitmask | mask);
    }

    public int clearBit(int bitmask, int position) {
        int mask = 1;
        mask = mask<<position;
        mask = ~mask;
        return (bitmask & mask);
    }

    public int toggleBit(int bitmask , int position) {
        if(isSet(bitmask , position)) {
            return clearBit(bitmask , position);
        }
        return setBit(bitmask , position);
    }


    public boolean isSet(int bitmask , int position) {
        int mask = bitmask >> position;
        return (mask & 1) == 1;
    }



}
