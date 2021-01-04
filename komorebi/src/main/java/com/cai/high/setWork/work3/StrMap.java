//package high.setWork.work3;
//
//import java.util.*;
//
///**
// * @author Cai
// * @time 2020-10-12-11:03
// */
//public class StrMap {
//
//    public static void main(String[] args) {
//        String[] str = {"a", "b", "b", "a", "c", "u", "e", "q", "t"};
//        var hp = new HashMap<>();
//        for (int i = 0; i < str.length; i++) {
//            if (hp.containsKey(str[i])) {
//                int cut = (int) hp.get(str[i]);
//                hp.remove(str[i]);
//                hp.put(str[i], cut + 1);
//            } else {
//                hp.put(str[i], 1);
//            }
//        }
//        System.out.println(hp);
//    }
//}
