
public class VowelsCombinations {
    public int getCombinations(int strLength) {
        if (strLength < 0) {
            return -1;
        }
        if (strLength == 0) {
            return 0;
        }
        int aCurrent = 1;
        int eCurrent = 1;
        int iCurrent = 1;
        int oCurrent = 1;
        int uCurrent = 1;
        int modFactor = (int)(Math.pow(10.0, 9.0) + 7);
        int aNext = 0;
        int eNext = 0;
        int iNext = 0;
        int oNext = 0;
        int uNext = 0;
        for (int i = 0; i < strLength; i++) {
            aNext = eCurrent;
            eNext = aCurrent + iCurrent;
            iNext = aCurrent + eCurrent + oCurrent + uCurrent;
            oNext = iCurrent + uCurrent;
            uNext = aCurrent;
            // update recurrence variables
            aCurrent = aNext;
            eCurrent = eNext;
            iCurrent = iNext;
            oCurrent = oNext;
            uCurrent = uNext; 
        }
        int combinations = aCurrent + eCurrent + iCurrent + oCurrent + uCurrent;
        return (combinations % modFactor);
    }
}
