/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
        int s2start = 0;
        for( int i = 0; i < usersData.size()-1 ; i++ ){

            if (usersData.get(i) != "1" && usersData.get(i) != "2" &&
                usersData.get(i) != "3" && usersData.get(i) != "4" &&
                usersData.get(i) != "5" && usersData.get(i) != "6" &&
                usersData.get(i) != "7" && usersData.get(i) != "8" &&
                usersData.get(i) != "9" && usersData.get(i) != "10" &&
                usersData.get(i) != "J" && usersData.get(i) != "Q" &&
                usersData.get(i) != "K" && usersData.get(i) != "A"){
                    usersData.remove(i);
                }
            /*
            if (usersData.get(i) == "J") usersData.set(i,"11");
            else if (usersData.get(i) == "Q") usersData.set(i,"12");
            else if (usersData.get(i) == "K") usersData.set(i,"13");
            */
        }
        for( int i = 0; i < usersData.size()-1 ; i++ ){
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0)
                {s2start = i+1;}
        }
        //debugging
        //System.out.println(usersData +"DATA");
        merge (0,s2start,usersData.size());

    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        for (int i = start0 ; i < start1 ; i++){
            list1.add(usersData.get(i));
        }
        //debugging
        System.out.println(list1);
        for (int i = start1 ; i < nItems ; i++){
            list2.add(usersData.get(i));
        }
        //debugging
        System.out.println(list2);
        int iterate = 0;
        while (list1.size() > 0 && list2.size() > 0){
            if( list1.get(0).compareTo(list2.get(0)) > 0){
                usersData.set(iterate,list2.get(0));
                list2.remove(0);
            }
            else{
              usersData.set(iterate,list1.get(0));
              list1.remove(0);
            }
            iterate += 1;
        }
        while(list2.size() > 0){
            usersData.set(iterate,list2.get(0));
            list2.remove(0);
            iterate+=1;
        }
        while(list1.size() > 0){
            usersData.set(iterate,list1.get(0));
            list1.remove(0);
            iterate+=1;
        }
        while (iterate < usersData.size()){
            usersData.remove(iterate);
            iterate += 1;
        }
        usersData.remove(usersData.size()-1);
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData;
    }


    /**
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}
