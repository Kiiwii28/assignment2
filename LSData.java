public class LSData implements Comparable<LSData>{
    /**
     * this is an object class that contains two pieces of data to minimize excess string handling
     * in separating keys from the input file's line
     */
  String sParam;
  String sAreas;

  public LSData(String pParam, String pAreas){
      sParam = pParam;
      sAreas = pAreas;
  }

  public boolean equalsTo(String pParam){
      return sParam.equals(pParam);
  }


    public String toString() {
        return  "Time Slot: ["+ sParam + "], Areas:"+ sAreas + ".";
    }

    public String getKey(){
        return sParam;
    }

    /**
     * compare to only compares the key to avoid complications
     * @param other
     * @return
     */
    @Override
    public int compareTo(LSData other) {

        if (other.equalsTo(sParam)) return 0;
        if (other.getKey().compareTo(sParam) > 0) return 1;
            else return -1;

    }
}

